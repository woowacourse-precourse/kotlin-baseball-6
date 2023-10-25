package baseball.model

import baseball.constants.GameConfig
import baseball.utils.charToInt
import baseball.utils.toIntArray

open class UserInput {
    /** [2, 4]. baseball, menu / 입력, 검증
     * 2.A) 입력된 문자열의 길이 검증
     * 2.B) 입력된 문자열의 범위 검증 (Model) */
    open fun setDataWithValidation(
        userInputData: String = "",
        digit: Int = 0,
        range: CharRange = CharRange('0', '0')
    ) {
        if (userInputData.length != digit) {
            throw IllegalArgumentException("입력된 값($userInputData)은 ${digit}자리가 아닙니다.")
        }

        // 입력된 데이터 모두가 range에 속하는지 체크
        val rangeCheck = userInputData.map { it }.all { it in range }
        if (rangeCheck == false) {
            throw IllegalArgumentException("입력된 값($userInputData) 중에 ${range.first}~${range.last} 범위를 벗어난 문자가 있습니다.")
        }
    }
}

/** Baseball 객체에만 필요한 변수 및 메소드 구분 */
class BaseballInput : UserInput() {
    private var _inputDataArray: IntArray = intArrayOf()

    val inputDataArray: IntArray get() = _inputDataArray

    override fun setDataWithValidation(userInputData: String, digit: Int, range: CharRange) {
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

    /** [2]. baseball / 입력, 검증
     * 2.C) 숫자 중복 체크 (Model) */
    fun checkDuplicate(userInputData: String, digit: Int) {
        val inputDataSet = userInputData.map {
            it.charToInt()
        }.toSet()

        if (inputDataSet.size < digit) {
            throw IllegalArgumentException("입력된 숫자($userInputData) 중에 중복이 있습니다.")
        }
    }

    data class BallStrike(val ball: Int, val strike: Int) // data class 하나로 코드가 굉장히 깔끔해졌다!!!

    /** [3]. baseball / 계산, 결과 출력
     * 1. Ball, Strike 계산 (Model) */
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

    override fun setDataWithValidation(userInputData: String, digit: Int, range: CharRange) {
        super.setDataWithValidation(
            userInputData,
            GameConfig.MENU_DIGITS,
            GameConfig.MENU_RANGE,
        )
        // 검증 이후 데이터 셋
        _selectedMenu = userInputData.toInt()
    }
}