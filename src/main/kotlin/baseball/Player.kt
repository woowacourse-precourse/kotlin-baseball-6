package baseball

import camp.nextstep.edu.missionutils.Console

class Player {
    fun guessGameNumbers(): GameNumbers {
        return GameNumbers(Console.readLine())
    }

    fun askReplayOption(): ReplayOption {
        return ReplayOption.from(Console.readLine())
    }
}
