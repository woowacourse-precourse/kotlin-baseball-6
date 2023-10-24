package baseball.view

class OutputView {

    class Start{
        init {
            println("숫자 야구 게임을 시작합니다.")
        }
    }
    class NumInput {
        init {
            print("숫자를 입력해주세요 : ")
        }
    }

    fun Result(BallStrike:MutableList<Int>) {
        if (BallStrike[0] == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        } else if (BallStrike[0] == 0 && BallStrike[1] != 0) {
            println("${BallStrike[1]}볼")
        } else if (BallStrike[0] != 0 && BallStrike[1] == 0) {
            println("${BallStrike[0]}스트라이크")
        } else if (BallStrike[0] != 0 && BallStrike[1] != 0) {
            println("${BallStrike[1]}볼 ${BallStrike[0]}스트라이크")
        } else {
            println("낫싱")
        }
    }
}

