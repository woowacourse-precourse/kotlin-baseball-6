package baseball.view

import baseball.controller.GameManager

class OutputView {

    class Start{
        init {
            println("숫자 야구 게임을 시작합니다.")
            GameManager()
        }
    }
    class NumInput {
        init {
            print("숫자를 입력해주세요 : ")
        }
    }

    class ROS {
        init {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        }
    }

    fun Result(BallStrike:MutableList<Int>) {
        if (BallStrike[0] == 3) {
            println("3스트라이크")
            print("3개의 숫자를 모두 맞히셨습니다! ")
            println("게임 종료")
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

