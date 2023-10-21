package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

//리팩토링-> 작은 덩어리로 쪼개기
fun main() {
    val system = System()
    var finish = false
    println("숫자 야구 게임을 시작합니다.")
    //난수 생성

    var randomNumList = makeRandomNumList()
    while (!finish) {

        val userInput = system.getUserInput()

        //regex와 일치하면서 set을 이용해 중복된 수가 있는지 확인
        system.checkUserInputValid(userInput)

        val userInputList: List<String> = userInput.chunked(1)

        //난수와 사용자 입력 비교 분리
        val result = getGameResult(userInputList, randomNumList) //result = Triple(strike, ball, nothing))

        val strike = result.first
        val ball = result.second
        val nothing = result.third

        system.printGameResult(strike, ball, nothing)

        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

            val restart = Console.readLine()
            system. setRestartFlag(restart).let {
                if (it) randomNumList = makeRandomNumList()
                else finish = true
            }
        }
    }
}


//난수를 생성하는 함수
fun makeRandomNumList(): MutableList<String> {
    var temp = ""
    val randomNumList = mutableListOf<String>()
    while (randomNumList.size < 3) {
        temp = Randoms.pickNumberInRange(1, 9).toString()
        if (!randomNumList.contains(temp)) {
            randomNumList.add(temp)
        }
    }
    return randomNumList
}

//게임 결과를 도출하는 함수
fun getGameResult(userInputList: List<String>, randomNumList: MutableList<String>): Triple<Int, Int, Int> {
    var strike = 0
    var ball = 0
    var nothing = 0
    for (i in userInputList.indices) {
        if (userInputList[i] == randomNumList[i]) strike++
        else if ((userInputList[i] != randomNumList[i]) && randomNumList.contains(userInputList[i])) ball++
    }
    if (ball + strike == 0) nothing = 1
    return Triple(strike, ball, nothing)
}





