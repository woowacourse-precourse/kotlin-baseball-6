package baseball.funcs

import camp.nextstep.edu.missionutils.Console

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