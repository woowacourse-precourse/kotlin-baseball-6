package baseball

fun checkIfUserWin(strikeNum: Int, ballNum: Int): Boolean {
    if (ballNum == 0 && strikeNum == 0) {
        println("낫싱")
    } else if (ballNum == 0) {
        println("${strikeNum}스트라이크")
        if (strikeNum == 3) {
            showGameInfo(InfoMsgType.EndGame)
            return true
        }
    } else if (strikeNum == 0) {
        println("${ballNum}볼")
    } else if (strikeNum != 0 && ballNum != 0) {
        println("${ballNum}볼 ${strikeNum}스트라이크")
    }
    return false
}