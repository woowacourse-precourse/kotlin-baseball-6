package baseballView

class Input {
    object PlayMent{
        val playStartMent="숫자 야구 게임을 시작합니다."
        val inputMent="숫자를 입력해주세요 : "

    }
    init{
        println(PlayMent.playStartMent)
    }
    private fun endGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

}