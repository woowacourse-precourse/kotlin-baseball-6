package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {

    fun pickBaseBallNumber(): List<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < BASEBALL_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }

        return computerNumber
    }

    fun inputBaseBallNumber(): List<Int> {
        val inputBaseBallNumber = Console.readLine().map {it ->
            it.code - '0'.code
        }
        //validate(inputBaseBallNumber)

        return inputBaseBallNumber
    }

    fun validateInputBaseBallSize(inputBaseBallNumber: List<Int>) {
        if (inputBaseBallNumber.size != BASEBALL_SIZE) {
            throw IllegalArgumentException("3개의 숫자를 입력해주세요.")
        }
    }

    fun validateInputBaseBallDuplication(inputBaseBallNumber: List<Int>) {
        val distinctBaseBallNumber = inputBaseBallNumber.distinct()
        if (distinctBaseBallNumber.size != BASEBALL_SIZE) {
            throw IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.")
        }
    }

    companion object {
        const val BASEBALL_SIZE = 3
    }

}