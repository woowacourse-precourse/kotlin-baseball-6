package baseball

import camp.nextstep.edu.missionutils.Console


class BaseballGameView(private val validate: BaseballGameValidate) {
    fun displayStartGameMessage() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun inputUserNumber(): String {
        print("수를 입력하세요: ")

        val user: String = Console.readLine()
        validate.validateInputUserNumber(user)

        return user
    }


    fun gameOver() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun printHint(strike: Int, ball: Int) {
        val hint = buildHint(strike, ball)
        println(hint)
    }

    private fun buildHint(strike: Int, ball: Int): String {
        return when {
            ball != 0 && strike != 0 -> "${ball}볼 ${strike}스트라이크"
            ball != 0 -> "${ball}볼"
            strike != 0 -> "${strike}스트라이크"
            else -> "낫싱"
        }
    }

    fun chooseRestartAndExit(): Boolean {
        val flag: Int = Console.readLine().toInt()
        validate.validateRestartAndExit(flag)
        return flag == 1
    }


}
