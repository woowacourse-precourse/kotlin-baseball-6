package baseball

const val START_GAME = 1
const val END_GAME = 2
const val PLAYING = 3
const val GAME_OVER = 4

const val START_NUMBER = 1
const val END_NUMBER = 9
const val NUMBER_COUNT = 3

class BaseballGame(
    private val computer: Computer,
    private val user: User
) {
    private var gameState = END_GAME
    private var playState = GAME_OVER

    fun start() {
        gameState = START_GAME
        println("숫자 야구 게임을 시작합니다.")

        while (gameState == START_GAME) {
            play()
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            gameState = user.requestInputGameState()
        }

        user.requestEndInput()
    }

    private fun play() {
        playState = PLAYING
        computer.generateNumbers()

        while (playState == PLAYING) {
            print("숫자를 입력해주세요 : ")
            val userNumbers = user.requestInputNumbers()
            val ballCount = computer.calculateBallCount(userNumbers)
            val strikeCount = computer.calculateStrikeCount(userNumbers)

            showPlayMessage(ballCount, strikeCount)

            if (strikeCount == NUMBER_COUNT) playState = GAME_OVER
        }
    }

    private fun showPlayMessage(ballCount: Int, strikeCount: Int) {
        val message = mutableListOf<String>()

        if (ballCount == 0 && strikeCount == 0) {
            message.add("낫싱")
        }

        if (ballCount > 0) {
            message.add("${ballCount}볼")
        }

        if (strikeCount > 0) {
            message.add("${strikeCount}스트라이크")
        }

        println(message.joinToString(" "))

        if (strikeCount == NUMBER_COUNT) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        }
    }
}