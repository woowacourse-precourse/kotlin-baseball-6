package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class GameProgram {

    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")
        val computerNumbers = createRandomNumbers()

        print("숫자를 입력해주세요 : ")
    }

    private fun createRandomNumbers():List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < 3) {
            val number = Randoms.pickNumberInRange(1,9)
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number)
            }
        }
        return randomNumbers
    }

    private fun readUserInput():String {
        val userInput = Console.readLine()
        return userInput.trim()
    }

    private fun validateUserInput(userInput : String) {
        for (c in userInput.toCharArray()) {
            if (!c.isDigit()) throw IllegalArgumentException("숫자를 입력 해야 합니다.")
        }
        if (userInput.length != 3) throw IllegalArgumentException("3개의 숫자를 입력 해야 합니다.")
        if (userInput[0] == userInput[1] || userInput[0] == userInput[2] || userInput[1] == userInput[2]) throw IllegalArgumentException("서로 중복되지 않는 숫자를 입력 해야 합니다.")
    }
}