package baseball.program

import java.lang.IllegalArgumentException
import camp.nextstep.edu.missionutils.Randoms

class Program {
    var randomNumber = "000"
    var restartNumber = "1"
    var quitNumber = "2"

    fun setRandomNumber() {
        val set = mutableSetOf<Int>()

        while (set.size < 3) {
            val num = Randoms.pickNumberInRange(1, 9)
            set.add(num)
        }

        // 무작위로 생성된 숫자를 문자열로 변환
        randomNumber = set.joinToString("")
    }

    fun checkThreeNumbers(input: String) {
        if (input.length != 3) {
            throw IllegalArgumentException("입력은 반드시 3글자여야 합니다. 다시 입력해주세요.")
        }
    }

    fun checkDistinctNumbers(input: String) {
        val numbersSet = input.toCharArray().toSet()
        if (numbersSet.size != 3) {
            throw IllegalArgumentException("입력한 숫자는 3자리 모두 다 다른 숫자여야 합니다. 다시 입력해주세요.")
        }
    }

    fun checkOnlyDigits(input: String) {
        if (!input.matches(Regex("\\d+"))) {
            throw IllegalArgumentException("입력은 숫자로만 이루어져야 합니다. 다시 입력해주세요.")
        }
    }

    fun checkContainsSpace(input: String) {
        if (input.contains(" ")) {
            throw IllegalArgumentException("입력에 공백이 포함되어있습니다. 다시 입력해주세요.")
        }
    }

    fun checkRestartNumber(input: String) {
        if ((restartNumber != input) && (quitNumber != input) ) {
            throw IllegalArgumentException("1(재시작) 또는 2(종료)를 입력해주세요. 다시 입력해주세요.")
        }
    }
    fun isNumberPresent(input: Char): Boolean {
        val numbersSet = this.randomNumber.toCharArray().toSet()
        val contains = numbersSet.contains(input)
        return contains
    }

    fun isSamePlaceSameNumber(input: String, index: Int): Boolean {
        if (this.randomNumber[index] == input[index]) {
            return true
        } else {
            return false
        }
    }

    fun returnResult(countOfStrike: Int, countOfBall: Int) {
        if (countOfBall != 0) {
            print("${countOfBall}볼 ")
        }
        if (countOfStrike != 0) {
            println("${countOfStrike}스트라이크")
        }
        if (countOfBall == 0 && countOfStrike == 0) {
            println("낫싱")
        }

    }
}