package baseball.model

import baseball.BASEBALL_DIGITS
import baseball.utils.charToInt
import baseball.utils.toIntArray

// 사용자 입력값과 검증 로직을 이쪽으로 따로 빼는 게 맞는 걸까?
class UserInput {
    private var _inputData: String = ""
    private var _inputDataArray: IntArray = intArrayOf()
    val inputData: String get() = _inputData
    val inputDataArray: IntArray get() = _inputDataArray

    internal fun setData(content: String) {
        _inputData = content
    }

    internal fun setArray() {
        _inputDataArray = inputData.toIntArray()
    }

    /** [2&4]. 1) 입력된 문자열의 길이 체크  (Model) */
    fun checkDigit(
        digit: Int,
    ) {
        if (inputData.length != digit) {
            throw IllegalArgumentException("입력된 값은 ${digit}자리가 아닙니다.")
        }
    }

    /** [2&4]. 2) 입력된 문자열의 범위 체크  (Model) */
    fun checkRange(range: CharRange) {
        // 입력된 데이터 모두가 range에 속하는지 체크
        val rangeCheck = inputData.map { it }.all { it in range }

        if (rangeCheck == false) {
            throw IllegalArgumentException("입력된 값 중에 ${range.first}~${range.last} 범위를 벗어난 수가 있습니다.")
        }
    }

    /** [2]. 3) 숫자 중복 체크 (Model) */
    fun checkDuplicate(digit: Int) {
        val inputDataSet = inputData.map { it.charToInt() }.toSet()

        if (inputDataSet.size < digit) {
            throw IllegalArgumentException("입력된 숫자 간에 중복이 있습니다.")
        }
    }

    /** [3]. 1) 매개변수 2개를 이용하여 "S, B" 형태로 변환 (Model) */
    fun calculateBallAndStrike(answer: IntArray): Pair<String, Boolean> {
        var calculateResult = "" + inputDataArray.filterIndexed { index, i ->
            i in answer.filter { it != answer[index] } // Ball
        }.size

        calculateResult += ", " + inputDataArray.filterIndexed { index, i ->
            i == answer[index] // Strike
        }.size

        val isAllStrike = "0, $BASEBALL_DIGITS" == calculateResult
        return Pair(calculateResult, isAllStrike)
    }
}