package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class PlayerInputType(val type: Int) {
    GAME(3), // 3 자리 수 입력 (컴퓨터 숫자 맞추기)
    REPLAY(1) // 1 자리 수 입력 (게임 재시작 여부)
}

fun main() {

    var play = true // 게임 진행 결정

    val computerList = mutableListOf<Int>() // 컴퓨터의 숫자를 담을 리스트
    val playerList = mutableListOf<Int>() // 플레이어의 숫자를 담을 리스트
    var playerString: String? // 플레이어의 입력을 받아 playerList에 담아줌

    println("숫자 야구 게임을 시작합니다.")

    while (play) {
        generateComputerList(computerList) // 컴퓨터의 숫자 생성

        while (true) {
            print("숫자를 입력해주세요 : ")
            playerString = Console.readLine()
            parsingPlayerInput(playerList, playerString, PlayerInputType.GAME.type) // 플레이어의 세자리 입력 검증 & 파싱

            // 게임 결과 분기
            if (!compareList(computerList, playerList)) {
                // 정답을 못 맞췄다. 계속해서 맞추기
                continue
            } else {
                // 3 스트라이크. 게임 끝.
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

                playerString = Console.readLine()
                parsingPlayerInput(playerList, playerString, PlayerInputType.REPLAY.type) // 플에이어의 한자리 입력 검증 & 파싱

                // 재시작 여부 값이 올바름
                play = (playerList[0] == 1)
                break // while(true) 종료`
            }
        }
    }
}

// 컴퓨터의 숫자 뽑기 함수
fun generateComputerList(computerList: MutableList<Int>) {
    // 초기화
    computerList.clear()
    // 생성
    while (computerList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (randomNumber !in computerList) {
            computerList.add(randomNumber)
        }
    }
}

// 사용자 입력(1. 세자리 입력 값 2. 게임 재시작 여부)을 검증 후 playerList에 정수로 담아줌
fun parsingPlayerInput(playerList: MutableList<Int>, playerInput: String?, numberOfDigits: Int) {

    // 초기화
    playerList.clear()
    // 입력이 없거나 자릿수가 맞지 않으면 예외
    if (playerInput == null || playerInput.length != numberOfDigits) throw IllegalArgumentException()

    for (index in playerInput.indices) {
        // 숫자가 아닌 예외
        if (playerInput[index] < '1' || playerInput[index] > '9') throw IllegalArgumentException()
        // 숫자가 중복된 예외
        if (playerList.contains(playerInput[index] - '0')) throw IllegalArgumentException()
        // 정수 리스트에 넣어주기
        playerList.add(playerInput[index] - '0')
    }
}

// 게임 결과 처리 함수
fun compareList(computerList: List<Int>, playerList: List<Int>): Boolean {

    var result = "" // 결과
    var strikes = 0 // 스트라이크
    var balls = 0 // 볼

    for (i in computerList.indices) {
        if (computerList[i] == playerList[i]) {
            strikes++
        } else if (computerList.contains(playerList[i])) {
            balls++
        }
    }

    result = if (balls > 0 && strikes > 0)
        "${balls}볼 ${strikes}스트라이크"
    else if (balls > 0)
        "${balls}볼"
    else if (strikes > 0)
        "${strikes}스트라이크"
    else
        "낫싱"

    println(result)
    return strikes == 3
}






