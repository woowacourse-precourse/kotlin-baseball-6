package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val computer: MutableList<Int> = initComputer()
    println("숫자 야구 게임을 시작합니다.")

    var isGameWon = false

    while (!isGameWon) {
        val playerGuess = getUserGuess()
        if (playerGuess is IllegalArgumentException) {
            println("${(playerGuess as IllegalArgumentException).message} 애플리케이션을 종료합니다.")
            return
        }
        val result = evaluateGuess(playerGuess, computer)
        println(result)

        if (result == "3스트라이크") {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            isGameWon = true

            if (playAgain()) {
                isGameWon = false
                computer.clear()
                computer.addAll(initComputer())
            } else {
                println("게임을 완전히 종료합니다.")
            }
        }
    }
}

fun initComputer(): MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}


fun getUserGuess(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine() ?: ""
    if (input.length != 3 || input.toSet().size != 3 || !input.all { it.isDigit() }) {
        throw IllegalArgumentException("잘못된 입력입니다. 1에서 9까지의 서로 다른 숫자 3개를 입력하세요.")
    }

    return input.map { it.toString().toInt() }
}

fun evaluateGuess(guess: List<Int>, target: List<Int>): String {
    val strikes = guess.zip(target).count { (guessDigit, targetDigit) -> guessDigit == targetDigit }
    val balls = guess.count { it in target && guess.indexOf(it) != target.indexOf(it) }

    if (strikes > 0 && balls > 0) {
        return "${balls}볼 ${strikes}스트라이크"
    } else if (strikes > 0) {
        return "${strikes}스트라이크"
    } else if (balls > 0) {
        return "${balls}볼"
    } else {
        return "낫싱"
    }
}

fun playAgain(): Boolean {
    print("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.\n")
    val response = Console.readLine()
    return response == "1"
}