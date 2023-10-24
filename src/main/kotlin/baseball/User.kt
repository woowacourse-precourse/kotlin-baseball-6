package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    companion object {
        private val validator = Validator()

        fun getUserNumbers(): MutableList<Int> {
            val input = inputNumberString()
            return validator.toNumberList(input)
        }

        private fun inputNumberString(): String {
            print("숫자를 입력해주세요 : ")
            val input: String = Console.readLine()
            validator.validateString(input)
            return input
        }

    }
}