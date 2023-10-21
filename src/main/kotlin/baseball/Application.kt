package baseball

fun createRandom(): Int {
    return (1..9).random()
}

fun main() {
    val computerList = listOf(createRandom(), createRandom(), createRandom())
    val baseBall = BaseBall(computerList)
    baseBall.startGame(computerList)
}


