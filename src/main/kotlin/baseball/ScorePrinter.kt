package baseball

class ScorePrinter {
    fun print(score: Score) {
        when {
            score.strike == 3 -> println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            score.strike > 0 && score.ball > 0 -> println("${score.ball}볼 ${score.strike}스트라이크")
            score.strike > 0 -> println("${score.strike}스트라이크")
            score.ball > 0 -> println("${score.ball}볼")
            else -> println("낫싱")
        }
    }
}
