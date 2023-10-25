package baseball.utils

import baseball.INPUT_SIZE
import java.lang.IllegalArgumentException

class Utils {
    val user = mutableListOf<Int>()
    var playerInput = String()

    fun checkInput(input: String) : List<Int> {
        playerInput = input
        checkInputNull()
        checkInputLength()
        checkInputNumber()
        checkInputNumberDifferent()
        return user
    }

    fun checkInputNull(){
        if(playerInput.isNullOrEmpty()) throw NullPointerException("값을 입력하지 않았습니다. 프로그램을 종료합니다.")
    }

    fun checkInputLength() {
        when (playerInput.length) {
            INPUT_SIZE -> return
            else -> throw IllegalArgumentException("잘못된 값을 입력했습니다. 프로그램을 종료합니다.")
        }
    }

    fun checkInputNumber() {
        for (c in playerInput.toCharArray()) {
            if (!c.isDigit() || c == '0') {
                throw IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다. 프로그램을 종료합니다.")
            }
        }
    }

    fun checkInputNumberDifferent() {
        for (c in playerInput.toCharArray()) {
            if(!user.contains(c-'0')) user.add(c-'0')
        }

        if(user.size != INPUT_SIZE) throw IllegalArgumentException("중복된 값을 입력했습니다. 프로그램을 종료합니다.")
    }
}