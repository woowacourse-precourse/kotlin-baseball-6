package baseball

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (NumberBaseball.isPlaying) {
        NumberBaseball.playNumberBaseball()
            .askQuitOrRestart()
    }
}
