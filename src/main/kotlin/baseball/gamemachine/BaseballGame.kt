package baseball.gamemachine

import baseball.io.Input
import baseball.io.Output

class BaseballGame(
    val input: Input = Input(),
    val printer: Output = Output(),
    val generator: ComputerNumberGenerator = ComputerNumberGenerator()

) {

    // 이건 전체 게임 즉, 맞출때 까지
    fun game() {
        while(true) {
            var computerNum = generator.makeComputerNumber()
        }
    }

    // 이건 하나에 대한 문답 만을 책임
    fun smallGame(answer: List<Int>) {
        var myNum = input.inputMyNumber()
    }


}