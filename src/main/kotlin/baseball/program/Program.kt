package baseball.program

import java.lang.IllegalArgumentException

class Program {
    var randomNumber = "000"
    var restartNumber = "1"
    var quitNumber = "2"

    fun setRandomNumber() {
        var set = mutableSetOf<Int>()

        while(set.size < 6) {
            set.add((1..9).random())
        }

        this.randomNumber = set.toString()
    }

    fun checkThreeNumbers(input: String) {
        if (input.length != 3) {
            throw IllegalArgumentException("입력은 반드시 3글자여야 합니다. 다시 입력해주세요.")
        }
    }

    fun checkDistinctNumbers(input: String) {
        val numbersSet = input.toCharArray().toSet()
        if (numbersSet.size != 3) {
            throw IllegalArgumentException("입력한 숫자는 3자리 모두 다 다른 숫자여야 합니다.")
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

    fun isSamePlaceSameNumber(inputNumber: Char, index: Int): Boolean {
        if (this.randomNumber[index] == inputNumber) {
            return true
        } else {
            return false
        }
    }
}