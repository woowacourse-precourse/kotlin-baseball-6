package baseball

import kotlin.IllegalArgumentException
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var gameCoin = 1
    while(gameCoin == 1) {
        val baseballGame = BaseballOperate()
        if(!baseballGame.baseballPlay()) {
            throw IllegalArgumentException()
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        gameCoin = Console.readLine().toInt()
        if(gameCoin != 1 && gameCoin != 2) {
            throw IllegalArgumentException()
        }
    }

}
