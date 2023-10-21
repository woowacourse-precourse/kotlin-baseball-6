package baseball
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

    fun start {
        println("숫자 야구 게임을 시작합니다.")

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}