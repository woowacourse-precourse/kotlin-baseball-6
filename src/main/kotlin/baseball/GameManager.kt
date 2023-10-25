package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballReady {
    private var inputNumber = ""
    private var randomNumber = initRandomNumber()
    private var strike = 0
    private var ball = 0
    fun rangeCheck() : Boolean {
        var check = false

        try {
            if(inputNumber.length != 3) {
                throw IllegalArgumentException("입력 숫자는 3개여야 합니다.")
            }
            for(i in 0..2) {
                if (inputNumber[i] == '0') {
                    throw IllegalArgumentException("입력 숫자는 0이 포함되면 안됩니다.")
                }
            }
            if(inputNumber[0] == inputNumber[1] || inputNumber[0] == inputNumber[2] || inputNumber[1] == inputNumber[2]) {
                throw IllegalArgumentException("중복되는 숫자는 입력되면 안됩니다.")
            }

        } catch (e: IllegalArgumentException) {
            check = true
        }
        return check
    }
    private fun initRandomNumber() :String{
        val randomNumberGenerator = RandomNumberInit()
        val random = randomNumberGenerator.getRandomNumber()
        return random
    }
    fun setInputNumber() {
        inputNumber = Console.readLine().toString()
    }
    fun initBallStrike(){
        strike = 0
        ball = 0
    }
    fun checkStrike() {
        for( i in 0..2) {
            if (inputNumber[i] == randomNumber[i]) {
                strike += 1
            }
        }
    }
    fun checkBall() {
        for(i in 0..2) {
            for(j in 0..2){
                if(i == j) continue
                if(inputNumber[i] == randomNumber[j]) {
                    ball += 1
                }
            }
        }
    }

    fun checkNothing() :Boolean {
        var checkNothing = false

        if(strike == 0 && ball == 0) {
            println("낫싱")
            checkNothing = true
        }
        return checkNothing
    }
    fun printStrikeBall() {
        if (strike == 0 && ball == 0) return
        else if(strike == 0)
        {
            println("${ball}볼")
        }
        else if(ball == 0) {
            println("${strike}스트라이크 ")
        }
        else{
            println(" ${ball}볼 ${strike}스트라이크")
        }
    }

    fun checkAnswer(): Boolean {
        return strike == 3
    }
}
