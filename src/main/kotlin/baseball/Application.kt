package baseball

import baseball.model.Playstatus
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var playStatus = Playstatus()
    val numberGenerator = NumberGenerator()
    val baseballGame = BaseballGame()
    try {
        while (playStatus.status) {
            startGame(playStatus, numberGenerator, baseballGame)
            playStatus.status = endOrRestartGame()
        }
        println("게임을 종료합니다.")
    } catch (e: IllegalArgumentException) {
        println(
            "잘못된 값을 입력하셨습니다. 올바른 형식의 숫자를 입력해주세요.\n" +
                    "프로그램을 종료합니다."
        )
    }
}

fun startGame(playStatus: Playstatus, numberGenerator: NumberGenerator, baseballGame: BaseballGame) {
    val targetNumbers = numberGenerator.generateRandomNum()
    while (playStatus.status) {
        val guessNumbers = numberGenerator.inputGuessNum()
        val baseball = baseballGame.compareNumbers(targetNumbers, guessNumbers)
        println(baseball.getResultMessage())
        if (baseball.isThreeStrikes()) {
            playStatus.gameOver()
            println("${baseball.strikes}개의 숫자를 모두 맞히셨습니다! 게임 종료.")
        }
    }
}

fun endOrRestartGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val playStatusInput = Console.readLine().toInt();
    when (playStatusInput) {
        1 -> return true
        2 -> return false
        else -> throw IllegalArgumentException()
    }
}
