package baseball.console

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object GameConsole {
    // 유저의 응답입니다.
    var answer: String = ""

    // 컴퓨터의 랜덤 값입니다.
    var computerNumber: String = ""

    // 유저 응답을 받습니다.
    fun initUserAnswer() {
        answer = Console.readLine().toString()
    }

    // 컴퓨터 랜덤 값을 초기화합니다.
    fun initComputerNumber() {
        computerNumber = chooseComputerNumber()
    }

    // 랜덤 넘버를 선정합니다.
    private fun chooseComputerNumber(): String {
        val computerNumberList = mutableListOf<Int>()
        while (computerNumberList.size < 3) {
            val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
            addComputerNumber(randomNumber, computerNumberList)
        }
        return computerNumberList.joinToString("")
    }

    // 새로 뽑은 랜덤 숫자의 중복 여부를 확인합니다.
    private fun addComputerNumber(
        randomNumber: Int,
        computerNumberList: MutableList<Int>
    ) {
        if (!computerNumberList.contains(randomNumber))
            computerNumberList.add(randomNumber)
    }
}