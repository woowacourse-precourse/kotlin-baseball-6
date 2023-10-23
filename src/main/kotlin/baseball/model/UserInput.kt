package baseball.model

import baseball.BASEBALL_DIGITS
import baseball.utils.charToInt
import baseball.utils.toIntArray

// Q1. 사용자 입력값 검증 로직을 이쪽으로에 두는 게 맞는 걸까?
// Q2. baseball과 menu입력을 한 곳에서 처리하면 안 되나?

open class UserInput {
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

    // Q. validate를 자식에서 각각 오버라이드 해서
    // Baseball은 중복 검증을 추가로 수행하게 하는 게 맞을까?
    /** Baseball, Menu 공통. 1, 2) 입력된 문자열의 길이 및 범위 체크  (Model) */
    fun validate(digit: Int, range: CharRange) {
        // 입력된 데이터 모두가 range에 속하는지 체크
        val rangeCheck = inputData.map { it }.all { it in range }

        if (inputData.length != digit) {
            throw IllegalArgumentException("입력된 값은 ${digit}자리가 아닙니다.")
        } else if (rangeCheck == false) {
            throw IllegalArgumentException("입력된 값 중에 ${range.first}~${range.last} 범위를 벗어난 수가 있습니다.")
        }
    }
}

/** Baseball 객체에만 필요한 변수 및 메소드 구분 */
class BaseballInput : UserInput() {

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

        val isAllStrike: Boolean = "0, $BASEBALL_DIGITS" == calculateResult
        return Pair(calculateResult, isAllStrike)
    }
}

/** Menu 객체에만 필요한 변수 및 메소드 구분 */
class MenuInput : UserInput() {
    val selectedMenu: Int get() = inputDataArray[0]
}