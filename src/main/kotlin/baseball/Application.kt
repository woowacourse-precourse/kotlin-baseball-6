package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/*  명령어 학습(C : Ctrl, A: Alt, S:Shift)
    1. CA + l : 자동 정렬
    2. CA + o : import 정리
    3. S + F6 : 이름 한 번에 수정
    4. C + F12 : 파일 구조 확인
    5. C + E : 최근 작업 파일 목록(CA L or R도 가능)
    6. CS + BackSpace : 최근 수정 위치
    7. S 2번 : 모든 프로젝트 파일에서 찾기
    8. // TODO키워드 : 에러처리 해야할 내용 -> 작업하다가 중간중간에 나중에 수정해야할 부분 체크 가능!!!
    9. Git에 업로드 안된 내용이라도 Local History를 통해서 파일 단위로 코드 복구가 가능하다.
*/

const val NUMBER_OF_DIGITS = 3
fun main() {
    // 1. 게임 시작을 위한 세팅
    val answer = answerSelect()
    println("숫자 야구 게임을 시작합니다.")
    // println("Debug - answer : ${answer.contentToString()}")

    // 2. 사용자 입력
    inputNumber(
        digit = NUMBER_OF_DIGITS,
        range = CharRange(start = '1', endInclusive = '9')
    )
}

// 1. 게임 시작을 위한 세팅
fun answerSelect(): IntArray {
    val computer = mutableListOf<Int>()

    while (computer.size < NUMBER_OF_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer.toIntArray()
}

// 2. 사용자 입력
fun inputNumber(digit: Int, range: CharRange) {
    var inputData: String = ""

    // 사용자 입력
    if (digit == NUMBER_OF_DIGITS) {
        print("숫자를 입력해주세요 : ")
        inputData = Console.readLine()
    } else if (digit == 1) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        inputData = Console.readLine()
    }

    // 오류 발생시키는 법 : throw Exception()
    val digitAndRangeCheck = inputData.map { it }
        .all { it in range }

    // [2, 4] 오류 검증 1. 입력된 문자열의 길이가 digit 자리가 아닌 경우
    // [2, 4] 오류 검증 2. range 범위의 문자가 아닌 경우
    if (inputData == "" || inputData.length != digit) {
        throw IllegalArgumentException()
    } else if (!digitAndRangeCheck) {
        throw IllegalArgumentException()
    }
}