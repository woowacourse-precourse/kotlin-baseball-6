package baseball

fun main() {
    val ioHandler = IOHandler()
    val gameHandler = GameHandler(ioHandler)

    gameHandler.start()
}
