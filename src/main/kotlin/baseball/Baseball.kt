package baseball

import baseball.utils.Utils

class Baseball {
    fun run(computer: List<Int>) {
        while (true) {
            val user = getPlayerNumber()
            val strike = countStrike(computer, user)
            val ball = countBall(computer, user)

            printGameResult(strike, ball)
        }
    }

    fun getPlayerNumber() : List<Int> {
        print("숫자를 입력해주세요 : ")
        val userNumber = readLine()
        return Utils().checkInput(userNumber!!)
    }

    fun countStrike(computer: List<Int>, user: List<Int>) : Int {
        var count = 0
        for (i in 0..INPUT_SIZE-1) {
            if (computer[i] == user[i]) count++
        }
        return count
    }

    fun countBall(computer: List<Int>, user: List<Int>) : Int {
        var count = 0
        for (i in 0..INPUT_SIZE-1) {
            if(checkBallNumberSame(computer, user, i)) count++
        }
        return count
    }

    fun checkBallNumberSame(computer: List<Int>, user: List<Int>, index: Int) : Boolean {
        for (i in 0..INPUT_SIZE-1) {
            if(index == i) continue
            if(computer[index] == user[i]) return true
        }
        return false
    }

    fun printGameResult(strike: Int, ball: Int) {
        when {
            strike == INPUT_SIZE -> println("${strike}스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            strike == 0 && ball == 0 -> println("낫싱")
            strike > 0 && ball == 0 -> println("${strike}스트라이크")
            strike == 0 && ball > 0 -> println("${ball}볼")
            else -> println("${ball}볼 ${strike}스트라이크")
        }
    }
}