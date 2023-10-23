package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    //게임 재시작시 반복
    do {
        val answerNumbers: List<Int> = createAnswerNumber()

        // 맞힐때까지 반복
        do {
            val playerNumbers: List<Int> = getPlayerNumber()

        } while (!checkAnswer(answerNumbers, playerNumbers))
    } while (restartGame())
}

fun createAnswerNumber(): List<Int> {
    val numbers = mutableSetOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if(!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers.toList()
}

fun getPlayerNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val receiveValue = Console.readLine()

    if(receiveValue.length != 3) {
        throw IllegalArgumentException("3자리 숫자를 입력해 주세요")
    }
    try {
        receiveValue.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자만 입력해 주세요")
    }
    if(receiveValue.contains("0")) {
        throw IllegalArgumentException("1~9까지의 숫자만 입력해 주세요")
    }
    if(receiveValue.toList().toSet().size != 3) {
        throw IllegalArgumentException("중복된 숫자 입력 불가")
    }
    return receiveValue.toList().map { Character.getNumericValue(it) }
}

fun checkAnswer(answerNumbers: List<Int>, playerNumbers: List<Int>): Boolean {
    var ballCount = 0
    var strikeCount = 0

    for(i in 0..2) {
        if(playerNumbers[i] == answerNumbers[i]) {
            strikeCount++
            continue
        }
        if(answerNumbers.contains(playerNumbers[i])) {
            ballCount++
        }
    }

    if(strikeCount == 3) {
        println("3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    if(ballCount + strikeCount == 0) println("낫싱")
        else println("${ballCount}볼 ${strikeCount}스트라이크")
    return false
}

fun restartGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    return when(Console.readLine()) {
        "1" -> true
        "2" -> false
        else -> {throw IllegalArgumentException("1 또는 2의 숫자만 입력해주세요")}
    }
}