package baseball

/** [3]. 1) 매개변수 2개를 이용하여 "S, B" 형태로 변환 */
fun calculateBallAndStrike(inputData: IntArray, answer: IntArray): Boolean {
    var calculateResult = "" + inputData.filterIndexed { index, i ->
        i in answer.filter { it != answer[index] } // Ball
    }.size

    calculateResult += ", " + inputData.filterIndexed { index, i ->
        i == answer[index] // Strike
    }.size

    // println(calculateResult) // TODO For Debuging
    calculateResultPrint(calculateResult)
    val isAllStrike = "0, ${BASEBALL_DIGITS}" == calculateResult
    return isAllStrike
}

/** [3]. 2) "S, B" 형태의 값에 따라 문구 출력, 정답을 맞췄는지 반환 */
fun calculateResultPrint(calculateResult: String) {
    val (ball, strike) = calculateResult.split(", ")

    if (strike == "${BASEBALL_DIGITS}") {
        println("${BASEBALL_DIGITS}스트라이크")
        println("${BASEBALL_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    } else if (strike == "0" && ball == "0") {
        println("낫싱")
    } else if (strike != "0" || ball != "0") {
        var calculateResult = "${ball}볼".takeIf { ball != "0" } ?: ""
        calculateResult += " ${strike}스트라이크".takeIf { strike != "0" } ?: ""
        println(calculateResult.trim()) // 스트라이크만 출력 시 앞에 공백 제거
    }
}