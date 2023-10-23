package baseball.controller

import baseball.model.*
import baseball.view.NoticeView
import baseball.view.UserInputView

class BaseBallGame {
    private val noticeView = NoticeView()
    private val userInputView = UserInputView()
    private val baseBallNumberGenerator = BaseBallNumbersGenerator()

    private var isContinue = false

    fun play() {
        start()
        progress()
    }

    private fun start() {
        noticeView.start()
    }

    private fun progress() {
        val baseballController = BaseballController(baseBallNumberGenerator.generate())
        var isWin = false
        while (!isWin) {
            noticeView.inputUserNumber()
            isWin = isWin(baseballController)
        }
        noticeView.succeed()
        retry()
    }

    private fun retry() {
        noticeView.restart()
        val isRetry = userInputView.getRetryNum()
        if(isRetry == RETRY_NUM){
            progress()
        }
    }

    private fun isWin(baseballController:BaseballController): Boolean {
        val userNumber = UserNumbersGenerator(userInputView.getBaseBallNum()).generate()
        val userModel = UserModel(userNumber)
        val judgment = baseballController.judgment(userModel.getNumbers())
        return judgment == WIN_JUDGMENT
    }

    companion object {
        const val WIN_JUDGMENT = "3스트라이크"
        const val RETRY_NUM = "1"
    }
}