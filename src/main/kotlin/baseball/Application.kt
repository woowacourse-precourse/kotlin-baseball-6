package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object BaseballGameStatus {
    const val REPLAY = 1
    const val GAME_OVER = 2
    const val INVALID = -1
}

object BaseballNumberConstraints {
    const val VALID_LENGTH = 3
    const val DIGIT_START_CODE = '0'.code
    const val DIGIT_START = 1
    const val DIGIT_END = 9
}

object BaseballGameMessages {
    const val GAME_START = "숫자 야구 게임을 시작합니다."
    const val TURN_PROMPT = "숫자를 입력해주세요 : "
    const val THREE_STRIKES = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val NOTHING = "낫싱"
    const val REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
}

class BaseballNumber(numberString: String) : Iterable<Int> {
    private val digits = numberString.map { charToDigit(it) }

    init {
        require(isBaseballNumberValid(digits)) { "Invalid query." }
    }

    override fun iterator(): Iterator<Int> = digits.iterator()
}

private fun charToDigit(character: Char): Int {
    return character.code - BaseballNumberConstraints.DIGIT_START_CODE
}

private fun isBaseballNumberValid(digits: List<Int>): Boolean {
    val digitValidity = digits.map { isValidDigit(it) }
    return (isValidLength(digits)) and (digitValidity.all { it }) and (areAllDigitsUnique(digits))
}

private fun isValidLength(digits: List<Int>): Boolean {
    return digits.size == BaseballNumberConstraints.VALID_LENGTH
}

private fun isValidDigit(digit: Int): Boolean {
    return (BaseballNumberConstraints.DIGIT_START <= digit) and (digit <= BaseballNumberConstraints.DIGIT_END)
}

private fun areAllDigitsUnique(digitList: List<Int>): Boolean {
    val digitSet = hashSetOf<Int>()
    return digitList.all { digitSet.add(it) }
}

fun countMatchingDigits(query: BaseballNumber, answer: BaseballNumber): Int {
    val setQueryDigit = query.toSet()
    val setAnswerDigit = answer.toSet()
    return setAnswerDigit.count { setQueryDigit.contains(it) }
}

fun countExactPositionMatches(query: BaseballNumber, answer: BaseballNumber): Int {
    val digitPair = query.zip(answer)
    return digitPair.count { (queryDigit, answerDigit) -> queryDigit == answerDigit }
}

fun judgeResult(query: BaseballNumber, answer: BaseballNumber):Pair<Int, Int> {
    val strikes = countExactPositionMatches(query, answer)
    val balls = countMatchingDigits(query, answer) - strikes
    return strikes to balls
}

fun addUniqueRandomDigit(pickNumber:ArrayList<Int>){
    var randomNumber: Int
    do {
        randomNumber = Randoms.pickNumberInRange(1, 9)
    } while (pickNumber.contains(randomNumber))
    pickNumber.add(randomNumber)
}

fun generateRandomBaseballNumber(): BaseballNumber {
    val pickNumber = ArrayList<Int>(0)
    while (pickNumber.size < BaseballNumberConstraints.VALID_LENGTH) {
        addUniqueRandomDigit(pickNumber)
    }
    return BaseballNumber(pickNumber.joinToString(""))
}

fun formatResult(strikes: Int, balls: Int): String {
    return when {
        strikes == 3 -> BaseballGameMessages.THREE_STRIKES
        (balls == 0) and (strikes == 0) -> BaseballGameMessages.NOTHING
        balls == 0 -> "${strikes}스트라이크"
        strikes == 0 -> "${balls}볼"
        else -> "${balls}볼 ${strikes}스트라이크"
    }
}

fun gameTurn(answer: BaseballNumber): Int {
    print(BaseballGameMessages.TURN_PROMPT)
    val queryString = Console.readLine()
    val query = BaseballNumber(queryString)
    val (strikes, balls) = judgeResult(query, answer)
    println(formatResult(strikes, balls))
    return strikes
}

fun gameplay() {
    println(BaseballGameMessages.GAME_START)
    val answer = generateRandomBaseballNumber()
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
        println(BaseballGameMessages.REPLAY_PROMPT)
        replayStatus = readReplayStatus()
    }
    require(replayStatus == BaseballGameStatus.GAME_OVER) { "Invalid query." }
}
