package baseball.view



class Guide {
    fun start() {
        System.out.println(GAME_START)
    }
    fun inputUserNumber(){
        System.out.println(INPUT_NUMBER)
    }
    fun succeed(){
        System.out.println(SUCCEED)
    }
    fun restart(){
        System.out.println(RESTART)
    }
    companion object {
        private const val GAME_START = "숫자 야구 게임을 시작합니다."
        private const val INPUT_NUMBER = "숫자를 입력해주세요 : "
        private const val SUCCEED = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        private const val RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}