package baseball

const val START_GAME = 1
const val END_GAME = 2
const val PLAYING = 3
const val NOT_PLAYING = 4

const val START_NUMBER = 1
const val END_NUMBER = 9
const val NUMBER_COUNT = 3

class BaseballGame(
    private val computer: Computer,
    private val user: User
) {
    private var gameState = END_GAME
    private var playState = NOT_PLAYING

    fun start() {
        gameState = START_GAME

        while (gameState == START_GAME) {
            println("숫자 야구 게임을 시작합니다.")
            play()
            gameState = user.requestInputGameState()
        }

        user.requestEndInput()
    }

    private fun play() {

    }
}