package baseball

fun answerCheck(answer: IntArray, userInput: IntArray): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for(i in 0 until COUNT) {
        if (answer[i] == userInput[i]) strike++
        else if (answer.contains(userInput[i])) ball++
    }
    return Pair(strike, ball)
}
