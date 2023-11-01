package baseball

import baseball.constants.GameRestartOption

class Player(private val reader: Reader = Reader()) {
    fun selectNumbers(): String = reader.read()

    fun determineRestart(): GameRestartOption {
        val input = reader.read()
        return GameRestartOption.of(input)
    }
}