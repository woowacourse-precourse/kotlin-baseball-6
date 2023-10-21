package baseball.service

import baseball.model.BaseballGame
import baseball.model.GameState
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGameService() {

    val inputView: InputView by lazy { InputView() }
    val outputView: OutputView by lazy { OutputView() }

    fun start() {
        val baseballGame = BaseballGame()
        while (baseballGame.state != GameState.EXIT) {
            when (baseballGame.state) {
                GameState.START -> {
                    //TODO 게임시작 메시지 출력
                    //TODO 컴퓨터 난수 생성
                    //TODO Game Run
                }
                GameState.RUN -> {
                    //TODO 숫자 입력 메시지 출력
                    //TODO User 숫자 입력
                    //TODO User 숫자, Computer 숫자 비교
                    //TODO 3스트라이크일경우 문구 출력 , Game End
                }

                GameState.END -> {
                    //TODO 게임 종료 문구 출력
                    //TODO 재시작 옵션 입력
                    //TODO 옵션에 따라 Game 상태 변경
                }
                else -> break
            }
        }
    }
}