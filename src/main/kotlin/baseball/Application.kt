package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object BaseballGameStatus {
    const val REPLAY = 1
    const val GAME_OVER = 2
    const val INVALID = -1
    const val REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
}

object BaseballNumberValidity {
    const val VALID_LENGTH = 3
    const val DIGIT_START_CODE = '0'.code
    const val DIGIT_START = 1
    const val DIGIT_END = 9
}

object BaseballTurnStatus {
    const val GAME_START = "숫자 야구 게임을 시작합니다."
    const val TURN_PROMPT = "숫자를 입력해주세요 : "
    const val THREE_STRIKES = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val NOTHING = "낫싱"
}

class BaseballNumber(numberString: String) : Iterable<Int> {
    private val digits = numberString.map { letterToInt(it) }

    init {
        require(isValidBaseballNumber(digits)) { "Invalid query." }
    }

    override fun iterator(): Iterator<Int> = digits.iterator()

    override fun toString(): String {
        return digits.joinToString("")
    }
}

private fun letterToInt(letter: Char): Int {
    return letter.code - BaseballNumberValidity.DIGIT_START_CODE
}

private fun isValidBaseballNumber(digits: List<Int>): Boolean {
    val digitValidity = digits.map { isValidDigit(it) }
    return (isValidLength(digits)) and (digitValidity.all { it }) and (isEveryLetterUnique(digits))
}

private fun isValidLength(digits: List<Int>): Boolean {
    return digits.size == BaseballNumberValidity.VALID_LENGTH
}

private fun isValidDigit(digit: Int): Boolean {
    return (BaseballNumberValidity.DIGIT_START <= digit) and (digit <= BaseballNumberValidity.DIGIT_END)
}

private fun isEveryLetterUnique(queryLetterCode: List<Int>): Boolean {
    val digitSet = hashSetOf<Int>()
    return queryLetterCode.all { digitSet.add(it) }
}

fun findDigitMatch(query: BaseballNumber, answer: BaseballNumber): Int {
    val setQueryDigit = query.toSet()
    val setAnswerDigit = answer.toSet()
    return setAnswerDigit.count { setQueryDigit.contains(it) }
}

fun findExactDigitMatch(query: BaseballNumber, answer: BaseballNumber): Int {
    val digitPair = query.zip(answer)
    return digitPair.count { (queryDigit, answerDigit) -> queryDigit == answerDigit }
}

fun judgeResult(query: BaseballNumber, answer: BaseballNumber):Pair<Int, Int> {
    val strikes = findExactDigitMatch(query, answer)
    val balls = findDigitMatch(query, answer) - strikes
    return strikes to balls
}

fun pickUniqueDigit(pickNumber:ArrayList<Int>){
    val randomNumber = Randoms.pickNumberInRange(1, 9)
    if (!pickNumber.contains(randomNumber)) {
        pickNumber.add(randomNumber)
    }
}

fun generateRandomBaseballNumber(): BaseballNumber {
    val pickNumber = ArrayList<Int>(0)
    while (pickNumber.size < 3) {
        pickUniqueDigit(pickNumber)
    }
    return BaseballNumber(pickNumber.joinToString(""))
}

fun formatResult(strikes: Int, balls: Int): String {
    return when {
        strikes == 3 -> BaseballTurnStatus.THREE_STRIKES
        (balls == 0) and (strikes == 0) -> BaseballTurnStatus.NOTHING
        balls == 0 -> "${strikes}스트라이크"
        strikes == 0 -> "${balls}볼"
        else -> "${balls}볼 ${strikes}스트라이크"
    }
}

fun gameTurn(answer: BaseballNumber): Int {
    print(BaseballTurnStatus.TURN_PROMPT)
    val queryString = Console.readLine()
    print(queryString)
    println()
    val query = BaseballNumber(queryString)
    val (strikes, balls) = judgeResult(query, answer)
    println(formatResult(strikes, balls))
    return strikes
}

fun gameplay() {
    println(BaseballTurnStatus.GAME_START)
    val answer = generateRandomBaseballNumber()
    println("answer : $answer")
    var strikes = 0
    while (strikes != 3) {
        strikes = gameTurn(answer)
    }
}

fun isValidReplayStatus(replayStatusString:String):Boolean{
    return (replayStatusString.length == 1) and (replayStatusString.all { it.isDigit() })
}

fun readReplayStatus():Int{
    val replayStatusString = Console.readLine().trim()
    if (isValidReplayStatus(replayStatusString)){
        return replayStatusString.toInt()
    }
    return BaseballGameStatus.INVALID
}

fun main() {
    var replayStatus = BaseballGameStatus.REPLAY
    while (replayStatus == BaseballGameStatus.REPLAY) {
        gameplay()
        println(BaseballGameStatus.REPLAY_PROMPT)
        replayStatus = readReplayStatus()
    }
    require(replayStatus == BaseballGameStatus.GAME_OVER) { "Invalid query." }
}
