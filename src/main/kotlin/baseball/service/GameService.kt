package baseball.service

import baseball.Game
import baseball.Player
import baseball.util.CheckUtil
import baseball.util.RandomUtil
import baseball.view.GameMessage

class GameService {

    private lateinit var game: Game
    private val gameMessage = GameMessage()
    private val player = Player()

    //게임을 준비
    fun setGame() {
        game = Game(RandomUtil.getRandomNumbers())
    }

    //게임을 시작
    fun startGame() {
        gameMessage.startGame()
        var strike = 0
        while (strike != 3) {
            val (strikeResult, ballResult) = simulateGame(game.answer)
            gameMessage.scoreMessage(ballResult, strikeResult)
            strike = strikeResult
        }
    }

    //야구 게임 시뮬레이터
    private fun simulateGame(answer: MutableList<Int>): Pair<Int, Int> {
        game.initCount()
        player.playerNumbers = getPlayerNumber()

        //모두 안맞을 경우
        answer.forEachIndexed { answerIndex, answer ->
            //컴퓨터의 첫번째번호가 들어온다.
            val answerNum = answer.toString()
            player.playerNumbers.forEachIndexed { playerNumberIndex, playerNumber ->
                //숫자의 위치와 번호가 동일하다면 strike
                if (playerNumberIndex == answerIndex && answerNum == playerNumber.toString()) game.increaseStrikeCount()
                //번호는 동일하지만 숫자의 위치가 동일하지 않는다면 ball
                if (answerNum == playerNumber.toString() && playerNumberIndex != answerIndex) game.increaseBallCount()
            }
        }

        return Pair(game.strikeCount, game.ballCount)

    }

    // player의 숫자 가져오기
    private fun getPlayerNumber(): String {
        gameMessage.requestInput()
        //입력된 숫자가 정확한 형태인지 파악을 한다.

        //null 체크를 해주고
        player.playerNumbers = camp.nextstep.edu.missionutils.Console.readLine()
        //input 형태가 맞는지 파악한다.
        CheckUtil.checkInput(player.playerNumbers)

        return player.playerNumbers
    }

    //replay 숫자 가져오기
    fun getReplay(): String {
        gameMessage.requestReplay()

        val replay = camp.nextstep.edu.missionutils.Console.readLine()
        CheckUtil.checkReplayInput(replay)

        return replay
    }


}