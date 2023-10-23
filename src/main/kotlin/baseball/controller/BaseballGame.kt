package baseball.controller

import baseball.model.BaseBallNumberGenerator
import baseball.model.BaseballModel
import baseball.model.UserModel
import baseball.model.UserNumberGenerator
import baseball.view.NoticeView
import baseball.view.UserInputView

class BaseBallGame {
    private val noticeView = NoticeView()
    private val userInputView = UserInputView()
    private val baseBallNumberGenerator = BaseBallNumberGenerator()
    private var baseballController = BaseballController(baseBallNumberGenerator.generate())

    private var isContinue = false

    fun play() {
    }

    private fun start() {
        noticeView.start()
    }

    private fun progress() {
        var isWin = false
        while (!isWin) {
            noticeView.succeed()
            isWin = isWin()
        }
        noticeView.end()
    }

    private fun retry() {
        noticeView.restart()
        val isRetry = userInputView.getRetryNum()
        isContinue = isRetry == RETRY_NUM
    }

    private fun isWin(): Boolean {
        val userNumber = UserNumberGenerator(userInputView.getBaseBallNum()).generate()
        val userModel = UserModel(userNumber)
        val judgment = baseballController.judgment(userModel.getNumbers())
        return judgment == WIN_JUDGMENT
    }

    companion object {
        const val WIN_JUDGMENT = "3스트라이크"
        const val RETRY_NUM = "1"
        const val END_NUM = "2"
    }
}