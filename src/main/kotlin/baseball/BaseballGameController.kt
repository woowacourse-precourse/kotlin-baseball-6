package baseball

import baseball.model.Answer
import baseball.model.BaseballInput
import baseball.model.MenuInput
import baseball.model.UserInput

/** [2, 4 공통]. 사용자 입력 baseball-menu 공통 처리 (Controller) */
fun inputValidator(
    userInput: UserInput,
    digit: Int,
    range: CharRange,
) {
    val content: String = printInputPrompt(digit)
    userInput.setData(content)
    userInput.validate(digit, range)
    userInput.setArray() // inputDataArray 생성
}

/** [2]. 숫자 입력 받기 : 1 ~ 9 3자리 (Controller)
 * */
fun inputBaseball(baseballInput: BaseballInput) {
    inputValidator(
        userInput = baseballInput,
        digit = BASEBALL_DIGITS,
        range = BASEBALL_RANGE,
    )
    baseballInput.checkDuplicate(digit = BASEBALL_DIGITS) // 중복 검사
}

/** [3]. 1) Ball, Strike 검증 함수 호출 */
fun calculate(baseballInput: BaseballInput, answer: Answer): Boolean {
    val calculateResult = baseballInput.calculateBallAndStrike(answer.number)
    val (ball, strike) = calculateResult.first
        .split(", ")
        .map { it.toInt() }

    calculateResultPrint(ball, strike)
    return calculateResult.second
}

/** [4]. 1) 메뉴 입력 받기 : 1 or 2 (Controller) */
fun inputMenu(
    menuInput: MenuInput,
) {
    inputValidator(
        userInput = menuInput,
        digit = MENU_DIGITS,
        range = MENU_RANGE,
    )
}