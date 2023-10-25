package baseball.manager

class MessageManager {

    fun printStartGame() = println("숫자 야구 게임을 시작합니다.")
    fun printEnterNumber() = print("숫자를 입력해주세요 : ")

    fun printEndGame() {
        println(
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        )
    }

    fun printScore(ball: Int, strike: Int) {
        if (ball == 0 && strike == 0) {
            println("낫싱")
        } else if (ball == 0) {
            println("${strike}스트라이크")
        } else if (strike == 0) {
            println("${ball}볼")
        } else {
            println("${ball}볼 ${strike}스트라이크")
        }
    }
}