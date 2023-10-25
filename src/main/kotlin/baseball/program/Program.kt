package baseball.program

import java.lang.IllegalArgumentException

class Program {
    var randomNumber = "000"

    fun setRandomNumber() {
        var set = mutableSetOf<Int>()

        while(set.size < 6) {
            set.add((1..9).random())
        }

        this.randomNumber = set.toString()
    }

    fun checkThreeNumbers(input: String){
        if (input.length != 3) {
            throw IllegalArgumentException("입력은 반드시 3글자여야 합니다. 다시 입력해주세요.")
        }
    }

}