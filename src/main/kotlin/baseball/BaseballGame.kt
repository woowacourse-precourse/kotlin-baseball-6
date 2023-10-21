class BaseballGame {
    private val computerNum = mutableListOf<Int>()

    init {
        generateRandomNumber()
    }

    private fun generateRandomNumber() {
        while (computerNum.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber)
            }
        }
    }

}