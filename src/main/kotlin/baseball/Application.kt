package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var start = true // 게임 시작
    while (start) {
        // 숫자 무작위로 1부터 9까지 선택
        val nums = mutableListOf<Int>()
        while (nums.size < 3) {
            val randomNum = Randoms.pickNumberInRange(0, 9) + 1
            if (!nums.contains(randomNum)) { // 숫자가 선택되면
                nums.add(randomNum) // 숫자를 리스트에 저장
            }
        }
        // 사용자 입력 부분
        var match = false
        while (!match) {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()
            if (userInput.length == 3 && userInput.toIntOrNull() != null) {
                match = checkNums(nums, userInput.map { it.toString().toInt() })
            } else {
                println("올바른 숫자 3개를 입력하세요.")
            }
        }
        // 프로그램 종료 부분
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}
// 스트라이크와 볼 판정 함수
fun checkNums(comNums: List<Int>, userNums: List<Int>): Boolean {
    var sVal = 0; // 스트라이크 개수 초기화
    var bVal = 0; // 볼 개수 초기화
    // 사용자 숫자와 컴퓨터가 제시한 숫자를 인덱스 별로 비교
    for (i in 0..2) {
        // 숫자와 인덱스 모두 같은 경우
        if (userNums[i] == comNums[i]) {
            sVal++ // 스트라이크 개수 + 1
        }
        // 숫자는 같지만 인덱스 다른 경우
        else if (comNums.contains(userNums[i])) {
            bVal++ // 볼 개수 + 1
        }
    }
    return true;
}

