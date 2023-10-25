package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    gameStart()
}

// 게임시작 함수
// 게임이 실행되는 함수로 게임시작, 입력, 게임종료 스크립트를 출력
// targetNum 변수를 생성
// getTargeNumber()로 랜덤생성 숫자를 targetNum에 추가
// getInputNumber()로 플레이어로부터 숫자를 입력받아 inputNum에 저장
// countBall()에서 inputNum과 targetNum을 비교해 게임의 결과를 출력
// 3스트라이크시 결과를 출력하며 getReGameChoice()를 통해 게임 재개여부를 물음
// 입력결과에 따라 isPlaying값이 업데이트 되어 게임종료나 재시작이 결정
fun gameStart(){
    val targetNum: MutableSet<String> = mutableSetOf()
    var isPlaying = true
    println("숫자 야구 게임을 시작합니다.")

    while (isPlaying) {
        getTargetNumber(targetNum)
        while (true) {
            print("숫자를 입력해주세요 : ")
            val inputNum = getInputNumber()
            val result = countBall(inputNum, targetNum)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        isPlaying = getReGameChoice()
    }
}

// 랜덤 숫자 생성 함수
// 중복을 제외 시키기 위해 targetNum은 Set으로 설정
// 숫자는 3개
// pickNumberInRange() 함수를 이용해 1~9까지 숫자를 생성
// 랜덤 생성된 숫자는 Int, 입력숫자는 string
// 비교를 위해서 랜덤 숫자를 string으로 바꿈

// 게임 재시작시 targetNum가 초기화가 안되어 targetNum.size == 3이기 때문에 코드가 돌아가지 않는 버그
fun getTargetNumber(targetNum: MutableSet<String>){
    targetNum.clear()
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
        if (inputNum.length == 3 && inputNum.toSet().size == 3 && inputNum.all { it in '1'..'9' }) {
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

// 게임 재개선택 함수
// 게임이 종료되었을때 사용자로부터 입력을 받음
// 1은 게임 새로시작, 2는 게임 종료
// 1, 2를 제외한 모든 입력을 받을시 illegalArgumentException 발생 후 어플 종료
// gameStart()에 isPlaying 값을 반환해 게임 재시작과 종료를 결정

fun getReGameChoice(): Boolean{
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException("1 또는 2만 입력가능합니다.")
    }
}



