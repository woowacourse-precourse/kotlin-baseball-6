package baseball

import baseball.CheckResult.Result
import baseball.Exception.validationDigit
import baseball.Exception.validationDigitRange
import baseball.Exception.validationInputLength
import camp.nextstep.edu.missionutils.Console

class Main {
    private val computer = Computer()
    private val user = User()

    fun start(){
        println(GAME_START_MESSAGE)
        computer.randomAnswer()
        while (true){
            // 입력값 확인
            val input = user.trial()
            validInputCheck(input)

            // 게임 시작
            val result_str = Result(computer.computer, input)
            println(result_str)

            if(result_str.compareTo("3스트라이크") == 0){
                println(GAME_END_MESSAGE)
                println(GAME_RESTART_MESSAGE)
                val restartState = Console.readLine()
                when (restartState) {
                    REPLAY_SIGNAL.toString() -> restart()
                    END_SIGNAL.toString() -> return
                    else -> throw IllegalArgumentException()
                }
            }


        //CheckResult(input, )
        }
    }


    private fun validInputCheck(input: String) {
        validationInputLength(input)
        validationDigit(input)
        validationDigitRange(input)
    }

    private fun reset() {
        computer.resetAnswer()
    }

    private fun restart(){
        this.reset()
        this.start()
    }
}