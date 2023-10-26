package baseball.view.input

import io.Renderable

class InputNextGameStatusView : Renderable {
    override fun render() = INPUT_NEXT_GAME_STATUS_MESSAGE

    companion object {
        const val INPUT_NEXT_GAME_STATUS_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
    }
}