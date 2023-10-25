package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    playGame()

    while (true) {
        print("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요: ")
        val input = Console.readLine()
        if (input == "2") {
            break
        } else if (input == "1") {
            playGame()
        }
        else {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }

    println("게임 종료!")
}

fun playGame() { // 게임 시작
    val computerNumbers = generateComputerNumbers()

    while (true) {
        val userGuess = getUserInput()

        val result = checkGuess(userGuess, computerNumbers)
        println("결과: $result")

        if (result == "3 스트라이크") {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }

    println("게임 종료!")
}


fun generateComputerNumbers(): List<Int> { // 컴퓨터 랜덤 변수 설정
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (randomNum !in numbers) {
            numbers.add(randomNum)
        }
    }
    return numbers
}

fun getUserInput(): List<Int> { // 유저 입력값 받고 예외처리
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()

    if (input == null || input.length != 3 || !input.all { it in '1'..'9' } || input.toSet().size != 3) {
        throw IllegalArgumentException("잘못된 입력입니다. 서로 다른 3자리 숫자를 입력하세요.")
    }

    return input.map { it.toString().toInt() }
}

fun checkGuess(userGuess: List<Int>, computerNumbers: List<Int>): String { // 스트라이크/볼/낫싱 판정
    var strikes = 0
    var balls = 0

    for (i in userGuess.indices) {
        if (userGuess[i] == computerNumbers[i]) {
            strikes++
        } else if (userGuess[i] in computerNumbers) {
            balls++
        }
    }

    return when {
        strikes == 3 -> "3 스트라이크"
        strikes > 0 || balls > 0 -> "$strikes 스트라이크, $balls 볼"
        else -> "낫싱"
    }
}

