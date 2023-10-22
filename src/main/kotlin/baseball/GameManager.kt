package baseball

import camp.nextstep.edu.missionutils.Console

object GameManager {
    private lateinit var game: BaseBallGame

    fun startGame(){
        val answer = RandomNumberGenerator.generateRandomNumber()
        game = BaseBallGame(answer)

    }




}