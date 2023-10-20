package baseball

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    do {
        val playAgain = playGame()
    } while (playAgain.again)

    println("게임 종료")
}


fun playGame(): PlayAgain {
    // TODO: target number 생성

    // TODO: 유저 입력 가져오기 + validation 

    // TODO: 입력과 target number 비교 + 출력
    
    // TODO: 1 입력하면 again을 true, 2 입력하면 again false
    return PlayAgain(again = false)
}


@JvmInline
value class PlayAgain(val again: Boolean)