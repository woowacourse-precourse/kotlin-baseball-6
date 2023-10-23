package baseball.Controller

import baseball.CheckException
import baseball.model.GameNumber
import baseball.view.GamePharases

class GameController {

    val gameNum = GameNumber()
    val gamePhr = GamePharases()
    val check = CheckException()

    lateinit var ans: String
    var strike = 0
    var ball = 0
    var nothing = 0
    fun play() {
        //게임시작 문구
        gamePhr.startGame()

        //상대방(컴퓨터) 수 생성
        ans = gameNum.createNum()
        println(ans)

        //정답 입력 및 예외체크
        val input = gamePhr.inputNum()
        check.checkInput(input)

        checkCount(input)
        showResult()

        if(strike == 3){
            gamePhr.correctAns()
        }

    }

    //정답 카운트 체크
    fun checkCount(input: String) {
        strike = 0
        ball = 0
        nothing = 0

        for (i in 0 until 3) {
            if (!ans.contains(input[i])) {
                nothing++
            }

            if (ans.contains(input[i]) && ans[i] != input[i]) {
                ball++
            }

            if (ans.contains(input[i]) && ans[i] == input[i]) {
                strike++
            }
        }
    }

    //정답 결과 출력
    fun showResult() {
        if (nothing == 3) {
            println("낫싱")
            return
        }
        if (ball != 0 && strike != 0) {
            println("${ball}볼 ${strike}스트라이크")
        }
        if (ball == 0 && strike != 0) {
            println("${strike}스트라이크")
        }
        if (ball != 0 && strike == 0) {
            println("${ball}스트라이크")
        }

    }
}