package baseball

import baseball.constants.GameConfig
import baseball.model.Answer
import baseball.model.BaseballInput
import baseball.model.MenuInput
import baseball.model.UserInput
import camp.nextstep.edu.missionutils.Console

/** [2, 4] 2) 사용자 입력 검증 : baseball, menu 공통 처리 (Controller) */
fun inputValidator(userInput: UserInput, digit: Int) {
    printInputPrompt(digit)

    val userInputData = Console.readLine() ?: ""
    userInput.setDataWithValidation(userInputData)
}

// 단일 라인이긴 하지만 '='로 반환하기에 길이가 김
/** [2]. 1) 숫자야구 입력 받기 : 1 ~ 9 3자리 (Controller) */
fun inputBaseball(baseballInput: BaseballInput) {
    inputValidator(baseballInput, GameConfig.BASEBALL_DIGITS)
}
// 단일 라인이긴 하지만 '='로 반환하기에 길이가 김
/** [4]. 1) 메뉴 입력 받기 : 1 or 2 (Controller) */
fun inputMenu(menuInput: MenuInput) {
    inputValidator(menuInput, GameConfig.MENU_DIGITS)
}

/** [3]. 1) Ball, Strike 검증 함수 호출 (Controller) */
fun calculate(baseballInput: BaseballInput, answer: Answer): Boolean {
    val calculateResult = baseballInput.countBaseball(answer.number) // Controller -> Model

    val (ball, strike) = calculateResult
        .split(GameConfig.DELIMITER)
        .map { it.toInt() }

    calculateResultPrint(ball, strike) // Controller -> View

    val isAllStrike = (strike == GameConfig.BASEBALL_DIGITS)
    return isAllStrike
}