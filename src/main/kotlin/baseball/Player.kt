package baseball

import camp.nextstep.edu.missionutils.Console

class Player {
    fun guessGameNumbers() = GameNumbers(Console.readLine())

    fun askReplayOption() = ReplayOption.from(Console.readLine())
}
