package baseball.model

class Referee {

    fun judge(userNumber: UserNumber, answer: List<Int>): Result {
        var strike = 0
        var ball = 0

        for (i in answer.indices) {
            if (userNumber.number[i] == answer[i]) strike++
            if (answer.contains(userNumber.number[i])) ball++
        }

        return Result(strike, ball - strike)
    }
}
