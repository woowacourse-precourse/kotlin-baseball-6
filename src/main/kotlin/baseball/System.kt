package baseball

import baseball.Util.C.BALL_STRING
import baseball.Util.C.GAME_END_STRING
import baseball.Util.C.GET_INPUT_STRING
import baseball.Util.C.GAME_RESTART_STRING
import baseball.Util.C.GAME_START_STRING
import baseball.Util.C.INPUT_REGEX
import baseball.Util.C.NOTHING
import baseball.Util.C.STRIKE_STRING
import camp.nextstep.edu.missionutils.Console

class System {

    private var userInputList: List<String> = listOf()
    private var userInput: String = ""
    private var isFinished = false
    private var result: Pair<Int, Int> = Pair(0, 0)
    private val computer = Computer()

    init {
        printGameStart()
        computer.makeRandomNumList()
    }

    //게임 실행 함수
    fun gameStart() {
        while (!isFinished) {
            getUserInput()
            checkUserInputValid(userInput)
            result = computer.getGameResult(userInputList)
            printGameResult(result)
            if (result.first == 3) {
                printGameEnded()
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

    //게임 시작을 출력하는 함수
    private fun printGameStart() {
        println(GAME_START_STRING)
    }
    //게임 결과를 출력하는 함수
    private fun printGameResult(result: Pair<Int, Int>) {
        val (strike, ball) = result
        val resultText = when {
            strike > 0 && ball == 0 -> "$strike$STRIKE_STRING"
            strike == 0 && ball > 0 -> "$ball$BALL_STRING"
            strike == 0 && ball == 0 -> NOTHING
            else -> "$ball$BALL_STRING $strike$STRIKE_STRING"
        }
        println(resultText)
    }
    //게임 종료를 출력하는 함수
    private fun printGameEnded() {
        println(GAME_END_STRING)
        println(GAME_RESTART_STRING)
    }
}
