package baseball
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var gameCoin = 1
    while(gameCoin == 1) {
        val baseballGame = BaseballOperate()
        if(!baseballGame.BaseballPlay()) {
            return
        }

        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        gameCoin = readLine()!!.toInt()
    }

}

/*
* 추가할 부분
* 1. 같은 숫자 (ex. 111, 998, 997 등등) 에 대해서 예외 처리
*
* */
