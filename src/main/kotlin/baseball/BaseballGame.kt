package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame() {

    fun gameStart() {
        println("숫자 야구 게임을 시작합니다.")
        while (true) {
            // 랜덤 숫자 생성받기
            val computer = makeRandomBallNumber()
            println("숫자 야구 게임을 시작합니다.")
            while (true){
                println("숫자를 입력해주세요 : ")
                val user = Console.readLine()
                // 입력에서 예외를 확인한다
                inputNumberException(user)
                // 결과를 출력한다
                println(resultString(countingBall(computer, user), countingStrike(computer, user)))
                if (checkThreeStrike(computer, user)) break
            }
            // 재시작
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            if (reGame()) break
        }
    }

    private fun makeRandomBallNumber(): MutableList<Int> {
        // todo 임의의 수 받기
    }

    private fun reGame(): Boolean {
        // todo 재시작
    }

    private fun countingBall(computer: MutableList<Int>, input: String): Int {
        // todo 볼 개수 확인
    }

    private fun countingStrike(computer: MutableList<Int>, input: String): Int {
        // todo 스트라이크 개수 확인
    }

    private fun resultString(ball: Int, strike: Int): String {
        // todo 결과 확인
    }

    private fun checkThreeStrike(computer: MutableList<Int>, input: String): Boolean {
        // todo 3스트라이크 확인
    }



    private fun inputNumberException(input: String) {
        // todo 예외 처리
    }
}
