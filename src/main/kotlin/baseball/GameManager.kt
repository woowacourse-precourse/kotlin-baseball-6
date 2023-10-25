package baseball

class GameManager {
    companion object {
        fun start() {
            printStartMessage()
            var keepGoing: Int
            do {
                progressRound()
                keepGoing = User.getRestartInput()
            } while (keepGoing == 1)
        }

        // 최초 실행 시 게임 시작 문구 출력
        private fun printStartMessage() {
            println("숫자 야구 게임을 시작합니다.")
        }

        // 한 라운드를 실행, 사용자가 이길 때 까지 반복
        private fun progressRound() {
            // 컴퓨터가 서로 다른 3자리 난수를 생성
            val computer = Computer.generateRandomNumber()
            // 사용자가 맞출 때 까지(우승할 때 까지) 반복
            var win: Boolean = false
            while (!win) {
                val user = User.getUserNumbers()
                win = Computer.matchTwoNumbers(computer, user)
            }
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        }

    }
}