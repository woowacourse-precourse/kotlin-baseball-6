package baseball


class Player {

    fun createPlayerBallNumbers(): List<Int> {
        val numbersInput = readln()
        checkBallNumbersValidity(numbersInput)
        return numbersInput.map { it.toString().toInt() }
    }

    fun getGameEndDecision(): String {
        val userInput = readln()
        checkPlayerDecisionValidity(userInput)
        return userInput
    }

    // TODO 로또 번호 유효성 체크
    private fun checkBallNumbersValidity(numbersInput: String) {
        checkIsNumberCountThree(numbersInput)
        checkIsUniqueThreeNumber(numbersInput)
        checkIsNumber(numbersInput)
        checkHasCorrectNumRange(numbersInput)
    }

    // TODO 종료 입력 유효성 체크
    private fun checkPlayerDecisionValidity(userInput: String) {
        // (1) 1자리수인가
        // (2) 숫자 외에 다른 값이 들어왔나
        // (3) 1,2 이외의 다른 값이 들어왔나
    }

    private fun checkIsNumberCountThree(input: String) {
        require(input.length == 3) { "입력 숫자는 3자리 숫자여야 합니다." }
    }

    private fun checkIsUniqueThreeNumber(input: String) {
        require(input.length == input.toSet().size) { "입력 숫자는 서로 다른 3자리 숫자여야 합니다." }
    }

    private fun checkIsNumber(input: String) {
        require(input.toIntOrNull() != null) { "숫자 이외의 값은 입력될 수 없습니다." }
    }

    private fun checkHasCorrectNumRange(input: String) {
        require(input.all { it in MIN_BALL_NUMBER..MAX_BALL_NUMBER }) { "1~9 이외의 숫자는 입력될 수 없습니다." }
    }

    companion object {
        const val MIN_BALL_NUMBER = '1'
        const val MAX_BALL_NUMBER = '9'
    }

}