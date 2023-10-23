package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame {
    private var play = true
    private var strike = 0
    private var ball = 0
    fun startGame() {
        val opponent = Opponent()
        val user = User()

        opponent.generateNum()

        println("숫자 야구 게임을 시작합니다.")

        while (play) {
            user.getUserInput()
            compareNum(opponent.getNum(), user.getNum())
            user.clear()
        }
    }

    private fun compareNum(opp: MutableList<Int>, user: MutableList<Int>) {
        strike = 0
        ball = 0

        for (i in 0..2) {
            if (opp[i] == user[i]) strike++
            else if (opp.contains(user[i])) ball++
        }

        if (strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("다시 시작은 0, 그만두기는 1을 입력해주세요.")
            if (Console.readLine() == "0") {
                startGame()
            } else if (Console.readLine() == "1") {
                play = false
            } else throw IllegalArgumentException("0과 1을 입력해주세요.")
        } else if (ball == 0 && strike == 0){
            println("낫싱")
        } else {
            println("${ball}볼 ${strike}스트라이크")
        }
    }
}