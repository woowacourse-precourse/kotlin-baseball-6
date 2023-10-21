package baseball

//리팩토링-> 작은 덩어리로 쪼개기
fun main() {
    val system = System()
    val computer = Computer()
    var finish = false
    println("숫자 야구 게임을 시작합니다.")
    //난수 생성

    var randomNumList = computer.makeRandomNumList()
    while (!finish) {

        val userInput = system.getUserInput()

        //regex와 일치하면서 set을 이용해 중복된 수가 있는지 확인
        system.checkUserInputValid(userInput)

        val userInputList: List<String> = userInput.chunked(1)

        //난수와 사용자 입력 비교 분리
        val result = computer.getGameResult(userInputList, randomNumList) //result = Triple(strike, ball, nothing))

        val strike = result.first
        val ball = result.second
        val nothing = result.third

        system.printGameResult(strike, ball, nothing)

        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

            if (system.endGame()) finish = true
            else randomNumList = computer.makeRandomNumList()

        }
    }
}





