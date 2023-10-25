package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var playBall = true // 게임 시작

    while (playBall) {
        val computerInput = readComputerInput()

        var isGameDone = false // 게임 종료 변수
        while (!isGameDone) { // 게임이 진행중이면\
            // 사용자 입력
            val userInput = readUserInput()
            // 컴퓨터의 숫자 3개와 사용자의 숫자 3개 비교
            isGameDone = checkNums(computerInput, userInput)
        }
        playBall = gameReplay() // 게임 종료 후 재시작 여부 확인
    }
}

// 컴퓨터 입력 부분(1부터 9중 중복되지 않는 숫자 3개 생성)
fun readComputerInput(): List<Int> {
    val compuInput = mutableListOf<Int>()
    while (compuInput.size < 3) {
        // 숫자 무작위로 1부터 9까지 선택
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (!compuInput.contains(randomNum)) { // 숫자가 nums 리스트에 없다면
            compuInput.add(randomNum) // 해당 숫자를 nums 리스트에 추가 -> 중복 X
        }
    }
    return compuInput
}

// 사용자 입력 부분
fun readUserInput(): List<Int> {
    while (true) {
        print("숫자를 입력해주세요 : ")
        val userInput = Console.readLine() ?: "" // 입력이 Null이 아님
        if (isValidNumber(userInput)) { // 사용자 입력이 유효한 입력이면
            return userInput.map { it.toString().toInt() } // 정수 리스트 반환
        } else { // 그렇지 않은 입력이라면 아래 문구 출력
            throw IllegalArgumentException("올바른 3자리 숫자를 입력해야 합니다.")
        }
    }
}

// 사용자가 입력한 숫자 검토 부분
fun isValidNumber(input: String): Boolean {
    return input.length == 3 && // 입력한 문자열이 정수 변환이 되는지와 숫자로만 이루어져 있는지 확인(숫자 or 문자)
            input.toIntOrNull() != null &&
            input.all { it in '1'..'9' } && // 1부터 9까지 입력을 했는지 확이(숫자 0은 X)
            input.toSet().size == 3
}

// 게임 종료 후 다시 게임 시작 여부 확인 함수 (1: 시작, 2: 종료)
fun gameReplay(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    when (Console.readLine()) {
        "1" -> return true // 1 입력하면 게임 새로 시작
        "2" -> return false // 2 입력하면 게임 종료
        else -> {
            println("1 또는 2를 입력해주세요.")
            return false
        }
    }
}

// 스트라이크와 볼 판정 함수
fun checkNums(comNums: List<Int>, userNums: List<Int>): Boolean {
    var strike = 0; // 스트라이크 개수 초기화
    var ball = 0; // 볼 개수 초기화
    // 사용자 숫자와 컴퓨터가 제시한 숫자를 인덱스 별로 비교
    for (i in 0..2) {
        if (userNums[i] == comNums[i]) { // 숫자와 인덱스 모두 같은 경우
            strike++ // 스트라이크 개수 + 1
        } else if (comNums.contains(userNums[i])) { // 숫자는 같지만 인덱스 다른 경우
            ball++ // 볼 개수 + 1
        }
    }
    return gameRes(strike, ball)
}

// 게임 결과 출력 함수
fun gameRes(strike: Int, ball: Int): Boolean {
    // 볼과 스트라이크 되는 경우
    when {
        // 같은 숫자가 존재하고 같은 인덱스에 있는 경우
        strike > 0 && ball > 0 -> println("${ball}볼 ${strike}스트라이크")
        strike > 0 -> { // 같은 숫자가 같은 인덱스에 있는 경우
            println("${strike}스트라이크")
            if (strike == 3) { // 스트라이크 3개면 게임 종료
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                return true
            }
        }

        ball > 0 -> println("${ball}볼") // 인덱스는 다르지만 같은 숫자만 있는 경우
        else -> println("낫싱") // 모두 다른 숫자인 경우
    }
    return false
}
/* 예시
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
*/