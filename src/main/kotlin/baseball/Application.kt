package baseball

fun main() {
    val computer = Computer()
    val user = User()
    val baseballGame = BaseballGame(computer = computer, user = user)

    baseballGame.start()
}