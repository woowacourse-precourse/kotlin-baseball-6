package baseball

data class Score(
    val strike: Int,
    val ball: Int
) {
    fun toMessage() {
        when {
            this.strike == 3 -> println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            this.strike > 0 && this.ball > 0 -> println("${this.ball}볼 ${this.strike}스트라이크")
            this.strike > 0 -> println("${this.strike}스트라이크")
            this.ball > 0 -> println("${this.ball}볼")
            else -> println("낫싱")
        }
    }
}
