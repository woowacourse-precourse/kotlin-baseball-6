package baseball

class Player {

    fun createComputerBallNumbers(): List<Int> {
        return readPlayerInput().map { it.toString().toInt() }
    }

    private fun readPlayerInput(): String {
        return readln()
    }

}