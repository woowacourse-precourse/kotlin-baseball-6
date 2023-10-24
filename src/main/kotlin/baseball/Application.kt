package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    var computerRandomNumber = getRandomNumber()

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        var ball = 0
        var strike = 0

        print("숫자를 입력해주세요 : ")
        val userGuessNumber = Console.readLine()
        isThreeDigitNumber(userGuessNumber)

        for (i in computerRandomNumber.indices) {
            if (computerRandomNumber[i] == userGuessNumber[i].toString().toInt()) {
                strike++
            }
            else if (userGuessNumber[i].toString().toInt() in computerRandomNumber) {
                ball++
            }
        }

        when {
            strike == 3 -> {
                println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

                val inputOneIsPlayTwoIsEnd = Console.readLine()
                when (inputOneIsPlayTwoIsEnd) {
                    "1" -> computerRandomNumber = getRandomNumber()
                    "2" -> {
                        println("게임 종료")
                        break
                    }
                    else -> throw IllegalArgumentException("1과2중 에서만 입력해주세요")
                }
            }
            ball == 0 && strike == 0 -> println("낫싱")
            ball != 0 && strike != 0 -> println("${ball}볼 ${strike}스트라이크")
            ball == 0 && strike != 0 -> println("$strike 스트라이크")
            else -> println("$ball 볼")
        }
    }
}

fun isThreeDigitNumber(userGuessNumbers: String): Boolean {
    when {
        userGuessNumbers.isBlank() -> throw IllegalArgumentException("비어있습니다.")
        !userGuessNumbers.all { it.isDigit()} -> throw IllegalArgumentException("숫자만 입력해 주세요.")
        userGuessNumbers.contains("0") -> throw IllegalArgumentException("1~9 사이 숫자만 입력해 주세요.")
        userGuessNumbers.length != 3 -> throw IllegalArgumentException("세 자릿수를 입력해 주세요.")
        userGuessNumbers.toSet().size !=3 -> throw IllegalArgumentException("중복된 숫자는 입력 불가 합니다.")
        else -> return true
    }
}

fun getRandomNumber(): MutableList<Int> {
    val computerRandomNumber = mutableListOf<Int>()

    while (computerRandomNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if (!computerRandomNumber.contains(randomNumber)) {
            computerRandomNumber.add(randomNumber)
        }
    }
    return computerRandomNumber
}
