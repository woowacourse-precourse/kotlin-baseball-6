package baseball

fun main() {
    try {
        println("숫자 야구 게임을 시작합니다.")
        while (NumberBaseball.isPlaying) {
            NumberBaseball.playBaseball()
                .askQuitOrRestart()
        }
        println("숫자 야구 게임을 종료합니다.")
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 잘못된 입력 값입니다.")
    }
}
