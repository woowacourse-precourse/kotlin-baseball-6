package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    var gameStart = true

    while (gameStart) {
        val comNumber = randomNumbers()
        var gameFinish = false

        while (!gameFinish) {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()!!

            inputError(userInput)

            gameFinish = evaluateGuess(comNumber, userInput)
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        gameStart = Console.readLine()!! == "1"
    }
}
fun randomNumbers(): String {

    val numbers = mutableListOf<Int>()

    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)

        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }

    return numbers.joinToString("")
}

fun inputError(input: String) {

    if (input.length != 3 || !input.all { it in '1'..'9' }) {
        throw IllegalArgumentException("세 자리 숫자(1-9)를 입력하세요.")
    }
}

fun evaluateGuess(answers: String, guess: String): Boolean {

    var strikes = 0
    var balls = 0

    for ((index, c) in guess.withIndex()) {
        if (c in answers) {
            if (answers[index] == c)
                strikes++
            else
                balls++
        }
    }

    when{
        strikes ==0 && balls ==0 -> println("낫싱")
        strikes ==3 -> {
            println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return true
        }
        else -> println("${if(balls != 0) "${balls}볼 " else ""}${if(strikes != 0) "${strikes}스트라이크" else ""}")
    }

    return false

}