package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val comNum = createRandomNum()

    do {
        do {
            print("숫자를 입력해주세요 : ")
            var result = compareNum(comNum, enterNum())
            printResult(result)
        } while (result.first != 3)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    } while (gameContinueOrQuit())
}






class Computer {
    fun createRandomNum(): String { //컴퓨터 서로다른 3자리 숫자 난수 생성
        val computer: MutableList<Int> = mutableListOf()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.joinToString("")
    }
    fun compareNum(comNum: String, playerNum: String): Pair<Int, Int> {//숫자 비교하여 스크라이크 볼개수 출력
        var strike = 0
        var ball = 0
        //var comNum = "123"
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
    fun printResult(result: Pair<Int, Int>) {   //스트라이크 볼 개수로 결과 출력
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
}

class Player {
    fun enterNum(): String {    //사용자 입력 받기
        val InputNum = Console.readLine()
        enterNumException(InputNum)
        return InputNum
    }
    fun restartOrQuitException(restartNumber: Int) {
        if (restartNumber != 1 && restartNumber != 2) {
            throw IllegalArgumentException("1 또는 2를 입력해주세요")
        }
    }
    fun enterNumException(enterNum: String) {
        val uniqueDigits = enterNum.toSet()
        if (enterNum.length != 3) {
            throw IllegalArgumentException("3개의 숫자를 입력해주세요.")
        }
        if (enterNum.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자를 입력해주세요.")
        }
        if(enterNum.length != uniqueDigits.size){
            throw IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.")
        }
    }
    fun gameContinueOrQuit(): Boolean {
        var restart = Console.readLine().toInt()
        restartOrQuitException(restart)
        //사용자 1또는 2 입력 안할시 예외처리
        if (restart == 1) {
            return true
        }
        return false
    }
}