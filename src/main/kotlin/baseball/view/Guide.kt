package baseball.view



class Guide {
    fun start() {
        System.out.println(GAME_START)
    }
    fun inputUserNumber(){
        System.out.println(INPUT_NUMBER)
    }
    companion object {
        private const val GAME_START = "숫자 야구 게임을 시작합니다."
        private const val INPUT_NUMBER = "숫자를 입력해주세요 : "
    }
}