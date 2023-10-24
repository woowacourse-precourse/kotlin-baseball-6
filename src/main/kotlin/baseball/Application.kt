package baseball

import camp.nextstep.edu.missionutils.Randoms //Random 값 추출 - pickNumberInRange()
import camp.nextstep.edu.missionutils.Console //사용자 입력 값 - readLine()

fun main() {

    // 게임 시작
    println("숫자 야구 게임을 시작합니다.")
    startBaseballPlay()

}

fun startBaseballPlay() {

    // 컴퓨터 랜덤 값 생성
    val computerRandomNum = createComputerRandomNum()


}

fun createComputerRandomNum(): String {

    val computerNum = mutableListOf<Int>()
    // list 크기 3 미만, 즉 3글자가 아닐경우 1~9 사이 랜덤값 생성
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        // 서로 다른 수만 생성
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    // list 공백 제거하고 문자열로
    return computerNum.joinToString("")
}
