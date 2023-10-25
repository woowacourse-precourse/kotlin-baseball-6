package baseball

import baseball.constants.GameConfig
import baseball.model.Answer
import baseball.model.BaseballInput
import baseball.model.MenuInput
import baseball.model.UserInput
import camp.nextstep.edu.missionutils.Console

/** [2, 4]. baseball, menu / 입력, 검증
 * 1. 안내 문구 call, 사용자 입력
 * 2. 사용자 입력 검증 call (Controller) */
fun inputDataWithValidator(userInput: UserInput, digit: Int) {
    printInputPrompt(digit)

    val userInputData = Console.readLine() ?: ""
    userInput.setDataWithValidation(userInputData)
}

fun inputBaseballWithValidator(baseballInput: BaseballInput) {
    inputDataWithValidator(baseballInput, GameConfig.BASEBALL_DIGITS)
}
fun inputMenuWithValidator(menuInput: MenuInput) {
    inputDataWithValidator(menuInput, GameConfig.MENU_DIGITS)
}

/** [3]. baseball / 계산, 결과 출력
 * 1. Ball, Strike 계산 함수 call
 * 2. 계산 결과 출력 함수 call (Controller) */
fun calculateBaseball(baseballInput: BaseballInput, answer: Answer): Boolean {
    val (ball, strike) = baseballInput.countBaseball(answer.number) // Controller -> Model
    printCalculateResult(ball, strike) // Controller -> View

    val isAllStrike = (strike == GameConfig.BASEBALL_DIGITS)
    return isAllStrike
}