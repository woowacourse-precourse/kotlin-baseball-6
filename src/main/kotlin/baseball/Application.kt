package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

// 프로그램의 시작점
fun main() {
    // 게임을 시작한다.
    startGame()

    // 게임 재시작 반복문
    do {
        // 컴퓨터 숫자를 생성해 computer에 담는다.
        val computer = createComputerNumber()

        // 게임 라운드 반복문
        do {
            if (!playerTryAnswer(computer)) break
        } while (true)

    } while (restartGameOrEndProgram()) // 게임 재시작(true) 또는 프로그램(false) 종료

}

fun playerTryAnswer(computer: MutableList<Int>): Boolean {
    // 플레이어 숫자를 입력 받는다.
    val getPlayer = getPlayerNumber()

    // 플레이어 숫자를 검사한다.
    val player = validatePlayerNumber(getPlayer)

    // 예외가 없으면, 플레이어의 숫자와 컴퓨터의 숫자를 비교한다.
    val calculatePlayerScore = comparePlayerAndComputer(computer, player, playerScore = PlayerScore())

    // 플레이어의 점수를 출력한다.
    printPlayerScore(calculatePlayerScore)

    // 3스트라이크일 때 루프문을 탈출해 게임 종료
    if (calculatePlayerScore.strike == 3) {
        return false
    }
    return true
}

fun startGame() {
    println(Const.GAME_START)
}

fun createComputerNumber(): MutableList<Int> {

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun getPlayerNumber(): String {

    print(Const.GAME_REQUEST_PLAYER_NUMBER)

    val getPlayer = readLine()

    return getPlayer
}

fun validatePlayerNumber(player: String): List<Int> {

    // 3자리 검증
    if (player.length != 3) {
        throw IllegalArgumentException(Const.ERROR_NOT_3_DIGIT)
    }

    // player 타입을 String에서 List<String>으로 변환
    val playerList = player.toList()

    // playerList 타입을 Int로 변환 후 null 요소 제거
    val playerIntOrNullList = playerList.mapNotNull { it.digitToIntOrNull() }

    if (playerIntOrNullList.size != 3) {
        throw IllegalArgumentException(Const.ERROR_NOT_NUMBER)
    }

    // playerIntORNullList에 중복된 값이 있는지 set함수로 검증
    val playerSet = playerIntOrNullList.toSet()

    if (playerSet.size != 3) {
        throw IllegalArgumentException(Const.ERROR_DUPLICATE_NUMBER)
    }

    // 0이 있는지 확인
    val playerZero = playerSet.contains(0)

    if (playerZero) {
        throw IllegalArgumentException(Const.ERROR_0)
    }

    return playerIntOrNullList
}

fun comparePlayerAndComputer(computer: MutableList<Int>, player: List<Int>, playerScore: PlayerScore): PlayerScore {

    // 같은 인덱스 끼리 짝지어 pair타입으로 리스트 구성
    val zipPlayerAndComputer = player.zip(computer)

    zipPlayerAndComputer.forEach { (playerItem, computerItem) ->
        if (playerItem == computerItem) {
            playerScore.strike++
        }
    }

    // 2개의 컬렉션의 교집합 set으로 반환
    val intersectPlayerAndComputer = player.intersect(computer.toSet())

    playerScore.ball = intersectPlayerAndComputer.size - playerScore.strike

    if (playerScore.strike == 0 && playerScore.ball == 0) {
        playerScore.nothing = true
    }

    return playerScore
}

fun printPlayerScore(calculatePlayerScore: PlayerScore) {

    var result = ""

    // 하나도 없는 경우
    if (calculatePlayerScore.nothing) {
        result = Const.PLAYER_SCORE_NOTHING
        return println(result)
    }

    // 3개의 숫자를 모두 맞힐 경우
    if (calculatePlayerScore.strike == 3) {
        result = "${calculatePlayerScore.strike}${Const.PLAYER_SCORE_STRIKE}"
        println(result)
        endGame()
        return
    }

    // 입력한 수에 대한 볼 개수 출력
    if (calculatePlayerScore.ball > 0) {
        result += "${calculatePlayerScore.ball}${Const.PLAYER_SCORE_BALL} "
    }

    // 입력한 수에 대한 스트라이크 개수 출력
    if (calculatePlayerScore.strike > 0) {
        result += "${calculatePlayerScore.strike}${Const.PLAYER_SCORE_STRIKE}"
    }

    return println(result.trim())
}

fun endGame() {
    println(Const.GAME_END)
}

fun restartGameOrEndProgram(): Boolean {

    println(Const.GAME_RESTART_OR_PROGRAM_END)

    val coin = readLine()

    val coinInt = coin.toIntOrNull()

    // 숫자 검증
    if (coinInt != 1 && coinInt != 2) {
        throw IllegalArgumentException(Const.ERROR_NOT_1_OR_2)
    }

    if (coinInt == 1) {
        return true
    }

    return false
}