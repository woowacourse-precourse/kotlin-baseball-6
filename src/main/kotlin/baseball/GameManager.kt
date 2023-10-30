package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val computerNumberList = mutableListOf<Int>()

    fun execute() {
        println("숫자 야구 게임을 시작합니다.")
        val computer = mutableListOf<Int>()
        val user = mutableListOf<Int>()

        loop@do {
            computer.clear()
            initComputer()
            while (true) {
                print("숫자를 입력해주세요 : ")

                var strike = 0
                var ball = 0

                user.clear()
                val input = Console.readLine()

                isValidateInputString(input)

                input.forEach { user.add(it.digitToInt()) }

                for(i in 1..9) {
                    var result = 0
                    user.forEachIndexed { _, value ->
                        if(value == i) result++
                    }
                    if(result > 1) throw IllegalArgumentException("zz")
                }

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

    private fun restartOrNot(): Boolean {
        val input = Console.readLine()
        isValidateFinishNumber(input)
        return true
    }
}