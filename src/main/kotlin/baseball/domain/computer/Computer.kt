package baseball.domain.computer

import baseball.domain.player.PlayerNumber
import baseball.domain.player.PlayerNumbers
import camp.nextstep.edu.missionutils.Randoms

class Computer() {
    companion object {
        fun setRandomNumbers(): PlayerNumbers {
            val numbers = mutableListOf<PlayerNumber>()
            while (numbers.size < 3) {
                val computer = Randoms.pickNumberInRange(1, 9)
                if (numbers.none { it.numbers == computer }) {
                    numbers.add(PlayerNumber(computer))
                }
            }
            return PlayerNumbers(numbers)
        }
    }
}
