package baseball.view.input

import io.Renderable

class GameStartView : Renderable {

    override fun render() = GAME_START_MESSAGE

    companion object {
        const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n"
    }
}