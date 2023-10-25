package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class NumberBaseball() {

    /* 1~9의 서로 다른 랜덤 수 3개 선택 */
    fun getRandom(computer: ArrayList<Int>) {
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }

    /* 게임 진행 */
    fun playGames(computer: ArrayList<Int>) {
        var ball: Int
        var strike: Int = 0

        while (strike < 3) {
            ball = 0
            strike = 0

            /* 예상 수 입력 */
            print("숫자를 입력해주세요 : ")
            val playerLine = Console.readLine()
            val player = playerLine.map { it.toString().toInt() }

            /* 입력 예외 처리 */
            if (playerLine.toInt() !in 111..999
                || player[0] == player[1] || player[1] == player[2] || player[0] == player[2]
            ) {
                throw IllegalArgumentException("Wrong Input")
            }

            /* 볼과 스트라이크 수 계산 */
            for (i in 0..2) {
                if (player[i] == computer[i])
                    strike++

                for (j in 0..2) {
                    if (i != j && player[i] == computer[j])
                        ball++
                }
            }

            /* 힌트 출력 */
            if (ball > 0 && strike > 0)
                println("\n${ball}볼 ${strike}스트라이크")
            else if (ball > 0)
                println("\n${ball}볼")
            else if (strike > 0)
                println("\n${strike}스트라이크")
            else
                println("낫싱")
        }

        /* 승리 안내 문구 */
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")     // 게임 시작

    while(true) {
        val computer: ArrayList<Int> = arrayListOf()

        NumberBaseball().getRandom(computer)    // 정답 랜덤 수 선택
        NumberBaseball().playGames(computer)    // 게임 진행

        /* 게임 재진행 여부 결정 */
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val restart = Console.readLine()
        if(restart == "2")
            break
    }
}