package baseball

// 채점 기능 클래스
class Referee {
    private var strike = 0
    private var ball = 0

    // 채점 기능
    fun getResult(computerNums: MutableList<Int>, userNums: MutableList<Int>): Boolean {
        strike = 0
        ball = 0

        computerNums.forEachIndexed { i, computerNum ->
            userNums.forEachIndexed { j, userNum ->
                if (computerNum == userNum) {
                    if (i == j) strike++
                    else ball++
                }
            }
        }

        return if (strike == 3) {
            showCorrectMessage()
            true
        } else {
            showHintMessage()
            false
        }
    }

    private fun showCorrectMessage() {
        println("${strike}스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun showHintMessage() {
        if (strike > 0 && ball > 0) println("${ball}볼 ${strike}스트라이크")
        else if (strike == 0 && ball > 0) println("${ball}볼")
        else if (strike > 0 && ball == 0) println("${strike}스트라이크")
        else println("낫싱")
    }
}