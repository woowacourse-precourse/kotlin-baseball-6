package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballConsole {
    fun printWelcomeMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun getInput(): String {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine() ?: throw IllegalArgumentException()
        val isValid = verifyUserInput(input)
        if (isValid) {
            return input
        } else {
            throw IllegalArgumentException()
        }
    }

    private fun verifyUserInput(userInput: String): Boolean {
        return if (userInput.length != 3) {
            false
        } else {
            try {
                userInput.toInt()
                isNotDuplication(userInput)
            } catch (nfe: NumberFormatException) {
                false
            }
        }
    }

    private fun isNotDuplication(num: String): Boolean {
        for (i in 0..<2) {
            for (j in i + 1..<3) {
                if (num[i] == num[j]) return false
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
        val endFlag = Console.readLine() ?: throw IllegalArgumentException()
        return when (endFlag) {
            "1" -> EndFlag.RESTART
            "2" -> EndFlag.FINISH
            else -> throw IllegalArgumentException()
        }
    }
}