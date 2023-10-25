package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var continueGame = true

    while (continueGame) {
        playNumberBaseballGame()

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val choice = Console.readLine()
        if (choice != "1") {
            continueGame = false
        }
    }
}


fun playNumberBaseballGame() {
    var GameFinished = false
    val computer = Computer()


    while (!GameFinished) {
        println("숫자를 입력해주세요:")
        val userInput = Console.readLine()

        if (!CorrectInput(userInput)) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }

        val hint = computer.getHint(userInput)
        GameFinished = hint.ThreeStrikes()
        println(hint)
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun CorrectInput(input: String?): Boolean {
    return input?.matches(Regex("^[1-9]{3}$")) == true && input.toCharArray().distinct().size == 3
}


class Computer {
    private val numbers = mutableListOf<Int>()

    init {
        while (numbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
    }

    fun getHint(userInput: String): Hint {
        var balls = 0
        var strikes = 0

        for (i in numbers.indices) {
            val guessedNumber = Character.getNumericValue(userInput[i])
            if (guessedNumber == numbers[i]) {
                strikes++
            } else if (numbers.contains(guessedNumber)) {
                balls++
            }
        }

        return Hint(balls, strikes)
    }
}

class Hint(private val balls: Int, private val strikes: Int) {
    fun ThreeStrikes(): Boolean = strikes == 3

    override fun toString(): String {
        if (balls == 0 && strikes == 0) return "낫싱"
        if (strikes == 3) return "3스트라이크"
        var result = ""
        if (balls > 0) result += "${balls}볼 "
        if (strikes > 0) result += "${strikes}스트라이크"
        return result.trim()
    }
}