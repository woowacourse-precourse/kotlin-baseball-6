package baseball

val gameManager: GameManager by lazy {
    GameManager()
}
fun main() {
    gameManager.gameMaking()
}
