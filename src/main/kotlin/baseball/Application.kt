// 야구 숫자 데이터 타입 wrapping?

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val REPLAY = 1
const val GAME_OVER = 2
const val VALID_LENGTH = 3
const val DIGIT_CODE_START = '1'.code
const val DIGIT_CODE_END = '9'.code
const val GAME_START = "숫자 야구 게임을 시작합니다."
const val TURN_PROMPT = "숫자를 입력해주세요 : "
const val THREE_STRIKES = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val NOTHING = "낫싱"
const val REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

fun isValidBaseballQuery(query: String): Boolean {
    val queryLetterCode = query.map { it.code }
    val queryLetterValidity = queryLetterCode.map { isValidLetter(it) }
    return (isValidLength(query)) and (queryLetterValidity.all { it }) and (isEveryLetterUnique(queryLetterCode))
}

fun isValidLength(query: String): Boolean {
    return query.length == VALID_LENGTH
}

fun isValidLetter(letter: Int): Boolean {
    return (DIGIT_CODE_START <= letter) and (letter <= DIGIT_CODE_END)
}

fun isEveryLetterUnique(queryLetterCode: List<Int>): Boolean {
    val digitSet = hashSetOf<Int>()
    return queryLetterCode.all { digitSet.add(it) }
}

fun judgeResult(query: String, answer: String): ArrayList<Int> {
    require(isValidBaseballQuery(query)) { "Invalid query." }
    val queryCode = query.map { it.code - DIGIT_CODE_START + 1 }
    val answerCode = answer.map { it.code - DIGIT_CODE_START + 1 }
    val strikes = findExactDigitMatch(queryCode, answerCode)
    val balls = findDigitMatch(queryCode, answerCode) - strikes
    return arrayListOf(strikes, balls)
}

fun findDigitMatch(queryCode: List<Int>, answerCode: List<Int>): Int {
    val setQueryCode = queryCode.toSet()
    val setAnswerCode = answerCode.toSet()
    val intersect = setQueryCode.intersect(setAnswerCode)
    return intersect.size
}

fun findExactDigitMatch(queryCode: List<Int>, answerCode: List<Int>): Int {
    val digitPair = queryCode.zip(answerCode)
    return digitPair.count { (query, answer) -> query == answer }
}

fun generateRandomNumberString(): String {
    val numberList = IntRange(1, 9).toMutableList()
    val pickNumber = ArrayList<Int>(0)
    for (i in 1 until VALID_LENGTH) {
        val currentPick = Randoms.pickNumberInRange(0, 9 - i)
        pickNumber.add(numberList[currentPick])
        numberList.removeAt(currentPick)
    }
    return pickNumber.joinToString("")
}

fun formatResult(strikes: Int, balls: Int): String {
    return when {
        strikes == 3 -> THREE_STRIKES
        (balls == 0) and (strikes == 0) -> NOTHING
        balls == 0 -> "${strikes}스트라이크"
        strikes == 0 -> "${balls}볼"
        else -> "${balls}볼 ${strikes}스트라이크"
    }
}

fun gameTurn(answer: String): Int {
    print(TURN_PROMPT)
    val query = Console.readLine()
    val (strikes, balls) = judgeResult(query, answer)
    println(formatResult(strikes, balls))
    return strikes
}

fun gameplay() {
    println(GAME_START)
    val answer = generateRandomNumberString()
    var strikes = 0
    while (strikes != 3) {
        strikes = gameTurn(answer)
    }
}

fun main() {
    var replayStatus = REPLAY
    while (replayStatus == REPLAY) {
        gameplay()
        println(REPLAY_PROMPT)
        replayStatus = Console.readLine().toInt()
    }
    require(replayStatus == GAME_OVER) { "Invalid query." }
}
