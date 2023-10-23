package baseball

class BaseballGameModel {
    // 게임 상태를 나타내는 속성
    var isGameRunning = false
    var userNumber: String = ""
    var hint: String = ""
    var answer = ""

    // 새 게임을 시작하는 함수
    fun startNewGame() {
        // 게임 상태 초기화
        isGameRunning = true
        userNumber = ""
        hint = ""
        answer = ""
    }
}