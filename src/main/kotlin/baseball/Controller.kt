package baseball

import constants.Constant.COUNT
import constants.Constant.RESTART_STRING
import constants.Constant.TERMINATION_STRING

class Controller(private val model: model.BaseballModel, private val view: view.BaseballView){

    fun run(){
        model.setGame()  // 초기 게임 셋팅
        playGame()      // 게임 실행
        askRestart()   // 재시작 여부 물어보기
    }

    private fun playGame() {
        do {
            val userInput = view.getUserNumber()                // 사용자에게 숫자를 입력받음
            val (strike, ball) = model.checkAnswer(userInput)  // 정답과 비교해서 스트라이크 볼을 판정함
            view.printResult(strike, ball)                    // 결과 출력
        } while (strike != COUNT)                            // 스트라이크와 COUNT가 같지 않으면 게임 종료

        view.printGameEnd()                                 // 게임종료 문구 출력
    }

    private fun askRestart(){
        when(view.askRestart()){
            RESTART_STRING -> run()                       // 입력값이 재시작 상수이면 run함수 실행
            TERMINATION_STRING -> return                // 입력값이 종료 상수이면 게임 종료
            else -> throw IllegalArgumentException()  // 그 외의 입력값일 때 에러 발생
        }
    }
}
