package baseball.util

object Validator {
    //플레이어의 입력값이 유효한 지 검사하는 함수
    fun checkUserInputValid(userInput: String) {
        if (!checkRegexMatch(userInput) || !checkDiffNums(userInput)) throw IllegalArgumentException()
    }

    //정규표현식과 일치하는 지 확인하는 함수
    private fun checkRegexMatch(userInput: String): Boolean {
        val regex = C.INPUT_REGEX.toRegex() //1-9사이의 숫자로 구성된 세 자릿수 정규표현식
        return regex.matches(userInput)
    }

    //중복된 숫자가 없는 지 확인하는 함수
    private fun checkDiffNums(userInput: String): Boolean = (userInput.length == userInput.toSet().size)
}