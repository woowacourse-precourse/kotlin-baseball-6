package baseball

import camp.nextstep.edu.missionutils.*
import java.lang.Exception


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startBaseballGame()
    continueOrQuit()
}

fun startBaseballGame() {
    val computer: List<Int> = randomComputer()
    var me: List<Int> = listOf()
    var wrong: Boolean = true

    while (wrong) {
        me = guessComputer()
    }
}

fun continueOrQuit() {
    TODO("Not yet implemented")
}

// 1) '컴퓨터의 숫자' 초기화
fun randomComputer(): List<Int> {
    val rand = mutableListOf<Int>()

    while (rand.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!rand.contains(randomNumber)) {
            rand.add(randomNumber)
        }
    }

    return rand
}

// 2) '나의 숫자' 입력
fun guessComputer(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    val result = mutableListOf<Int>()

    // 잘못된 입력에 대한 예외처리
    checkGuess(input)

    for (c in input) {
        result.add(Character.getNumericValue(c))
    }

    return result
}

// 2) '나의 숫자' 입력 - 잘못된 입력에 대한 예외처리
fun checkGuess(m: String) {
    // 숫자가 아닌 값을 입력한 경우
    if (m.toIntOrNull() == null) {
        throw IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.")
    }

    // 숫자이지만,
        // 3자리가 아닌 경우
    if (m.length != 3) {
        throw IllegalArgumentException("3자리의 수를 입력해주세요.")
    }

        // 서로 다른 수가 아닌 경우
    if (m[0] == m[1] || m[0] == m[2] || m[1] == m[2]) {
        throw IllegalArgumentException("서로 다른 수로 이뤄져야 합니다.")
    }

    for (c in m) {
        // 1부터 9까지의 수로 이뤄지지 않은 경우
        if (Character.getNumericValue(c) in 1..9) {
            throw IllegalArgumentException("1부터 9까지의 수로 이뤄져야 합니다.")
        }
    }
}
