package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

/**
 * 컴퓨터와 함께 숫자 야구 게임을 플레이하는 클래스
 */
class Game {
    private var computer: String
    private var user: String
    private var check: String
    private var checkNumResult: String

    /**
     * 컴퓨터를 위한 랜덤한 숫자를 생성하여 게임을 초기화
     */
    init {
        computer = generateRandomNumber()
        user = ""
        check = ""
        checkNumResult = ""
    }

    /**
     * 숫자 야구 게임을 시작
     */
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

    /**
     * 컴퓨터를 위한 랜덤한 3자리 숫자를 생성
     */
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

    /**
     * 사용자로부터 입력을 받는다
     */
    private fun getUserInput(): String {
        print("숫자를 입력해주세요 : ")
        return Console.readLine()
    }

    /**
     * 게임을 재시작하거나 종료할 것을 사용자에게 물어본다
     */
    private fun restartGame(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine()
    }

    /**
     * 사용자의 추측을 컴퓨터의 숫자와 비교하여 스트라이크, 볼 또는 낫싱을 결정
     *
     * @param computerNumber 컴퓨터가 생성한 숫자
     * @param userNumber 사용자의 추측
     */
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

    /**
     * 사용자의 입력을 검증하여 3자리 숫자이며, 중복된 숫자가 없도록 한다
     *
     * @param user 사용자의 입력
     */
    private fun validateUserInput(user: String) {
        if (user.length != 3 || user.toSet().size != 3 || user.any { it !in '1'..'9' }) {
            throw IllegalArgumentException()
        }
    }
}

/**
 * 숫자야구 게임을 시작하기 위한 메인 함수
 */
fun main() {
    val baseballGame = Game()
    baseballGame.play()
}



