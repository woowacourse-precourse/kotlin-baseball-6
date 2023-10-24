package baseball

fun main() {
    var run = " 숫자 야구 게임에 오신 것을 환영합니다 :) "
    var gameInfo: String = ""

    while (true) {
        println("[1] 게임 시작하기 [2] 게임 종료하기")
        val selectStart = readLine()?.toInt()

        if (!(selectStart == 1 || selectStart == 2)) {
            println("잘못된 입력입니다.")
            return
        }

        when (selectStart) {
            1 -> gameInfo = "숫자 야구 게임을 시작합니다."
            2 -> gameInfo = "숫자 야구 게임을 종료합니다."
        }
        println(gameInfo)
        break
    }
}

