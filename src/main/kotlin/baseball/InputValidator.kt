package baseball

import camp.nextstep.edu.missionutils.Console

/** [2&4]. 사용자 입력 */
fun inputVaildator(digit: Int, range: CharRange): IntArray {
    inputMessage(digit)
    var inputData = Console.readLine() ?: ""
    val inputDataIA = stringToUniqueIntArray(inputData)

    checkDigitRange(inputData, digit, range)
    // 메뉴 선택의 경우 1자리로 중복 검사가 필요 없음.
    if (digit == BASEBALL_DIGITS) {
        checkDuplicate(inputDataIA, digit)
    }
    return inputDataIA
}

/** [2&4]. 0) 입력을 위한 안내 문구 출력 */
fun inputMessage(digit: Int) {
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

    if (inputData.length != digit || rangeCheck == false) {
        throw IllegalArgumentException() // 오류 발생시키는 법 : throw Exception()
    }
}

/** [2]. 3) 숫자 중복 체크 */
fun checkDuplicate(inputDataIA: IntArray, digit: Int) {
    if (inputDataIA.size < digit) {
        throw IllegalArgumentException()
    }
}