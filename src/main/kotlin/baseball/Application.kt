package baseball

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

const val BASEBALL_DIGITS = 4
const val MENU_DIGITS = 1

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var isAnswer = false
    var isStay = true
    var answer = answerSelect()
    var inputData: IntArray

    do {
        println("정답 : ${answer.contentToString()}")

        inputData = inputVaildator(
            digit = BASEBALL_DIGITS,
            range = CharRange('1', '9')
        )
        if (inputData.size == BASEBALL_DIGITS) {
            isAnswer = calculateBallAndStrike(inputData, answer)
            if (isAnswer == false) continue
        }

        inputData = inputVaildator(
            digit = MENU_DIGITS,
            range = CharRange('1', '2')
        )
        if (inputData[0] == 1) {
            isAnswer = false
            isStay = true
            answer = answerSelect()
        } else if (inputData[0] == 2) {
            println("게임 종료")
            isStay = false
        }
    } while (isStay)
}

/** [3]. 1) 매개변수 2개를 이용하여 "S, B" 형태로 변환 */
fun calculateBallAndStrike(inputData: IntArray, answer: IntArray): Boolean {
    var calculateResult = "" + inputData.filterIndexed { index, i ->
        i == answer[index] // Strike
    }.size

    calculateResult += ", " + inputData.filterIndexed { index, i ->
        i in answer.filter { it != answer[index] } // Ball
    }.size

    // println(calculateResult)
    calculateResultPrint(calculateResult)
    if(calculateResult == "${BASEBALL_DIGITS}, 0")
        return true
    return false
}

/** [3]. 2) "S, B" 형태의 값에 따라 문구 출력, 정답을 맞췄는지 반환 */
fun calculateResultPrint(calculateResult: String) {
    val (strike, ball) = calculateResult.split(", ")

    if (strike == "${BASEBALL_DIGITS}") {
        println("${BASEBALL_DIGITS}스트라이크")
        println("${BASEBALL_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    } else if (strike == "0" && ball == "0") {
        println("낫싱")
    }
    if (strike == "0") {
        println("${ball}볼")
    } else if (ball == "0") {
        println("${strike}스트라이크")
    } else if (strike != "0" && ball != "0") {
        println("${ball}볼 ${strike}스트라이크")
    }
}