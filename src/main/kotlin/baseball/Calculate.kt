package baseball

/** [3]. 1) 매개변수 2개를 이용하여 "S, B" 형태로 변환 */
fun calculateBallAndStrike(inputData: IntArray, answer: IntArray): Boolean {
    var calculateResult = "" + inputData.filterIndexed { index, i ->
        i in answer.filter { it != answer[index] } // Ball
    }.size

    calculateResult += ", " + inputData.filterIndexed { index, i ->
        i == answer[index] // Strike
    }.size

    // TODO For Debuging
    // println(calculateResult)

    calculateResultPrint(calculateResult)
    if (calculateResult == "0, ${BASEBALL_DIGITS}")
        return true
    return false
}

/** [3]. 2) "S, B" 형태의 값에 따라 문구 출력, 정답을 맞췄는지 반환 */
fun calculateResultPrint(calculateResult: String) {
    val (ball, strike) = calculateResult.split(", ")

    if (strike == "${BASEBALL_DIGITS}") {
        println("${BASEBALL_DIGITS}스트라이크")
        println("${BASEBALL_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    } else if (strike != "0" && ball != "0") {
        println("${ball}볼 ${strike}스트라이크")
    } else if (strike == "0" && ball == "0") {
        println("낫싱")
    } else if (ball == "0") {
        println("${strike}스트라이크")
    } else if (strike == "0") {
        println("${ball}볼")
    }
}