package baseball

fun main() {
    try {
        NumberBaseball
            .initRandomNumbers()
            .playBaseball()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 잘못된 입력 값입니다.")
    }
}
