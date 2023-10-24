package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 재시작에 사용될 변수 (초기값=1)
    var restart = 1

    // 게임 시작 메시지
    println("숫자 야구 게임을 시작합니다.")

    while (restart == 1) {
        // 숫자 야구 게임
        baseballGame()

        // 재시작 여부 입력 받기
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var input = Console.readLine()

        // input이 정수가 아니면 오류 발생
        if (input.toIntOrNull() == null)
            throw IllegalArgumentException()
        else
            restart = input.toInt()

        // input을 정수로 변환 한 restart가 1,2가 아니면 오류 발생
        if (restart >= 3 || restart <= 0)
            throw IllegalArgumentException()
    }
    println("게임 종료")
}

fun baseballGame() {

    // 정답 숫자 생성 (사용 예시 참고)
    val answerNumbers = mutableListOf<Int>()
    while (answerNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answerNumbers.contains(randomNumber)) {
            answerNumbers.add(randomNumber)
        }
    }

    // 반복문 탈출 여부를 위한 변수
    var checkStrikeout = false

    // True(3 Strike)가 될 때 까지 무한 반복
    while(checkStrikeout == false) {
        // 볼 판정 검사
        checkStrikeout = checkBallCount(answerNumbers)
    }
}


fun checkBallCount(answerNumbers: List<Int>): Boolean {
    // 스트라이크, 볼에 사용될 함수
    var strike = 0
    var ball = 0

    // 숫자 입력 받기
    print("숫자를 입력해주세요 : ")
    var input = Console.readLine()
    var inputInt: Int

    // input이 정수가 아니거나 3자리가 아니라면 오류 발생
    if (input.toIntOrNull() == null || input.length != 3)
        throw IllegalArgumentException()
    else
        inputInt = input.toInt()

    // 입력받은 숫자를 저장할 List
    var inputNumbers = mutableListOf<Int>()

    // 일의 자리를 List에 저장
    for(i: Int in 0 until 3) {
        // 만약 입력받은 숫자 중 같은 숫자가 있거나 0이 들어가면 오류 발생
        if (inputNumbers.contains(inputInt % 10) || (inputInt%10) == 0)
            throw IllegalArgumentException()
        else {
            inputNumbers.add(inputInt % 10)
            inputInt /= 10
        }
    }
    // 숫자가 반대로 받아지므로 reverse수행
    inputNumbers.reverse()

    // 정답 숫자(answerNumbers)와 입력받은 숫자(inputNumbers) 비교하기
    for(i: Int in 0 until 3)
        for(j: Int in 0 until 3)
            if (inputNumbers[i] == answerNumbers[j]) {
                // 숫자가 있고 위치가 같다면 Strike
                if (i==j)
                    strike += 1
                // 숫자는 있지만 위치가 다르다면 Ball
                else
                    ball += 1
            }

    // 스트라이크-볼 판정 (출력 후 boolean 반환)
    if (strike == 3) {
        println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true // 반복문 탈출
    }
    else if (strike == 0 && ball == 0) {
        println("낫싱")
        return false
    }
    else if (strike == 0 && ball != 0) {
        println("${ball}볼")
        return false
    }
    else if (strike != 0 && ball == 0) {
        println("${strike}스트라이크")
        return false
    }
    else {
        println("${ball}볼 ${strike}스트라이크")
        return false
    }

}