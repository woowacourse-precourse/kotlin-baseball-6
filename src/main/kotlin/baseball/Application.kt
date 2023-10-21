package baseball

import baseball.System.Companion.isFinished

fun main() {
    val system = System()
    val computer = Computer()

    while (!isFinished) {
        val userInput = system.getUserInput()
        system.checkUserInputValid(userInput)

        val userInputList: List<String> = userInput.chunked(1)

        //난수와 사용자 입력 비교 분리
        val result = computer.getGameResult(userInputList) //result = Pair(strike, ball))

        system.printGameResult(result.first, result.second)

        if (result.first == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

            if (system.endGame()) isFinished = true
            else computer.makeRandomNumList()

        }
    }
}





