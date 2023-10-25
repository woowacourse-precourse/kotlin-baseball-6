package baseball.domain.game

class Turn(private val gameContinue: Boolean) {

    override fun toString(): String {
        return if(this.gameContinue) {
            "게임을 진행합니다."
        } else
        {
            "게임을 종료합니다."
        }
    }
}
