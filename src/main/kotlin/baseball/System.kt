package baseball

import camp.nextstep.edu.missionutils.Console

class System {
    //string 분리하기 (하드코딩된 거)
    
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
        print("숫자를 입력해주세요 : ")
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
        val regex = "[1-9]{3}".toRegex() //1-9사이의 숫자로 구성된 세 자릿수 정규표현식
        return regex.matches(userInput)
    }
    //중복된 숫자가 없는 지 확인하는 함수
    private fun checkDiffNums(userInput: String): Boolean = (userInput.length == userInput.toSet().size)

    //게임 시작을 출력하는 함수
    private fun printGameStart() {
        println("숫자 야구 게임을 시작합니다.")
    }
    //게임 결과를 출력하는 함수
    private fun printGameResult(result: Pair<Int, Int>) {
        val (strike, ball) = result
        val resultText = when {
            strike > 0 && ball == 0 -> "${strike}스트라이크"
            strike == 0 && ball > 0 -> "${ball}볼"
            strike == 0 && ball == 0 -> "낫싱"
            else -> "${ball}볼 ${strike}스트라이크"
        }
        println(resultText)
    }
    //게임 종료를 출력하는 함수
    private fun printGameEnded() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}
