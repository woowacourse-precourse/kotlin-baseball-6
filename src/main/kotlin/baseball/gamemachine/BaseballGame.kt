package baseball.gamemachine

import baseball.io.Input
import baseball.io.Output

const val START = 1
const val END = 2

const val THREE_STRIKE = 3
const val ZERO = 0

class BaseballGame(
    private val input: Input = Input(),
    private val printer: Output = Output(),
    private val generator: ComputerNumberGenerator = ComputerNumberGenerator(),
    private val answerChecker: StrikeBallChecker = StrikeBallChecker()

) {

    // 이건 전체 게임 즉, 맞출때 까지
    fun game() {
        var flag = START

        while (flag == START) {
            var computerNum = generator.makeComputerNumber()
            flag = smallGame(computerNum)
        }
    }

    // 이건 하나에 대한 문답만을 책임
    private fun smallGame(answer: List<Int>):Int {
        var ball: Int
        var strike: Int

        while(true) {
            var myNum = strToList(input.inputMyNumber())
            val ballAndStrike = answerChecker.checkAnswer(answer, myNum)

            ball = ballAndStrike[0]
            strike = ballAndStrike[1]

            if (judge(ball,strike)) {

                return input.inputRetryChoice()
            }
        }

    }

    fun judge(ball:Int, strike:Int):Boolean {
        if(strike == THREE_STRIKE) {
            printer.printStrike(strike)
            return true
        }
        if(strike == ZERO && ball == ZERO) {
            printer.printNothing()
            return false
        }
        if (strike == ZERO) {
            printer.printBall(ball)
            return false
        }
        if (ball == ZERO) {
            printer.printStrike(strike)
            return false
        }
        printer.printBallAndStrike(ball,strike)
        return false
    }


    private fun strToList(myNum: String): List<Int> {
        var num = mutableListOf<Int>()
        for (char in myNum) {
            // code로 하면 아스키 코드가 나옴
            num.add(char.toString().toInt())
        }
        return num
    }


}