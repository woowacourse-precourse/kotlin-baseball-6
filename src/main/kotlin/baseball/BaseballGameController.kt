package baseball

import baseball.model.Answer
import baseball.model.UserInput

/** [2]. 숫자 입력 받기 : 1 ~ 9 3자리
 * [3]. Ball, Strike 검증 함수 호출 (Controller)
 * */
fun inputBaseball(answer: IntArray, userInput: UserInput): Boolean {
    inputValidator(
        digit = BASEBALL_DIGITS,
        range = BASEBALL_RANGE,
        answer = null,
        userInput = userInput
    )

    val calculateResult = userInput.calculateBallAndStrike(answer)
    val (ball, strike) = calculateResult.first
        .split(", ")
        .map { it.toInt() }
    val isAllStrike = calculateResult.second

    calculateResultPrint(ball, strike)
    return isAllStrike
}

/** [4]. 메뉴 입력 받기 : 1 or 2 (Controller) */
fun inputRestart(answer: Answer, userInput: UserInput): Int {
    inputValidator(
        digit = MENU_DIGITS,
        range = MENU_RANGE,
        answer = answer,
        userInput = userInput
    )

    return userInput.inputDataArray
        .first()
}

// TODO : inputValidator에 파라미터가 4개로 증가함,, digit와 range를 enum을 활용하여 줄일 것 -> .으로 2번 접근해야함,,

/** [2&4]. 사용자 입력 (Controller) */
fun inputValidator(digit: Int, range: CharRange, answer: Answer?, userInput: UserInput) {
    printInputPrompt(digit, userInput)

    userInput.checkDigit(digit)
    userInput.checkRange(range)
    if (digit == BASEBALL_DIGITS) {
        userInput.checkDuplicate(digit)
    } else if (digit == MENU_DIGITS) {
        checkMenu(userInput, answer!!)
    }
    userInput.setArray() // inputDataArray 생성
}


/** [4]. 4) 메뉴 입력에 따른 정답 재생성 (Controller) */
fun checkMenu(userInput: UserInput, answer: Answer) {
    val selectedMenu = userInput.inputData[0]

    /* 데이터 관리 측면에서 Model로 봤지만, 언제 Model의 데이터를
       재생성 할 것 인지를 결정 한다는 측면에서 Controller에 가깝다고 한다.
       사용자 입력값을 기반으로 모델의 특정 로직을 실행할지 결정하는 역할 -> C
     */
    if (selectedMenu == '1') {
        answer.newGenerator() // 정답 재생성
    }
}