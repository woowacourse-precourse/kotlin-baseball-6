package baseball

class GameView {
    fun startGameView() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun inputNumberView() {
        print("숫자를 입력해주세요 : ")
    }

    fun hintView(strike: Int, ball: Int): String {
        return when {
            strike != 0 -> "${strike}스트라이크"
            ball != 0 -> "${ball}볼"
            strike != 0 && ball != 0 -> "${ball}볼 ${strike}스트라이크"
            else -> "낫싱"
        }
    }

    fun gameOverView() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}