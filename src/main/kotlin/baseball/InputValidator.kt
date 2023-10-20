package baseball

import camp.nextstep.edu.missionutils.Console

/** [2]. 사용자 입력 */
fun inputVaildator(digit: Int, range: CharRange): IntArray {
    if (digit == BASEBALL_DIGITS) {
        print("숫자를 입력해주세요 : ")
    } else if (digit == MENU_DIGITS) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    var inputData = Console.readLine() ?: ""
    checkDigitRange(inputData, digit, range)
    return checkDuplicate(inputData, digit)
}
/** [2]. (2, 4) 입력된 문자열의 길이 및 범위 체크 */
fun checkDigitRange(
    inputData: String,
    digit: Int,
    range: CharRange
) {
    // 입력된 데이터 모두가 range에 속하는지 체크
    val rangeCheck = inputData.map { it }
        .all { it in range }

    if (inputData.length != digit || rangeCheck == false) {
        throw IllegalArgumentException() // 오류 발생시키는 법 : throw Exception()
    }
}

/** [2]. (2) 3) 숫자 중복 체크 */
fun checkDuplicate(inputData: String, digit: Int): IntArray {
    // 숫자 중복이 있는지 : String -> Array -> Set으로 변환하여 size 조사
    val inputDataSet = inputData
        .map { it.charToInt() }
        .toIntArray()
        .toSet()

    if (inputDataSet.size < digit) {
        throw IllegalArgumentException()
    }
    return inputDataSet.toIntArray()
}

