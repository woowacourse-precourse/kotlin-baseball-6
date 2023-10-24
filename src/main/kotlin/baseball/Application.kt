package baseball

import camp.nextstep.edu.missionutils.*


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

    checkGuess(input)

    for (c in input) {
        result.add(Character.getNumericValue(c))
    }

    return result
}

fun checkGuess(m: String): String {
    TODO("Not yet implemented")
}
