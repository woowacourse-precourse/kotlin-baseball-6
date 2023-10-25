package baseball


fun main() {
    println("숫자 야구 게임을 시작합니다")
    val game = BaseballGame()
    // 게임이 끝나고 1을 입력하면 게임 다시 시작
    while (game.baseballGameStart() == "1");
}
