package baseball.view


import camp.nextstep.edu.missionutils.Console

private const val RESTART_NUMBER = 1
private const val END_NUMBER = 2

class InputView {
    fun readNumbers(): String {
        print("숫자를 입력해주세요 : ")

        return Console.readLine()
    }

    fun readRestart(): Int {
        println("게임을 새로 시작하려면 ${RESTART_NUMBER}, 종료하려면 ${END_NUMBER}를 입력하세요.")

        return Console.readLine().toInt()
    }
}
