package baseball.controller

import baseball.model.BallCount
import baseball.model.RandomGenerator
import baseball.model.StringToInt
import baseball.view.InputView
import baseball.view.OutputView

class GameManager {
    val answer : List<Int> = RandomGenerator().RandomNum()
    init {
        OutputView.Start()
        do {
            OutputView.NumInput()
            val input = InputView().UserNumInput()
            if (input != null) {
                OutputView().Result(BallCount(StringToInt(input).StringToIntList(),answer).StrikeBallCount())
            }
        } while (true)
    }

}