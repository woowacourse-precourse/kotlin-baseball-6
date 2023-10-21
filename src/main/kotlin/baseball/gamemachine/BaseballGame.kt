package baseball.gamemachine

import baseball.io.Input
import baseball.io.Output

const val START = 1
const val END = 2
class BaseballGame(
    private val input: Input = Input(),
    private val printer: Output = Output(),
    private val generator: ComputerNumberGenerator = ComputerNumberGenerator()

) {

    // 이건 전체 게임 즉, 맞출때 까지
    fun game() {
        var flag = START

        while(flag == START) {
            var computerNum = generator.makeComputerNumber()
        }
    }

    // 이건 하나에 대한 문답 만을 책임
    fun smallGame(answer: List<Int>) {

        while(true) {
            var myNum = input.inputMyNumber()
        }

    }


}