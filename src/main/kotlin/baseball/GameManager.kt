package baseball

import camp.nextstep.edu.missionutils.Console

object GameManager {
    private lateinit var game: BaseBallGame

    fun startGame(){
        val answer = RandomNumberGenerator.generateRandomNumber()
        game = BaseBallGame(answer)

        askRetry()
    }

    fun askRetry(){
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        when (Console.readLine()){
            "1" -> startGame()
            "2" -> return
            else -> throw IllegalArgumentException("")
        }
    }


}