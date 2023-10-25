package baseball.view

class View {
    // 스트라이크, 볼 수 출력
    fun check(strikes: Int, balls: Int) : Boolean {
        var breakIdx : Boolean = false
        //판정
        // no balls
        if (balls == 0) {
            //낫싱
            if (strikes == 0) {
                println("낫싱")
            }
            //온리 스트라이크
            else {
                println( "${strikes}스트라이크" )
                if (strikes == 3) {
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                    breakIdx = true
                }
            }
        }
        // balls, strikes
        else if (strikes != 0) {
            println("${balls}볼 ${strikes}스트라이크")
        }
        // no strikes
        else {
            println("${balls}볼")
        }
        return breakIdx
    }

    fun restart() : String {
        val restart = readLine().toString()
        when (restart)
        {
            "1" ->
            {
                doNothing()
            }
            "2" ->
            {
                println("종료")
            }
            else ->
            {
                throw IllegalArgumentException()
            }
        }
        return restart
    }

    // 메세지 출력 함수
    fun gameStart() = println(GAME_START)
    fun requireInput() = println(REQUIRE_INPUT)

    companion object {
        const val GAME_START = "숫자 야구 게임을 시작합니다."
        const val REQUIRE_INPUT = "숫자를 입력해주세요 : "
    }

    fun doNothing() {}
}