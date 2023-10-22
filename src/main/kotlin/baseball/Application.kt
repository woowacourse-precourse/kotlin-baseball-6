package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    while (true) {

        val computerNumber = generateComputerNumber()

        while (true) {
            val userInput = getUserInput()

            // 입력받은 숫자와 컴퓨터의 숫자를 비교하여 힌트 혹은 정답 여부 출력
            val hint = compareWithUserInput(userInput, computerNumber)
            println(hint)
            if (hint.contains("3스트라이크")) break
        }

        // 게임 종료 후 재시작 여부 확인
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        when (readLine()?.toIntOrNull()) {
            1 -> continue
            2 -> break
            else -> throw IllegalArgumentException()
        }
    }
}

/** 1부터 9까지의 서로 다른 랜덤 숫자 3개 뽑기 */
fun generateComputerNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

/** 사용자 숫자 입력받기 */
fun getUserInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val userInput = readLine()?.map { it.toString().toIntOrNull() }

    if (userInput == null ||
        userInput.size != 3 ||
        userInput.toSet().size != 3 ||
        userInput.any { it !in 1..9 }
    ) {
        throw IllegalArgumentException()
    }

    return userInput.requireNoNulls()
}

/** 컴퓨터의 숫자와 입력받은 숫자를 비교하여 결과 반환 */
fun compareWithUserInput(userInput: List<Int>, computerNumber: List<Int>): String {
    var strikeCount = 0
    var ballCount = 0

    for (i in 0 until 3) {
        if (userInput[i] == computerNumber[i]) {
            strikeCount++
        } else if (userInput[i] in computerNumber) {
            ballCount++
        }
    }

    return when {
        strikeCount == 3 -> "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        strikeCount > 0 && ballCount > 0 -> "${ballCount}볼 ${strikeCount}스트라이크"
        strikeCount > 0 -> "${strikeCount}스트라이크"
        ballCount > 0 -> "${ballCount}볼"
        else -> "낫싱"
    }
}