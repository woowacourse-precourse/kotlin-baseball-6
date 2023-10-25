package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    TODO("프로그램 구현")
}

fun gameStart(){

}

// 랜덤 숫자 생성 함수
// 중복을 제외 시키기 위해 targetNum은 Set으로 설정
// 숫자는 3개
// pickNumberInRange() 함수를 이용해 1~9까지 숫자를 생성
// 랜덤 생성된 숫자는 Int, 입력숫자는 string
// 비교를 위해서 랜덤 숫자를 string으로 바꿈
fun getTargetNumber(targetNum: MutableSet<String>){
    while (targetNum.size < 3) {
        val number = pickNumberInRange(1, 9)
        if (number.toString() !in targetNum) {
            targetNum.add(number.toString())
        }
    }
}

// 플레이어 숫자 입력 함수
// 1~9까지 서로다른 정수를 입력
// 조건을 만족하면 입력받은 수를 반환
// 만족하지 못하면 illegalArgumentException 발생 후 어플 종료
fun getInputNumber(): String{
    while (true) {
        val inputNum = Console.readLine()
        if (inputNum.all { it in '1'..'9' } && inputNum.toSet().size == 3 && !inputNum.contains('0') && inputNum.length == 3) {
            return inputNum
        } else {
            throw IllegalArgumentException("1~9까지의 서로다른 숫자를 입력하세요")
        }
    }
}

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

fun getReGameChoice(){

}



