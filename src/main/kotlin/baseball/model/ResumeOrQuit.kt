package baseball.model

import baseball.controller.GameManager
import baseball.view.InputView
import baseball.view.OutputView

class ResumeOrQuit(val strike: Int) {
    val invalidInputException = IllegalArgumentException("잘못된 입력값입니다.")
    fun GoStop(): Boolean {
        if (strike == 3) {
            OutputView.ROS()
            val ans: Int = try {
                InputView().UserNumInput().toString().toInt()
            } catch (e: NumberFormatException) {
                throw invalidInputException
            }

            if (ans == 1) {
                GameManager()
                return false
            } else if (ans == 2) {
                return false
            } else {
                throw invalidInputException
            }
        }
        return true
    }
}