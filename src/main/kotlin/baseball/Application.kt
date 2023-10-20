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

const val BASEBALL_DIGITS = 3
const val MENU_DIGITS = 1

fun main() {
    val answer = answerSelect()
    println("숫자 야구 게임을 시작합니다.")

    inputNumber(
        digit = BASEBALL_DIGITS,
        range = CharRange('1', '9')
    )
}

/** [1]. 1..9에서 서로 다른 N개의 수 뽑기 */
fun answerSelect(): IntArray {
    val computer = mutableListOf<Int>()

    while (computer.size < BASEBALL_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.toIntArray()
}

/** [2]. 사용자 입력 */
fun inputNumber(digit: Int, range: CharRange) {
    var inputData: String = ""

    if (digit == BASEBALL_DIGITS) {
        print("숫자를 입력해주세요 : ")
    } else if (digit == MENU_DIGITS) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
    inputData = Console.readLine()
    checkDigitRange(inputData, digit, range)
    checkDuplicate(inputData, digit)
}
/** [2]. (2, 4) 입력된 문자열의 길이 및 범위 체크 */
fun checkDigitRange(
    inputData: String,
    digit: Int,
    range: CharRange
) {
    // 입력된 데이터 모두가 range에 속하는지 체크
    val rangeCheck = inputData.map { it }
        .all { it in range }

    if (inputData.length != digit || rangeCheck == false) {
        throw IllegalArgumentException() // 오류 발생시키는 법 : throw Exception()
    }
}

/** [2]. (2) 3) 숫자 중복 체크 */
fun checkDuplicate(inputData: String, digit: Int) {
    if(digit == MENU_DIGITS) return
    // 숫자 중복이 있는지 : String -> Array -> Set으로 변환하여 size 조사
    val inputDataSet = inputData.map { it.toString()
        .toInt()
    }.toIntArray()
        .toSet()

    if (inputDataSet.size < BASEBALL_DIGITS) {
        throw IllegalArgumentException()
    }
}