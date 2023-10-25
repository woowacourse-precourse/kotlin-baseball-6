package baseball
import camp.nextstep.edu.missionutils.Console

class GameView (private val check: InputCheck){
    fun startGameView() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun inputNumberView() : String {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine() ?: ""
        check.userNumberCheck(input)
        return input
    }

    fun restartInputView() : String {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val flag = Console.readLine() ?: ""
        check.restartNumberCheck(flag.toIntOrNull())
        return flag
    }

    fun makeHint(strike: Int, ball: Int): String {
        if (strike == 0 && ball == 0) return "낫싱"
        if (strike != 0 && ball != 0) return "${ball}볼 ${strike}스트라이크"
        if (strike != 0) return "${strike}스트라이크"
        return "${ball}볼"
    }

    fun hintView(strike: Int, ball: Int) {
        val hint = makeHint(strike, ball)
        println(hint)
    }
}