package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var answer = mutableListOf<Int>()

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

    fun judgeNumberBall(str: String): String {
        var strike = 0; var ball = 0
        val numberBall = mapToIntNumberList(str)

        for (i in 0..2) {
            when(numberBall[i]){
                answer[i] -> strike += 1
                in answer -> ball += 1
            }
        }

        if(strike == 0 && ball == 0){
            return "낫싱"
        }
        else if(ball == 0){
            return "${strike}스크라이크"
        }
        else{
            return "${ball}볼 ${strike}스크라이크"
        }

    }

    private fun mapToIntNumberList(numberBall: String): MutableList<Int> {
        var numberList = mutableListOf<Int>()
        numberBall.forEach {
            numberList.add(it.code - 48)
        }
        return numberList
    }

}