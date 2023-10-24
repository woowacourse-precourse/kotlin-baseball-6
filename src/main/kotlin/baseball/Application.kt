package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val game = Game()
    println("숫자 야구 게임을 시작합니다.")
    game.start()
}
class Game {
    private var computerNumbers = mutableListOf<Int>()

    fun start() {
        generateRandomNumbers()
        // 나머지 로직 추가
    }

    private fun generateRandomNumbers() {
        computerNumbers.clear()
        while (computerNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber)
            }
        }
    }
}
