package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    // 시작 안내 문구 출력
    println("숫자 야구 게임을 시작합니다.")

    // 1부터 9까지의 서로 다른 랜덤 숫자 3개 뽑기
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    while (true) {
        // 사용자 숫자 입력받기
        print("숫자를 입력해주세요 : ")
        val userInput = readLine()?.map { it.toString().toIntOrNull() }

        if (userInput == null ||
            userInput.size != 3 ||
            userInput.toSet().size != 3 ||
            userInput.none { it in 1..9 }
        ) {
            throw IllegalArgumentException()
        }

        // 입력받은 숫자와 컴퓨터의 숫자를 비교하여 힌트 혹은 정답 여부 출력
        var strikeCount = 0
        var ballCount = 0

        for (i in 0 until 3) {
            if (userInput[i] == computer[i]) {
                strikeCount++
            } else if (userInput[i] in computer) {
                ballCount++
            }
        }

        val hint = when {
            strikeCount == 3 -> "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
            strikeCount > 0 && ballCount > 0 -> "${ballCount}볼 ${strikeCount}스트라이크"
            strikeCount > 0 -> "${strikeCount}스트라이크"
            ballCount > 0 -> "${ballCount}볼"
            else -> "낫싱"
        }
        println(hint)
        if (strikeCount == 3) break
    }
}
