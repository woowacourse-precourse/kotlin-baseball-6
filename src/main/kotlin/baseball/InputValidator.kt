package baseball

import camp.nextstep.edu.missionutils.Console

/** [2&4]. 사용자 입력 */
fun inputValidator(digit: Int, range: CharRange): IntArray {
    printInputPrompt(digit)
    val inputData = Console.readLine() ?: ""
    checkDigitRange(inputData, digit, range)

    val inputDataArray = inputData.toUniqueIntArray()
    checkDuplicate(inputDataArray, digit)
    return inputDataArray
}

/** [2&4]. 0) 입력을 위한 안내 문구 출력 */
fun printInputPrompt(digit: Int) {
    if (digit == BASEBALL_DIGITS) {
        print("숫자를 입력해주세요 : ")
    } else if (digit == MENU_DIGITS) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}

/** [2&4]. 1, 2) 입력된 문자열의 길이 및 범위 체크 */
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

/** [2]. 3) 숫자 중복 체크 */
fun checkDuplicate(inputDataArray: IntArray, digit: Int) {
    if (inputDataArray.size < digit) {
        throw IllegalArgumentException("입력된 숫자에 중복이 있습니다.")
    }
}