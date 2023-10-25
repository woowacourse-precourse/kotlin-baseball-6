package baseball

fun checkBallsAndStrikes(answer: Array<Char>, input: Array<Char>): Pair<Int, Int> {
    var strikeNum = 0
    var ballNum = 0
    for (i in 0..2) {
        for (j in 0..2) {
            if (answer[i] == input[j] && i == j) {
                strikeNum += 1
            } else if (answer[i] == input[j] && i != j) {
                ballNum += 1
            }
        }
    }
    return Pair(strikeNum, ballNum)
}