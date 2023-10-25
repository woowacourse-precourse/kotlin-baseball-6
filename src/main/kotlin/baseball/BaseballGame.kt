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
        println(GameMessage.GAME_START.message)

        while(result == 1){
            print(GameMessage.INPUT_NUMBER.message)
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
                println(Result.NOTHING.state)
                return false
            }
            println("${ball}"+Result.BALL.state)
            return false
        }
        if(ball == 0) {
            println("${strike}"+Result.STRIKE.state)
            if(strike == 3) {
                println(GameMessage.GAME_END.message)
                return true
            }
            return false
        }
        println("${ball}" + Result.BALL.state + " ${strike}" + Result.STRIKE.state)
        return false
    }

    private fun inputResult(): Int {
        println(GameMessage.GAME_RESTART.message)
        return validateResult(Console.readLine())
    }

    private fun validateResult(input: String): Int {
        if(input.length > 1) {
            throw IllegalArgumentException(ErrorMessage.LENGTH_OVER_ONE.eMessage)
        }

        if(input[0] !in '1'..'2') {
            throw IllegalArgumentException(ErrorMessage.WRONG_NUMBER.eMessage)
        }

        return input.toInt()
    }
}