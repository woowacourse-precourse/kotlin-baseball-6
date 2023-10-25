package baseball

object Dialogues {
    const val startGameMessage = "숫자 야구 게임을 시작합니다."
    const val requestEnterNumMessage = "숫자를 입력해주세요 : "
    const val gameOverMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val gameExitMessage = "게임 종료"
    const val restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    const val strikeMessage = "스트라이크"
    const val ballMessage = "볼"
    const val nothingMessage = "낫싱"
    const val illegalArgumentExceptionMessage = "서로 다른 세 자리 숫자를 입력해주세요."
}

object GameResult{
    const val STRIKE = "strike"
    const val BALL = "ball"
    const val NOTHING = "nothing"
}