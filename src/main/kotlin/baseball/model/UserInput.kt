package baseball.model

import baseball.constants.GameConfig
import baseball.utils.charToInt
import baseball.utils.toIntArray

// Q1. 사용자 입력값 검증 로직을 이쪽으로에 두는 게 맞는 걸까?
// GPT A1. 입력 값에 따라 내부 상태가 변경되는 경우 해당 로직을 모델 내에 두는 것이 적절하다.

// setter 없음
open class UserInput {
    // Q2. validate를 자식에서 각각 오버라이드 해서 Baseball은 중복 검증을 추가로 수행하게 하는 게 맞을까?
    // GPT 23. 상속을 활용하는 좋은 예시라고 생각한다.

    /** Baseball, Menu 공통. 1, 2) 입력된 문자열의 길이 및 범위 체크  (Model) */
    open fun setDataWithValidation(
        userInputData: String = "",
        digit: Int? = null, range: CharRange? = null
    ) {
        if (userInputData.length != digit!!) {
            throw IllegalArgumentException("입력된 값($userInputData)은 ${digit}자리가 아닙니다.")
        }

        // 입력된 데이터 모두가 range에 속하는지 체크
        val rangeCheck = userInputData.map { it }.all { it in range!! }
        if (rangeCheck == false) {
            throw IllegalArgumentException("입력된 값($userInputData) 중에 ${range!!.first}~${range.last} 범위를 벗어난 문자가 있습니다.")
        }
    }
}

/** Baseball 객체에만 필요한 변수 및 메소드 구분 */
class BaseballInput : UserInput() {
    private var _inputDataArray: IntArray = intArrayOf()

    val inputDataArray: IntArray get() = _inputDataArray

    override fun setDataWithValidation(userInputData: String, digit: Int?, range: CharRange?) {
        super.setDataWithValidation(
            userInputData,
            GameConfig.BASEBALL_DIGITS,
            GameConfig.BASEBALL_RANGE,
        )
        // 숫자 중복 검사 추가 수행
        checkDuplicate(userInputData, GameConfig.BASEBALL_DIGITS)
        // 검증 이후 데이터 셋
        _inputDataArray = userInputData.toIntArray()
    }

    /** [2]. 3) 숫자 중복 체크 (Model) */
    fun checkDuplicate(userInputData: String, digit: Int) {
        val inputDataSet = userInputData.map {
            it.charToInt()
        }.toSet()

        if (inputDataSet.size < digit) {
            throw IllegalArgumentException("입력된 숫자($userInputData) 중에 중복이 있습니다.")
        }
    }

    data class BallStrike(val ball: Int, val strike: Int) // data class 하나로 코드가 굉장히 깔끔해졌다!!!

    /** [3]. 1) 매개변수 2개를 이용하여 BallStrike를 반환 (Model) */
    fun countBaseball(answer: IntArray): BallStrike {
        val calculateResult = BallStrike(
            countBall(answer),
            countStrike(answer)
        )
        return calculateResult
    }

    fun countBall(answer: IntArray): Int {
        return inputDataArray.filterIndexed { index, i ->
            i in answer.filter { it != answer[index] } // Ball
        }.size
    }

    fun countStrike(answer: IntArray): Int {
        return inputDataArray.filterIndexed { index, i ->
            i == answer[index] // Strike
        }.size
    }
}

/** Menu 객체에만 필요한 변수 및 메소드 구분 */
class MenuInput : UserInput() {
    var _selectedMenu: Int = -1
    val selectedMenu: Int get() = _selectedMenu

    override fun setDataWithValidation(userInputData: String, digit: Int?, range: CharRange?) {
        super.setDataWithValidation(
            userInputData,
            GameConfig.MENU_DIGITS,
            GameConfig.MENU_RANGE,
        )
        // 검증 이후 데이터 셋
        _selectedMenu = userInputData.toInt()
    }
}