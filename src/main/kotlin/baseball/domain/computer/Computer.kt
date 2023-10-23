package baseball.domain.computer

import camp.nextstep.edu.missionutils.Randoms

class Computer(val numbers: List<Int>) {

    init {
        require(this.numbers.distinct().size == this.numbers.size) { DUPLICATED_ERROR_MESSAGE }
        require(this.numbers.all { it in 1..9 }) { OUT_OF_RANGE_ERROR_MESSAGE }
    }


    companion object {
        private const val DUPLICATED_ERROR_MESSAGE = "컴퓨터가 선택한 숫자 중에는 중복되는 숫자가 없어야 합니다."
        private const val OUT_OF_RANGE_ERROR_MESSAGE = "컴퓨터가 선택한 숫자는 1부터 9까지의 범위 안에 있어야 합니다."

        fun setRandomNumbers(): Computer {
            val numbers = mutableListOf<Int>()
            while (numbers.size < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber)
                }
            }
            return Computer(numbers)
        }
    }
}
