import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object BaseballGameStatus {
    const val REPLAY = 1
    const val GAME_OVER = 2
    const val REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
}

object BaseballNumberValidity {
    const val VALID_LENGTH = 3
    const val DIGIT_CODE_START = '1'.code
    const val DIGIT_CODE_END = '9'.code
}

object BaseballTurnStatus {
    const val GAME_START = "숫자 야구 게임을 시작합니다."
    const val TURN_PROMPT = "숫자를 입력해주세요 : "
    const val THREE_STRIKES = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val NOTHING = "낫싱"
}

class BaseballNumber(numberString: String) {
    val digits = numberString.map { it.code - BaseballNumberValidity.DIGIT_CODE_START + 1 }

    init {
        require(isValidBaseballNumber(numberString)) { "Invalid query." }
    }
}

private fun isValidBaseballNumber(query: String): Boolean {
    val queryLetterCode = query.map { it.code }
    val queryLetterValidity = queryLetterCode.map { isValidLetter(it) }
    return (isValidLength(query)) and (queryLetterValidity.all { it }) and (isEveryLetterUnique(queryLetterCode))
}

private fun isValidLength(query: String): Boolean {
    return query.length == BaseballNumberValidity.VALID_LENGTH
}

private fun isValidLetter(letter: Int): Boolean {
    return (BaseballNumberValidity.DIGIT_CODE_START <= letter) and (letter <= BaseballNumberValidity.DIGIT_CODE_END)
}

private fun isEveryLetterUnique(queryLetterCode: List<Int>): Boolean {
    val digitSet = hashSetOf<Int>()
    return queryLetterCode.all { digitSet.add(it) }
}

fun findDigitMatch(query: BaseballNumber, answer: BaseballNumber): Int {
    val setQueryDigit = query.digits.toSet()
    val setAnswerDigit = answer.digits.toSet()
    val intersect = setQueryDigit.intersect(setAnswerDigit)
    return intersect.size
}

fun findExactDigitMatch(query: BaseballNumber, answer: BaseballNumber): Int {
    val digitPair = query.digits.zip(answer.digits)
    return digitPair.count { (queryDigit, answerDigit) -> queryDigit == answerDigit }
}

fun judgeResult(query: BaseballNumber, answer: BaseballNumber): ArrayList<Int> {
    val strikes = findExactDigitMatch(query, answer)
    val balls = findDigitMatch(query, answer) - strikes
    return arrayListOf(strikes, balls)
}

fun generateRandomBaseballNumber(): BaseballNumber {
    val numberList = IntRange(1, 9).toMutableList()
    val pickNumber = ArrayList<Int>(0)
    for (i in 1 until BaseballNumberValidity.VALID_LENGTH) {
        val currentPick = Randoms.pickNumberInRange(0, 9 - i)
        pickNumber.add(numberList[currentPick])
        numberList.removeAt(currentPick)
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
    val query = BaseballNumber(Console.readLine())
    val (strikes, balls) = judgeResult(query, answer)
    println(formatResult(strikes, balls))
    return strikes
}

fun gameplay() {
    println(BaseballTurnStatus.GAME_START)
    val answer = generateRandomBaseballNumber()
    var strikes = 0
    while (strikes != 3) {
        strikes = gameTurn(answer)
    }
}

fun main() {
    var replayStatus = BaseballGameStatus.REPLAY
    while (replayStatus == BaseballGameStatus.REPLAY) {
        gameplay()
        println(BaseballGameStatus.REPLAY_PROMPT)
        replayStatus = Console.readLine().toInt()
    }
    require(replayStatus == BaseballGameStatus.GAME_OVER) { "Invalid query." }
}
