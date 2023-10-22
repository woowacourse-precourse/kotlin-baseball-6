package baseball

import baseball.model.Answer
import baseball.utils.charToInt
import baseball.utils.toIntArray
import camp.nextstep.edu.missionutils.Console

/** [2&4]. 사용자 입력 (Controller) */
fun inputValidator(digit: Int, range: CharRange, answer: Answer?): IntArray {
    val inputData = printInputPrompt(digit)

    checkDigitRange(inputData, digit, range)
    if (digit == BASEBALL_DIGITS) {
        checkDuplicate(inputData, digit)
    } else if (digit == MENU_DIGITS) {
        checkMenu(inputData, answer!!)
    }

    return inputData.toIntArray()
}

/** [2&4]. 0) 입력을 위한 안내 문구 출력 (View) */
fun printInputPrompt(digit: Int): String {
    if (digit == BASEBALL_DIGITS) {
        print("숫자를 입력해주세요 : ")
    } else if (digit == MENU_DIGITS) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
    return Console.readLine() ?: ""
}

/** [2&4]. 1, 2) 입력된 문자열의 길이 및 범위 체크 (Model) */
fun checkDigitRange(
    inputData: String,
    digit: Int,
    range: CharRange
) {
    // 입력된 데이터 모두가 range에 속하는지 체크
    val rangeCheck = inputData.map { it }.all { it in range }

    if (inputData.length != digit) {
        throw IllegalArgumentException("입력된 값은 ${digit}자리가 아닙니다.")
    } else if (rangeCheck == false) {
        throw IllegalArgumentException("입력된 값 중에 ${range.first}~${range.last} 범위를 벗어난 수가 있습니다.")
    }
}

/** [2]. 3) 숫자 중복 체크 (Model) */
fun checkDuplicate(inputData: String, digit: Int) {
    val inputDataSet = inputData.map { it.charToInt() }.toSet()

    if (inputDataSet.size < digit) {
        throw IllegalArgumentException("입력된 숫자 간에 중복이 있습니다.")
    }
}

/** [4]. 4) 메뉴 입력 및 정답 재생성 (Model) */
fun checkMenu(inputData: String, answer: Answer) {
    val selectedMenu = inputData[0].charToInt()

    if (selectedMenu == 1) {
        answer.newGenerator() // 정답 재생성
    }
}