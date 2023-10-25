package baseball

enum class InfoMsgType(val msg: String) {
    StartGame("숫자 야구 게임을 시작합니다."),
    RequestNumberInput("숫자를 입력해주세요 : "),
    EndGame("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RequestRestartInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
}

fun showGameInfo(msgType: InfoMsgType) {
    when (msgType) {
        InfoMsgType.StartGame -> println(msgType.msg)
        InfoMsgType.RequestNumberInput -> print(msgType.msg)
        InfoMsgType.RequestRestartInput -> println(msgType.msg)
        InfoMsgType.EndGame -> println(msgType.msg)
    }
}