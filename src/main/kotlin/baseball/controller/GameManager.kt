package baseball.controller

import baseball.model.RandomGenerator
import baseball.view.OutputView

class GameManager {
    val answer : List<Int> = RandomGenerator().RandomNum()
    init {
        OutputView()
    }

}