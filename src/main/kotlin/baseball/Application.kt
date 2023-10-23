package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

// 프로그램의 시작점
fun main() {

    // 게임을 시작한다.
    startGame()

//    try {
        // 게임 재시작 반복문
        while (true) {
            // 컴퓨터 숫자를 생성해 computer에 담는다.
            val computer = createComputerNumber()
//          println(computer) // 구현용 임시 출력

            // 게임 라운드 반복문
            while (true) {
                // 플레이어가 숫자를 입력해 정답에 시도한다.
                if (!playerTryAnswer(computer)) break
                // 예외 발생 시 -> false + restartGame = false
                // 3스트라이크 -> false
                // 나머지 -> true
            }

            // println("여긴 루프밖이야") // 구현용 임시 출력

            // 게임 재시작 또는 프로그램 종료
            if (!restartGameOrEndProgram()) break

        }

//    } catch (e : IllegalArgumentException) {
////        println(e.message)
//    }

//    println("프로그램 종료") // 구현용 임시 출력
}

fun playerTryAnswer(computer: MutableList<Int>) : Boolean {
    // 플레이어 숫자를 입력 받는다.
    val getPlayer = getPlayerNumber()
//    println(getPlayer) // 구현용 임시 출력

    // 플레이어 숫자를 검사하고, 예외를 처리한다.
//    try {
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

//    } catch (e: IllegalArgumentException) {
//        // 예외가 있으면
////        println(e.message) // 구현용 임시 출력
//        // 루프문 탈출
//        return false
//    }

    return true
}

fun startGame() {
    println("숫자 야구 게임을 시작합니다.")
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

    print("숫자를 입력해주세요 : ")

    val getPlayer = readLine()

    return getPlayer
}

fun validatePlayerNumber(player: String): List<Int> {

    // 3자리 검증
    if (player.length != 3) {
        throw IllegalArgumentException("3자리만 입력해 주세요")
    }

    // player 타입을 String에서 List<String>으로 변환
    val playerList = player.toList()

    // playerList 타입을 Int로 변환 후 null 요소 제거
    val playerIntOrNullList = playerList.mapNotNull { it.digitToIntOrNull() }

    if (playerIntOrNullList.size != 3) {
        throw IllegalArgumentException("숫자만 입력해 주세요")
    }

    // playerIntORNullList에 중복된 값이 있는지 set함수로 검증
    val playerSet = playerIntOrNullList.toSet()

    if (playerSet.size != 3) {
        throw IllegalArgumentException("중복된 숫자가 있어요")
    }

    return playerIntOrNullList
}

data class PlayerScore (
    var strike: Int = 0,
    var ball: Int = 0,
    var nothing: Boolean = false
    )

fun comparePlayerAndComputer(computer: MutableList<Int>, player: List<Int>, playerScore: PlayerScore) : PlayerScore {

    for (i in player.indices) {
        if (player[i] == computer[i]) {
            playerScore.strike++
        }
    }

    for (i in player.indices) {
        for (j in computer.indices) {
            if (player[i] == computer[j]) {
                playerScore.ball++
            }
        }
    }

    playerScore.ball -= playerScore.strike

    if (playerScore.strike == 0 && playerScore.ball == 0) {
        playerScore.nothing = true
    }

    return playerScore
}

fun printPlayerScore(calculatePlayerScore: PlayerScore) {

    var result = ""

    // 하나도 없는 경우
    if (calculatePlayerScore.nothing) {
        result = "낫싱"
        return println(result)
    }

    // 3개의 숫자를 모두 맞힐 경우
    if (calculatePlayerScore.strike == 3) {
        result = "${calculatePlayerScore.strike}스트라이크"
        println(result)
        endGame()
        return
    }

    // 입력한 수에 대한 볼 개수 출력
    if (calculatePlayerScore.ball > 0) {
        result += "${calculatePlayerScore.ball}볼 "
    }

    // 입력한 수에 대한 스트라이크 개수 출력
    if (calculatePlayerScore.strike > 0) {
        result += "${calculatePlayerScore.strike}스트라이크"
    }

    return println(result.trim())
}

fun endGame() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun restartGameOrEndProgram() : Boolean {

    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val coin = readLine()

    val coinInt = coin.toIntOrNull()

    // 숫자 검증
    if (coinInt != 1 && coinInt != 2) {
        throw IllegalArgumentException("1또는 2만 입력해 주세요")
    }

    if (coinInt == 1) {
        return true
    }

    return false
}