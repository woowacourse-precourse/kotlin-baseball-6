package baseball

import baseball.config.Config
import baseball.model.Answer

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

// TODO : 폴더 및 파일 구조 분류하는 방법 학습하고 적용 - MVC 패턴 적용중
fun main() {
    var isStay = true
    val answer = Answer()
    println("숫자 야구 게임을 시작합니다.")

    do {
        if (inputBaseball(answer.number) == false) {
            continue
        }

        val selectedMenu = inputRestart(answer)
        isStay = true.takeIf { selectedMenu == 1 } ?: false

    } while (isStay == true)
}

/** [2]. 숫자 입력 받기 : 1 ~ 9 3자리
 * [3]. Ball, Strike 검증 함수 호출 (Controller)
 * */
fun inputBaseball(answer: IntArray): Boolean {
    val inputData = inputValidator(
        digit = Config.BASEBALL_DIGITS,
        range = Config.BASEBALL_RANGE,
        answer = null
    )

    val calculateResult = calculateBallAndStrike(inputData, answer)
    val (ball, strike) = calculateResult.first
        .split(", ")
        .map { it.toInt() }
    val isAllStrike = calculateResult.second

    calculateResultPrint(ball, strike)
    return isAllStrike
}

/** [4]. 메뉴 입력 받기 : 1 or 2 (Controller) */
fun inputRestart(answer: Answer): Int {
    val selectedMenu = inputValidator(
        digit = Config.MENU_DIGITS,
        range = Config.MENU_RANGE,
        answer = answer,
    ).first()

    return selectedMenu
}