package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val com = Computer()
    val player = Player()

    com.printStartGame()
    do {
        com.playGame(com, player)
        com.endGamePrint()
    } while (player.gameContinueOrQuit())
}


class Computer {
    fun endGamePrint() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun printStartGame() = println("숫자 야구 게임을 시작합니다.")
    private fun createRandomNum(): String { //컴퓨터 서로다른 3자리 숫자 난수 생성
        val computer: MutableList<Int> = mutableListOf()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.joinToString("")
    }

    private fun compareNum(comNum: String, playerNum: String): Pair<Int, Int> {//숫자 비교하여 스크라이크 볼개수 출력
        var strike = 0
        var ball = 0
        //var comNum = "425"
        for (index in playerNum.indices) {
            if (playerNum[index] == comNum[index]) {
                strike++
                continue
            }
            if (comNum.contains(playerNum[index])) {
                ball++
            }
        }
        return Pair(strike, ball)
    }

    private fun printResult(result: Pair<Int, Int>) {   //스트라이크 볼 개수로 결과 출력
        val strike = result.first
        val ball = result.second

        if (strike > 0 && ball == 0) {
            println("${strike}스트라이크")
            return
        }
        if (strike == 0 && ball > 0) {
            println("${ball}볼")
            return
        }
        if (strike == 0 && ball == 0) {
            println("낫싱")
            return
        }

        println("${ball}볼 ${strike}스트라이크")
        return
    }

    fun playGame(com: Computer, player: Player) {
        val comNum = com.createRandomNum()
        do {
            print("숫자를 입력해주세요 : ")
            val result = com.compareNum(comNum, player.enterNum())
            com.printResult(result)
        } while (result.first != 3)
    }
}

class Player {
    fun enterNum(): String {    //사용자 입력 받기
        val inputNum = Console.readLine()
        enterNumException(inputNum)
        return inputNum
    }


    private fun enterNumException(enterNum: String) {
        val uniqueDigits = enterNum.toSet()
        if (enterNum.length != 3) {
            throw IllegalArgumentException("3개의 숫자를 입력해주세요.")
        }
        if (enterNum.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자를 입력해주세요.")
        }
        if (enterNum.length != uniqueDigits.size) {
            throw IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.")
        }
        if ('0' in uniqueDigits) {
            throw IllegalArgumentException("0을 제외한 1~9 사이의 숫자를 입력해주세요.")
        }
    }

    fun gameContinueOrQuit(): Boolean {
        val restart = Console.readLine()
        //restartOrQuitException(restart)
        //사용자 1또는 2 입력 안할시 예외처리
        if (restartOrQuitException(restart) == 1) {
            return true
        }
        return false
    }

    private fun restartOrQuitException(restartNumber: String): Int {
        val intRestartNumber = restartNumber.toIntOrNull()
        if (intRestartNumber != 1 && intRestartNumber != 2 || restartNumber.toIntOrNull() == null) {
            throw IllegalArgumentException("1 또는 2를 입력해주세요")
        }
        return intRestartNumber
    }
}