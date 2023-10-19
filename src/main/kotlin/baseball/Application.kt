package baseball

fun main() {
    val ioHandler = IoHandler()
    val gameHandler = GameHandler(ioHandler)

    gameHandler.init()
}
