package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballConsole {
    fun printWelcomeMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun getInput(): String {
        print("숫자를 입력해주세요 : ")
        try {
            val input = Console.readLine()
            return validateUserInput(input)
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }

    private fun validateUserInput(input: String?): String {
        val trimInput = input?.trim()
        return if (trimInput.isNullOrEmpty()
            || trimInput.length != BaseballGame.MAX_SIZE
            || isDuplication(trimInput)
            || isNumber(trimInput).not()
        ) {
            throw IllegalArgumentException()
        } else {
            trimInput
        }
    }

    private fun isDuplication(input: String): Boolean {
        for (i in 0 until input.lastIndex) {
            for (j in i + 1..input.lastIndex) {
                if (input[i] == input[j]) return true
            }
        }
        return false
    }

    private fun isNumber(input: String): Boolean {
        for (i in input) {
            if (i !in '1'..'9') {
                return false
            }
        }
        return true
    }

    fun printResult(result: BaseballResult) {
        println(result)
    }

    fun printEndMessage() {
        println(
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        )
    }

    fun getEndFlag(): EndFlag {
        try {
            val endFlag = Console.readLine()
            return validateEndFlag(endFlag?.trim())
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }

    private fun validateEndFlag(input: String?): EndFlag {
        val trimInput = input?.trim()
        return when (trimInput) {
            "1" -> EndFlag.RESTART
            "2" -> EndFlag.FINISH
            else -> throw IllegalArgumentException()
        }
    }

    fun close() {
        Console.close()
    }
}