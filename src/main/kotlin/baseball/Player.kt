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
        // (1) 3자리수인가
        // (2) 서로 다른 3자리인가
        // (3) 숫자 외에 다른 값이 들어왔나
        // (4) 1~9 이외의 다른값이 들어왔나
    }

    // TODO 종료 입력 유효성 체크
    private fun checkPlayerDecisionValidity(userInput: String) {
        // (1) 1자리수인가
        // (2) 숫자 외에 다른 값이 들어왔나
        // (3) 1,2 이외의 다른 값이 들어왔나
    }

}