package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val computerNumberList = mutableListOf<Int>()
    private val userNumberList = mutableListOf<Int>()

    fun execute() {
        println("숫자 야구 게임을 시작합니다.")

        loop@do {
            initComputer()

            initUser()
            while (true) {
                print("숫자를 입력해주세요 : ")

                var strike = 0
                var ball = 0

                initUser()

                computer.forEachIndexed { i, value ->
                    repeat(3) { j ->
                        if (i == j) {
                            if (value == user[i]) strike++
                        } else {
                            if (value == user[j]) ball++
                        }
                    }
                }

                if (strike == 3) {
                    println("${strike}스트라이크")
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    break
                } else if (strike != 0 && ball != 0) println("${ball}볼 ${strike}스트라이크")
                else if (ball != 0) println("${ball}볼")
                else if (strike != 0) println("${strike}스트라이크")
                else println("낫싱")
            }
        } while(restartOrNot())
    }

    private fun initComputer() {
        val computer = Computer()
        if (computerNumberList.isNotEmpty()) computerNumberList.clear()
        computerNumberList.addAll(computer.getNumberList())
    }

    private fun initUser() {
        val user = User()
        if (userNumberList.isNotEmpty()) userNumberList.clear()
        userNumberList.addAll(user.getNumberList())
    }

    private fun restartOrNot(): Boolean {
        val input = Console.readLine()
        isValidateFinishNumber(input)
        return true
    }
}