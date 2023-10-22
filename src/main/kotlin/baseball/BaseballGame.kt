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
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            gameState = user.requestInputGameState()
        }

        user.requestEndInput()
    }

    private fun play() {
        playState = PLAYING
        computer.generateNumbers()

        do {
            print("숫자를 입력해주세요 : ")
            val userNumbers = user.generateNumbers(user.requestInputNumbers())
            val strikeAndBallCounts = computer.calculateStrikeAndBall(userNumbers)

            if (strikeAndBallCounts.strike == NUMBER_COUNT) {
                playState = NOT_PLAYING
            }

            println("${strikeAndBallCounts.ball}볼 ${strikeAndBallCounts.strike}스트라이크")
        } while (playState == PLAYING)
    }
}