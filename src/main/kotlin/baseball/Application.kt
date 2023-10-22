package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class Game {
    private var computer: String
    private var user: String
    private var check: String
    private var checkNumResult: String

    init {
        computer = generateRandomNumber()
        user = ""
        check = ""
        checkNumResult = ""
    }

    fun play() {
        println("숫자 야구 게임을 시작합니다.")
        while (true) {
            user = getUserInput()
            validateUserInput(user)
            try {
                checkNumbers(computer, user)
                println(checkNumResult)
                if (checkNumResult == "3스트라이크") {
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    check = restartGame()
                    if (check == "2") {
                        break
                    } else {
                        computer = generateRandomNumber()
                    }
                }
            } catch (e: IllegalArgumentException) {
                break
            }
        }
    }

    private fun generateRandomNumber(): String {
        val number = mutableListOf<Int>()
        while (number.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!number.contains(randomNumber)) {
                number.add(randomNumber)
            }
        }
        return number.joinToString("")
    }

    private fun getUserInput(): String {
        print("숫자를 입력해주세요 : ")
        return Console.readLine()
    }

    private fun restartGame(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine()
    }

    private fun checkNumbers(computerNumber: String, userNumber: String) {
        var strikes = 0
        var balls = 0
        for (i in computerNumber.indices) {
            if (computerNumber[i] == userNumber[i]) {
                strikes++
            } else if (computerNumber.contains(userNumber[i])) {
                balls++
            }
        }
        checkNumResult = when {
            strikes == 3 -> "3스트라이크"
            strikes > 0 || balls > 0 -> "$balls 볼 $strikes 스트라이크"
            else -> "낫싱"
        }
    }

    private fun validateUserInput(user: String) {
        if (user.length != 3 || user.toSet().size != 3 || user.any { it !in '1'..'9' }) {
            throw IllegalArgumentException()
        }
    }
}

fun main() {
    val baseballGame = Game()
    baseballGame.play()
}
