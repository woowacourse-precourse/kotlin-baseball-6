package user

import camp.nextstep.edu.missionutils.Console.*

class User {
    var currentUserBaseballNumber = 0
        private set

    fun inputBaseballNumber(input: Int = readLine().toInt()){
        if (input in INPUT_MIN_VALUE..INPUT_MAX_VALUE) {
            currentUserBaseballNumber = input
        } else {
            throw IllegalArgumentException()
        }
    }

    fun restartOrExitInput(input: String = readLine()): String {
        if (input == RESTART || input == EXIT) return input else throw IllegalArgumentException()
    }

    fun printInputMessage() {
        print("숫자를 입력해주세요 : ")
    }

    companion object {
        const val EXIT = "2"
        private const val INPUT_MIN_VALUE = 111
        private const val INPUT_MAX_VALUE = 999
        private const val RESTART = "1"
    }
}