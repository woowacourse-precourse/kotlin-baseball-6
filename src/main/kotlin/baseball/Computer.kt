package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var answer = mutableListOf<Int>()
    private var isThreeStrike = false

    init {
        answer.add(Randoms.pickNumberInRange(1, 9))
        this.createAnswer()
    }

    private fun createAnswer() {
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
    }
    fun initializeGame() {
        isThreeStrike = false
        answer.clear()
        answer.add(Randoms.pickNumberInRange(1, 9))
        this.createAnswer()
    }

    fun judgeNumberBall(numberBall: MutableList<Int>): String {
        var strike = 0; var ball = 0

        for (i in 0..2) {
            when(numberBall[i]){
                answer[i] -> strike += 1
                in answer -> ball += 1
            }
        }

        if (strike == 3){
            isThreeStrike = true
        }

        if(strike == 0 && ball == 0){
            return "낫싱"
        }
        else if(ball == 0){
            return "${strike}스트라이크"
        }
        else{
            return "${ball}볼 ${strike}스트라이크"
        }
    }

    fun isThreeStrike():Boolean{
        if (isThreeStrike){
            return true
        }
        else{
            return false
        }
    }

}