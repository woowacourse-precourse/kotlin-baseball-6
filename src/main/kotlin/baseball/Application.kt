package baseball
import camp.nextstep.edu.missionutils.Console

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

    while (!GameFinished) {
        println("숫자를 입력해주세요:")
        val userInput = Console.readLine()

        if (!CorrectInput(userInput)) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }

    }

}

fun CorrectInput(input: String?): Boolean {
    return input?.matches(Regex("^[1-9]{3}$")) == true && input.toCharArray().distinct().size == 3
}