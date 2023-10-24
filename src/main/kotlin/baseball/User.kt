package baseball

import camp.nextstep.edu.missionutils.Console


class User() {

    /*
    입력한 값이 이상한 경우 Illegal반환
    자릿수가 3개가 아닌경우, 1~9가 아닌경우, 숫자가 아닌경, 중복된 숫자가 들어가있는 경우
     */
    fun userInputNum(): List<Int> {
        println("숫자를 입력해주세요 : ")
        val userNum = Console.readLine().map { it.digitToInt() }
        checkNumLength(userNum)
        checkInt(userNum)
        checkOverlap(userNum)

        return userNum
    }

    private fun checkNumLength(userNum: List<Int>) {
        if (userNum.size != 3) throw IllegalArgumentException(INPUT_LENGTH_ERROR)
    }

    private fun checkInt(userNum: List<Int>) {
        if (userNum.contains(0)) throw IllegalArgumentException(INPUT_RANGE_ERROR)
    }

    private fun checkOverlap(userNum: List<Int>) {
        if (userNum.distinct().size != 3) throw IllegalArgumentException(INPUT_NUMBER_DUPLICATE)
    }

    companion object {
        const val INPUT_LENGTH_ERROR = "숫자3자리를 입력해주세요."
        const val INPUT_RANGE_ERROR = "1~9사이 값이 아닙니다."
        const val INPUT_NUMBER_DUPLICATE = "중복된 숫자가 있습니다."
    }
}