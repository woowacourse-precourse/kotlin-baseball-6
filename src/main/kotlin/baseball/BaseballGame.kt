package baseball

import java.lang.IllegalArgumentException
import camp.nextstep.edu.missionutils.Console

class BaseballGame {

    private var result: Int
    private var computer: Computer
    private var you: Person

    init {
        result = 1
        computer = Computer()
        you = Person()
    }

    fun start() {
        println("숫자 야구 게임을 시작합니다.")

        while(result == 1){
            print("숫자를 입력해주세요 : ")
            you.getInput()

            if(printResult(check(computer, you))) {
                result = inputResult()
                if(result == 2) break

                computer.reset()
            }
        }
    }

    fun check(computer: Computer, you: Person): Pair<Int, Int> {
        var strike = 0
        var ball = 0
        for ((index, value) in you.person.withIndex()) {
            for ((index2, value2) in computer.computer.withIndex()) {
                if(value == value2) {
                    if(index==index2) {
                        strike++
                        continue
                    }
                    ball++
                }
            }
        }
        return Pair(strike, ball)
    }

    fun printResult(check: Pair<Int, Int>) : Boolean {
        val (strike, ball) = check
        if(strike == 0) {
            if(ball == 0) {
                println("낫싱")
                return false
            }
            println("${ball}볼")
            return false
        }
        if(ball == 0) {
            println("${strike}스트라이크")
            if(strike == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                return true
            }
            return false
        }
        println("${ball}볼 ${strike}스트라이크")
        return false
    }

    private fun inputResult(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return validateResult(Console.readLine())
    }

    private fun validateResult(input: String): Int {
        if(input.length > 1) {
            throw IllegalArgumentException("1 또는 2만 입력해주세요")
        }

        if(input[0] !in '1'..'2') {
            throw IllegalArgumentException("1,2 이외의 숫자를 입력하셨습니다.")
        }

        return input.toInt()
    }
}