package baseball.controller

import baseball.model.BallCount
import baseball.model.RandomGenerator
import baseball.model.ResumeOrQuit
import baseball.model.StringToInt
import baseball.view.InputView
import baseball.view.OutputView

class GameManager {
    init {
        val answer: List<Int> = RandomGenerator().RandomNum()
        var result: MutableList<Int> = mutableListOf()

        do {
            OutputView.NumInput()
            val input = InputView().UserNumInput()
            if (input != null) {

                result = BallCount(StringToInt(input).StringToIntList(), answer).StrikeBallCount()
                OutputView().Result(result)
            }
        } while (ResumeOrQuit(result[0]).GoStop())
    }

}