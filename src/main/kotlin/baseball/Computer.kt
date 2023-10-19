package baseball

object Computer {

    fun generateComputerNumbers(): Int {
        val computerNumbers = mutableSetOf<Int>()

        while (computerNumbers.size < 3) {
            computerNumbers.add(RandomNumber.generateRandomNumbers())
        }

        return computerNumbers.joinToString("").toInt()
    }
}