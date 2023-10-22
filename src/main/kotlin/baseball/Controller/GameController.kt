package baseball.Controller

import baseball.CheckException
import baseball.model.GameNumber
import baseball.view.GamePharases

class GameController {

    val gameNum = GameNumber()
    val gamePhr = GamePharases()
    val check = CheckException()

    fun play(){
        //게임시작 문구
        gamePhr.startGame()

        //상대방(컴퓨터) 수 생성
        val ans = gameNum.createNum()

        //정답 입력 및 예외체크
        val num = gamePhr.inputNum()
        check.checkInput(num)

    }
}