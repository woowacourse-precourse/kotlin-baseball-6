package baseball.Controller

import camp.nextstep.edu.missionutils.Console

class Retry
{

    fun askContinue(): Boolean {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        when (Console.readLine())
        {
            "1" -> {
                return true
            }
            "2" -> {
                println("게임종료")
                return false
            }
            else -> {
                throw IllegalArgumentException("올바른 수를 입력해주세요")
                return false
            }
        }
        return false
    }
}