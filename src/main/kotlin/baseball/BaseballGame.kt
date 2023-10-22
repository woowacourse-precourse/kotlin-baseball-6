package baseball

import baseball.resources.Messages
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// 입력 및 순환 함수
fun baseBallGame() {
    // 정오답 여부
    var isAnswer = false
    // 정답 랜덤 숫자
    val answer = mutableListOf<Int>()

    // 랜덤 숫자 생성
    while (answer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber)
        }
    }

    // 숫자 입력 및 메시지 출력 순환
    while (!isAnswer) {
        print(Messages.inputMessage)
        // 입력 및 규칙 검사
        val inputList = checkNumber(Console.readLine())
    }
}

// 입력 숫자 예외 규칙 검사 함수
fun checkNumber(input: String): List<Int> {
    // 3이 아닌 길이의 문자열이 입력된 경우
    if (input.length != 3) {
        throw IllegalArgumentException(Messages.inputLengthError)
    }
    // 1~9 이외의 문자가 입력된 경우
    input.forEach { inputChar ->
        if (inputChar.toString().toInt() < 1 || inputChar.toString().toInt() > 9) {
            throw IllegalArgumentException(Messages.inputRangeError)
        }
    }
    // 같은 숫자가 입력된 경우
    input.forEach { inputChar ->
        if (input.filter { it == inputChar }.length > 1) {
            throw IllegalArgumentException(Messages.inputOverlapError)
        }
    }
    return input.map { it.toString().toInt() }
}