package baseball

import baseball.model.Answer
import baseball.model.BaseballInput
import baseball.model.MenuInput
import baseball.model.UserInput
import camp.nextstep.edu.missionutils.Console

/** [2, 4] 2) 사용자 입력 검증 : baseball, menu 공통 처리 (Controller) */
fun inputValidator(
    userInput: UserInput,
    digit: Int,
    range: CharRange,
) {
    printInputPrompt(digit)
    val userInputData = Console.readLine() ?: ""
    userInput.setDataWithValidation(userInputData, digit, range)
}

/** [2]. 1) 숫자야구 입력 받기 : 1 ~ 9 3자리 (Controller) */
fun inputBaseball(baseballInput: BaseballInput) {
    inputValidator(
        userInput = baseballInput,
        digit = BASEBALL_DIGITS,
        range = BASEBALL_RANGE,
    )
}

/** [3]. 1) Ball, Strike 검증 함수 호출 (Controller) */
fun calculate(baseballInput: BaseballInput, answer: Answer): Boolean {
    val calculateResult = baseballInput.calculateBallAndStrike(answer.number)
    val (ball, strike) = calculateResult
        .split(", ")
        .map { it.toInt() }
    calculateResultPrint(ball, strike)

    val isAllStrike = calculateResult == "0, $BASEBALL_DIGITS"
    return isAllStrike
}

/** [4]. 1) 메뉴 입력 받기 : 1 or 2 (Controller) */
fun inputMenu(menuInput: MenuInput) {
    inputValidator(
        userInput = menuInput,
        digit = MENU_DIGITS,
        range = MENU_RANGE,
    )
}