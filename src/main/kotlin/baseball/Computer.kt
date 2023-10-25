import camp.nextstep.edu.missionutils.Randoms

class Computer {

    val computer: MutableList<Int> = mutableListOf()

    init {
        randomInit()
    }

    fun reset() {
        computer.clear()
        randomInit()
    }

    private fun randomInit() {
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }
}