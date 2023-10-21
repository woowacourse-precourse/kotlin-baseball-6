package baseball.view



class Guide {
    fun start() {
        System.out.println(GAME_START)
    }
    companion object {
        private const val GAME_START = "숫자 야구 게임을 시작합니다."
    }
}