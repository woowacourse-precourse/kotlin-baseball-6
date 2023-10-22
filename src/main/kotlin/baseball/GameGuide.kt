package baseball

import baseball.constants.GameInstruction
import baseball.constants.GameResult

class GameGuide {
    fun show(instruction: GameInstruction) = println(instruction.message)

    fun show(result: GameResult) = println(result.message)

    fun show(result: String) = println(result)
}