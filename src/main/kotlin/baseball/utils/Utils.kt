package baseball.utils

import baseball.INPUT_SIZE
import java.lang.IllegalArgumentException

class Utils {
    val user = mutableListOf<Int>()

    fun checkInput(input: String) : List<Int> {
        checkInputNull(input)
        checkInputLength(input)
        checkInputNumber(input)
        checkInputNumberDifferent(input)
        return user
    }

    fun checkInputNull(input: String){
        if(input.isNullOrEmpty()) throw NullPointerException("값을 입력하지 않았습니다. 프로그램을 종료합니다.")
    }

    fun checkInputLength(input: String) {
        when (input.length) {
            INPUT_SIZE -> return
            else -> throw IllegalArgumentException("잘못된 값을 입력했습니다. 프로그램을 종료합니다.")
        }
    }

    fun checkInputNumber(input: String) {
        for (c in input.toCharArray()) {
            if (!c.isDigit() || c == '0') {
                throw IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다. 프로그램을 종료합니다.")
            }
        }
    }

    fun checkInputNumberDifferent(input: String) {
        for (c in input.toCharArray()) {
            if(!user.contains(c-'0')) user.add(c-'0')
        }

        if(user.size != INPUT_SIZE) throw IllegalArgumentException("중복된 값을 입력했습니다. 프로그램을 종료합니다.")
    }
}