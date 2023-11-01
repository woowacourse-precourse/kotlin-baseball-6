package baseball.controller

import baseball.model.Computer
import baseball.util.C.FINISH_CONDITION
import baseball.util.C.GET_INPUT_MSG
import baseball.util.Validator.checkUserInputValid
import baseball.view.GameOutputView
import camp.nextstep.edu.missionutils.Console

class System {

    private var userInputList: List<String> = listOf()
    private var userInput: String = ""
    private var isFinished = false
    private var result: Pair<Int, Int> = Pair(0, 0)
    private val computer = Computer()
    private val gamerOutputView = GameOutputView()

    init {
        gamerOutputView.printGameStart()
        computer.makeRandomNums()
    }

    //게임 실행 함수
    fun gameStart() {

        while (!isFinished) {

            getUserInput()
            checkUserInputValid(userInput)
            makeUserInputList(userInput)

            result = computer.getGameResult(userInputList)
            gamerOutputView.printGameResult(result)

            if (result.first == FINISH_CONDITION) {
                gamerOutputView.printGameEnded()

                if (endGame()) isFinished = true
                else computer.makeRandomNums()
            }
        }
    }

    //플레이어 입력을 받는 함수
    private fun getUserInput() {
        print(GET_INPUT_MSG)
        userInput = Console.readLine().toString() //플레이어 입력
    }

    //재시작 여부를 받는 함수
    private fun endGame(): Boolean {
        val userInput = Console.readLine()
        return when (userInput) {
            "1" -> false //종료 O, 재시작 X
            "2" -> true //종료 X , 재시작 O
            else -> throw IllegalArgumentException()
        }
    }

    //플레이어 입력 String을 list로 변환하는 함수
    private fun makeUserInputList(userInput: String) {
        userInputList = userInput.chunked(1)
    }
}
