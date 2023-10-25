package baseball.funcs

// 스트라이크, 볼 카운트 함수
// inputNum과 targetNum을 비교
// 비교를 위해 inputNum을 한 문자로 바꿔 리스트화
// targetNum과 합쳐 각각의 같은 인덱스값을 비교
// 인덱스의 값이 같으면 strikes
// targetNum과 inputNum에 요소들이 같은부분에서 strikes를 빼면 balls
// strikes이 0보다크면 strikes의 수 출력
// balls가 0보다크면 balls의 수 출력
// 둘다 존재하면 balls와 strikes 둘다 출력
// 둘다 존재하지 않으면 '낫싱' 출력
fun countBall(inputNum: String, targetNum: MutableSet<String>): String {
    val inputNumList = inputNum.toList().map { it.toString() }
    val strikes = inputNumList.zip(targetNum).count { (inputIdx, targetIdx) -> inputIdx == targetIdx }
    val balls = inputNumList.count { it in targetNum } - strikes

    return when {
        strikes > 0 && balls > 0 -> "${balls}볼 ${strikes}스트라이크"
        strikes > 0 -> "${strikes}스트라이크"
        balls > 0 -> "${balls}볼"
        else -> "낫싱"
    }
}