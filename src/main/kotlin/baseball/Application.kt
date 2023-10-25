package baseball

fun main() {
    showGameInfo(InfoMsgType.StartGame)

    var isProgramEnded = false
    while(!isProgramEnded) {
        val answer : Array<Char> = createGameAnswer()
        val numberInput : Array<Char> = requestNumberInput()

        isProgramEnded = true
    }
}