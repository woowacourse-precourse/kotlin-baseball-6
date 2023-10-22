package baseball

fun gameRun(){
    var keepPlaying: Boolean = true
    do {
        println("숫자 야구 게임을 시작합니다.")
        val computerNumber = randNumber()
        var strikeCount = 0

        while (strikeCount != 3) {
            strikeCount = compareNumber(computerNumber)
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput = readLine()!!.trim()
        keepPlaying = when (userInput) {
            "1" -> true
            "2" -> false
            else -> throw IllegalArgumentException()
        }

    } while (keepPlaying)

    println("게임을 종료합니다.")
}