package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame () {
    lateinit var comNumber: List<Int>
    fun gameStart() {
        simulation()
    }
    private fun simulation() {
        var state = State.START
        while (state != State.TERMINATION){
            when(state){
                State.START -> {
                    View().start()
                    comNumber = Computer().generateNumber()
                    state = State.RUNNING
                }
                State.RUNNING -> {
                    View().input()
                    val userNumber = User().inputUserNumber()
                    val score =Score(0, 0, false)
                    compare(userNumber, comNumber, score)
                    View().announceScore(score)
                    if (score.strike == 3) {
                        state = State.END
                    }
                }

                State.END -> {
                    View().end()
                    View().decision()
                    val userInputDecision = Console.readLine()
                    Validation.checkDecision(userInputDecision)
                    when(userInputDecision){
                        "1" -> state = State.START
                        "2" -> state = State.TERMINATION
                    }
                }
                else -> break
            }
        }

    }

    private fun compare(user: List<Int>, computer: List<Int>, score: Score) {
        for (i in 0..2) {
            if (user[i] == computer[i]) {
                score.strike += 1
            } else if (computer.contains(user[i])) {
                score.ball += 1
            } else {
                continue
            }
        }
        if (score.strike + score.ball == 0) {
            score.nothing = true

        }
    }

}