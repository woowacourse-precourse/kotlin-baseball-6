package baseball.view

class GameMessage {

    //player에게 숫자를 요구 문구
    fun requestInput() {
        print("숫자를 입력해주세요 : ")
    }

    //player에게 replay의 유무를 요구 문구
    fun requestReplay() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    //야구 게임 시작안내 문구
    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")
    }

    //게임 종료 문구
    fun gameOver() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    //볼, 스트라이크 점수 문구
    fun scoreMessage(ballCount: Int, strikeCount: Int) {
        if (ballCount == 0 && strikeCount == 0) println("낫싱")

        if (ballCount == 0 && strikeCount != 0) println("${strikeCount}스트라이크")

        if (ballCount != 0 && strikeCount == 0) println("${ballCount}볼")

        if (ballCount != 0 && strikeCount != 0) println("${ballCount}볼 ${strikeCount}스트라이크")

    }
}