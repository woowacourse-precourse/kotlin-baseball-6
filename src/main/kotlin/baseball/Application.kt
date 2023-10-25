package baseball

fun main() {
    showGameInfo(InfoMsgType.StartGame)

    var isProgramEnded = false
    while (!isProgramEnded) {
        val answer: Array<Char> = createGameAnswer()
        var isGameEnded = false

        while (!isGameEnded) {
            val numberInput: Array<Char> = requestNumberInput()
            val (strikeNum, ballNum) = checkBallsAndStrikes(answer, numberInput)
            if (checkIfUserWin(strikeNum, ballNum)) {
                isGameEnded = true
            }
        }

        isProgramEnded = !requestRestartInput()
    }
}