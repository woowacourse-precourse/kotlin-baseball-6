package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private lateinit var baseballNumberList: MutableList<Int>

    fun startGame() {
        setBaseBallNumberList()
        playGame()
    }

    private fun setBaseBallNumberList() {
        baseballNumberList = mutableListOf()
        with(baseballNumberList) {
            while (size < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!contains(randomNumber)) add(randomNumber)
            }
        }
    }

    private fun playGame() {
        println("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : ")
        // TODO : userInput과 baseballNumberList 비교 후, break하는 로직 필요
        while (true) {
            val userInput = getUserInput()
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            break;
        }
    }

    private fun getUserInput(): List<Int> =
        Console.readLine()!!.map {
            it.toString().toInt()
        }
}