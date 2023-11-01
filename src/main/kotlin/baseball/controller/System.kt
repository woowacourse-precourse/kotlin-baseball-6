package baseball.controller

import baseball.Computer
import baseball.util.C.GET_INPUT_STRING
import baseball.util.C.INPUT_REGEX
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
        computer.makeRandomNumList()
    }

    //게임 실행 함수
    fun gameStart() {
        while (!isFinished) {
            getUserInput()
            checkUserInputValid(userInput)
            result = computer.getGameResult(userInputList)
            gamerOutputView.printGameResult(result)
            if (result.first == 3) {
                gamerOutputView.printGameEnded()
                if (endGame()) isFinished = true
                else computer.makeRandomNumList()
            }
        }
    }

    //플레이어 입력을 받는 함수
    private fun getUserInput() {
        print(GET_INPUT_STRING)
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

    //플레이어의 입력값이 유효한 지 검사하는 함수
    private fun checkUserInputValid(userInput: String) {
        if (!checkRegexMatch(userInput) || !checkDiffNums(userInput)) throw IllegalArgumentException()
        else makeUserInputList(userInput)
    }

    //정규표현식과 일치하는 지 확인하는 함수
    private fun checkRegexMatch(userInput: String): Boolean {
        val regex = INPUT_REGEX.toRegex() //1-9사이의 숫자로 구성된 세 자릿수 정규표현식
        return regex.matches(userInput)
    }

    //중복된 숫자가 없는 지 확인하는 함수
    private fun checkDiffNums(userInput: String): Boolean = (userInput.length == userInput.toSet().size)
}
