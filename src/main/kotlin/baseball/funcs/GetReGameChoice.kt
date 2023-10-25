package baseball.funcs

import camp.nextstep.edu.missionutils.Console

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