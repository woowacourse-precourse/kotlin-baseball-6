package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val GAME_START = "숫자 야구 게임을 시작합니다."
const val INPUT_NUMBER = "숫자를 입력해주세요 : "
const val GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART_OR_FINISH = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val NOTHING = "낫싱"
var restartOrFinish: Int? = null
fun main() {
    val controller = BaseballController()
    controller.startGame()
}

