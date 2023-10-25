package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val game = BaseBallGame()
    //게임 실행 함수 호출
    game.gamePlay()
}

class BaseBallGame {
    private val computer = Computer()
    private val person = Person()
    private val baseBallGameCounter = BaseBallGameCounter()
    private val baseBallGameMessage = BaseBallGameMessage()
    private val inputValidator = InputValidator()

    //게임 실행 함수
    fun gamePlay() {
        computer.makeComputerNumber()
        baseBallGameMessage.printStartMessage()
        while(true) {
            baseBallGameMessage.printPersonInputMessage()
            person.inputNumber()
            inputValidator.isValidInput(person.getInputList())
            val(strike, ball) = baseBallGameCounter.calCount(person.getInputList(), computer.getNumberList())
            baseBallGameMessage.printCountMessage(strike, ball)
            if(!askForRestart(strike, ball)) break
        }
    }

    //게임 재시작 여부 확인 함수
    private fun askForRestart(strike: Int, ball: Int): Boolean{
        if(strike == 3 && ball == 0) {
            baseBallGameMessage.printGameEndMessage()
            baseBallGameMessage.printRestartAndExitMessage()
            person.inputNumber()
            if(inputValidator.isRestart(person.getInputList())) {
                computer.makeComputerNumber()
                return true
            }
            else {
                return false
            }
        }
        return true
    }
}

class BaseBallGameCounter {

    private val LENGTH = 3
    //볼, 스트라이크 계산
    fun calCount(
        inputList: MutableList<Int>,
        numberList: MutableList<Int>
    ) : Pair<Int, Int> {
        var strike = 0
        var ball = 0
        for(i: Int in 0..< LENGTH) {
            for(j: Int in 0..< LENGTH) {
                if(inputList[i] == numberList[j]) {
                    if(i != j) ball += 1 else strike += 1
                }
            }
        }
        return Pair(strike, ball)
    }

}

class BaseBallGameMessage {
    private val startMessage = "숫자 야구 게임을 시작합니다."
    private val personInputMessage = "숫자를 입력해주세요 : "
    private val nothingMessage = "낫싱"
    private val strikeMessage = "%d스트라이크"
    private val ballMessage = "%d볼"
    private val restartAndExitMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    private val gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

    //게임 시작 메시지 출력
    fun printStartMessage() {
        println(startMessage)
    }

    //사용자 입력 메시지 출력
    fun printPersonInputMessage() {
        print(personInputMessage)
    }

    //게임 재시작 여부 메시지 출력
    fun printRestartAndExitMessage() {
        println(restartAndExitMessage)
    }

    //게임 종료 메시지 출력
    fun printGameEndMessage() {
        println(gameEndMessage)
    }

    //볼 스트라이크 카운트 메세지 출력
    fun printCountMessage(strike: Int, ball: Int) {
        when {
            strike == 0 && ball == 0
            -> println(nothingMessage)
            strike == 0
            -> println(ballMessage.format(ball))
            ball == 0
            -> println(strikeMessage.format(strike))
            strike == 3
            -> println(strikeMessage.format(strike))
            else
            -> println("${ballMessage.format(ball)} ${strikeMessage.format(strike)}")
        }
    }

}

class Computer {
    private val _numberList = mutableListOf<Int>()

    //컴퓨터 수 생성
    fun makeComputerNumber() {
        _numberList.clear()
        while (_numberList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!_numberList.contains(randomNumber)) {
                _numberList.add(randomNumber)
            }
        }
    }

    //컴퓨터 수 값 전달
    fun getNumberList() : MutableList<Int> {
        return _numberList
    }
}

class InputValidator {

    //사용자 입력 판별
    fun isValidInput(inputList: MutableList<Int>) {
        if(!isCorrectLength(inputList) || isSameNumber(inputList) || !isAllNumeric(inputList)) {
            throw IllegalArgumentException()
        }
    }

    // 게임 재시작 여부 입력 판별
    fun isRestart(inputList: MutableList<Int>): Boolean {
        return inputList.size == 1 && inputList[0] == 1
    }

    private fun isCorrectLength(inputList: MutableList<Int>) : Boolean {
        return inputList.size == 3
    }

    private fun isSameNumber(inputList: MutableList<Int>) : Boolean {
        return inputList[0] == inputList[1] || inputList[0] == inputList[2] || inputList[1] == inputList[2]
    }

    private fun isAllNumeric(inputList: MutableList<Int>) : Boolean {
        for(n in inputList) {
            if(!isNumeric(n.toString())) {
                return false
            }
        }
        return true
    }

    private fun isNumeric(input: String): Boolean {
        return try {
            input.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

}

class Person {
    private val _inputList = mutableListOf<Int>()

    //사용자 입력
    fun inputNumber() {
        _inputList.clear()
        val input = Console.readLine()
        for(i: Int in 0..<input.length) {
            _inputList.add(input[i] - '0')
        }
    }

    //사용자 입력 값 전달
    fun getInputList() : MutableList<Int> {
        return _inputList
    }
}
