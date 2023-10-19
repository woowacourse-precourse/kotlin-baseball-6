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
}