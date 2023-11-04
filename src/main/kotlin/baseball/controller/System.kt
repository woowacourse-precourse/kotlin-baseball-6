package baseball.controller

import baseball.model.Computer
import baseball.util.C.FINISH_CONDITION
import baseball.util.Validator.checkUserInputValid
import baseball.view.GameInputView
import baseball.view.GameOutputView

class System {

    private var userInputList: List<String> = listOf()
    private var userInput: String = ""
    private var isFinished = false
    private var result: Pair<Int, Int> = Pair(0, 0)
    private val computer = Computer()
    private val gamerOutputView = GameOutputView()
    private val gameInputView = GameInputView()

    init {
        gamerOutputView.printGameStart()
        computer.makeRandomNums()
    }

    //게임 실행 함수
    fun gameStart() {
        while (!isFinished) {
            handleGameStart()
            handleGameResult()
            if (isGameFinished()) {
                handleGameEnd()
            }
        }
    }

    private fun handleGameStart() {
        gamerOutputView.printInput().apply {
            userInput = gameInputView.getUserInput()
            checkUserInputValid(userInput)
            userInputList = gameInputView.makeUserInputList(userInput)
        }
    }

    private fun handleGameResult() {
        result = computer.getGameResult(userInputList)
        gamerOutputView.printGameResult(result)
    }

    private fun handleGameEnd() {
        gamerOutputView.printGameEnded()
        if (gameInputView.endGame()) isFinished = true
        else computer.makeRandomNums()
    }

    private fun isGameFinished() = result.first == FINISH_CONDITION
}
