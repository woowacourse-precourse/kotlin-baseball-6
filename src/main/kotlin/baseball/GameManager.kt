package baseball

class BaseballReady {
    private var inputNumber = ""
    private var randomNumber = InitRandomNumber()
    private var strike = 0
    private var ball = 0
    fun RangeCheck() : Boolean {
        val check = false
        for(i in 0.. 2) {}
        return check
    }
    fun InitRandomNumber() :String{
        val randomNumberGenerator = RandomNumberInit()
        val random = randomNumberGenerator.GetRandomNumber()
        return random
    }
    fun setInputNumber() {
        inputNumber = readLine().toString()
    }
    fun InitBallStrike(){
        strike = 0
        ball = 0
    }
    fun CheckStrike() {
        for( i in 0..2) {
            if (inputNumber[i] == randomNumber[i]) {
                strike += 1
            }
        }
    }
    fun CheckBall() {
        for(i in 0..2) {
            for(j in 0..2){
                if(i == j) continue
                if(inputNumber[i] == randomNumber[j]) {
                    ball += 1
                }
            }
        }
    }

    fun CheckNothing() :Boolean {
        var checkNothing = false

        if(strike == 0 && ball == 0) {
            println("낫싱")
            checkNothing = true
        }
        return checkNothing
    }
    fun PrintStrikeBall() {
        if (strike == 0 && ball == 0) return
        else if(strike == 0)
        {
            println("${ball}볼")
        }
        else if(ball == 0) {
            println("${strike}스트라이크 ")
        }
        else{
            println("${strike}스트라이크 ${ball}볼")
        }

    }

    fun CheckAnswer(): Boolean {
        return strike == 3
    }
}
