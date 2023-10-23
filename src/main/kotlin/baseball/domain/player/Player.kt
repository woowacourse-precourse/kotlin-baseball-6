package baseball.domain.player

import baseball.domain.computer.Computer
import baseball.domain.hint.Hint

class Player() {

    fun provideHint(playerNumbers: List<Int>, computer: Computer): Hint {
        var strikes = 0
        var balls = 0

        val computerNumbers = computer.numbers

        computerNumbers.forEachIndexed { index, number ->
            if (playerNumbers.contains(number)) {
                if (playerNumbers[index] == number) {
                    strikes++
                } else {
                    balls++
                }
            }
        }

        return Hint(strikes, balls)
    }
}
