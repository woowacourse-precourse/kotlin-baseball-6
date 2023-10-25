package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer(private val inputManager: InputManager) {
    private fun generateAnswer(): Int {
        val answer = StringBuilder().apply {
            repeat(3) { append(Randoms.pickNumberInRange(1, 9)) }
        }.toString().toInt()
        return answer
    }

    private fun isValidAnswer(answer: Int): Boolean {
        return try {
            inputManager.checkThreeDigitInput(answer.toString())
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun generateValidAnswer(): Int {
        while(true) {
            val answer = generateAnswer()
            if(isValidAnswer(answer)) { return answer }
        }
    }
}