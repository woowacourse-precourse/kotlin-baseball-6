package baseball.validation

import baseball.console.GameConsole.answer

// 유효값을 확인하는 클래스 입니다.
class CheckNumberValidation {

    // 유저의 숫자 입력 값의 유효성을 확인합니다.
    fun checkUserAnswer() {
        checkLength()
        checkValidationAnswer()
    }

    // 유저의 다음 단계 입력 값의 유효성을 확인합니다.
    // 재시작 응답이 1이나 2인지 확인합니다.
    fun checkNextStep() {
        if (!(answer == "1" || answer == "2"))
            throw IllegalArgumentException("1이나 2를 입력해야 합니다.")
    }

    private fun checkValidationAnswer(){
        val userNumber = mutableListOf<Char>()
        for (index in answer.indices) {
            checkIsNumber(index)
            checkDuplicate(userNumber, index)
        }
    }

    // 숫자인지 확인합니다.
    private fun checkIsNumber(index: Int) {
        if (answer[index] !in '1'..'9')
            throw IllegalArgumentException("숫자가 아닙니다.")
    }

    // 중복을 확인합니다.
    private fun checkDuplicate(
        userNumber: MutableList<Char>,
        index: Int
    ) {
        if (userNumber.contains(answer[index]))
            throw IllegalArgumentException("중복 값이 있습니다.")
        userNumber.add(answer[index])
    }

    // 입력 값의 길이를 확인합니다.
    private fun checkLength() {
        if (answer.length != 3)
            throw IllegalArgumentException("3글자를 입력해야 합니다.")
    }


}