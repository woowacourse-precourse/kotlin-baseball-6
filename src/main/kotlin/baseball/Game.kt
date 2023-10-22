package baseball

import camp.nextstep.edu.missionutils.Console


class Game() {
    fun gameStart() {
        val computerNum = Computer().randomNum()
        println(computerNum)

        while (true) {
            val userNum = User().userInputNum()
            BaseBall(userNum, computerNum).startBaseBall()
            if (BaseBall(userNum, computerNum).isMatchNumber() == BaseBall.COMPLETE) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

                return when (Console.readLine()) {
                    "1" -> gameStart()
                    "2" -> break
                    else -> throw IllegalArgumentException("1,2값이 아닙니다.")
                }
            }
        }
    }
}
