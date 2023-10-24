package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun generateRandomNumber(): List<Int> {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers.subList(0, 3)
}

fun getUserInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    try {
        if (input == null || input.length != 3 || input.toSet().size != 3 || !input.all { it.isDigit() }) {
            throw IllegalArgumentException()
        }
    } catch (e: IllegalArgumentException) {
        exitProcess(0)
    }
    return input.map { it.toString().toInt() }
}

fun calculateHint(secret: List<Int>, guess: List<Int>): Pair<Int, Int> {
    var strikes = 0
    var balls = 0
    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            strikes++
        } else if (secret.contains(guess[i])) {
            balls++
        }
    }
    return strikes to balls
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var playAgain = true

    while (playAgain) {
        val randomNumber by lazy {
            generateRandomNumber()
        }
        var attempts = 0

        while (true) {
            try {
                val userGuess = getUserInput()
                val (strikes, balls) = calculateHint(randomNumber, userGuess)

                if (strikes == 3) {
                    println("${strikes}스트라이크")
                    println("축하합니다! 정답을 맞추셨습니다.")
                    break
                } else if(strikes == 0 && balls == 0){
                    println("낫싱")
                } else if(strikes > 0 && balls == 0){
                    println("${strikes}스트라이크")
                } else if(strikes == 0 && balls > 0){
                    println("${balls}볼")
                } else{
                    println("${balls}볼 ${strikes}스트라이크")
                }

                attempts++
            } catch (e: IllegalArgumentException) {
                println("${e.message} 다시 시도하세요.")
            }
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        playAgain = readLine()?.trim()?.equals("y", ignoreCase = true) ?: false
    }

    println("게임을 종료합니다. 수고하셨습니다!")
}


