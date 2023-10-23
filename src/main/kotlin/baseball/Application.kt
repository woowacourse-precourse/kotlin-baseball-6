package baseball

import baseball.model.Answer
import baseball.model.UserInput

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
val BASEBALL_RANGE = CharRange('1', '9')

const val MENU_DIGITS = 1
val MENU_RANGE = CharRange('1', '9')

class BaseballGame(private val answer: Answer, private val userInput: UserInput) {
    fun play() {
        var isStay = true
        gameStartPrompt()

        while (isStay) {
            if (!inputBaseball(answer.number, userInput)) {
                continue
            }

            val selectedMenu = inputRestart(answer, userInput)
            isStay = (selectedMenu == 1)
        }
    }
}

fun main() {
    val game = BaseballGame(Answer(), UserInput())
    game.play()
}