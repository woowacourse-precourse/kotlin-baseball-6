package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

private const val MAX_DIGIT = 3

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    do {
        val playAgain = playGame()
    } while (playAgain.again)

    println("게임 종료")
}


fun playGame(): PlayAgain {
    val targetNumber = createTargetNumber()

    while (true) {
        val validInput = getValidUserInput()

        val result = compareInput(input = validInput, targetNumber = targetNumber)

        // TODO: CompareResult를 이용하여 출력

        if (result.isCorrectGuess()) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }

    // TODO: 1 입력하면 again을 true, 2 입력하면 again false

    return PlayAgain(again = false)
}


@JvmInline
value class PlayAgain(val again: Boolean)


fun createTargetNumber(): TargetNumber {
    val targetNumber = TargetNumber()

    targetNumber.putDigitInfo(pickNumberInRange(1, 9), 1) // first digit
    while (!targetNumber.putDigitInfo(pickNumberInRange(1, 9), 2)); // second digit
    while (!targetNumber.putDigitInfo(pickNumberInRange(1, 9), 3)); // third digit

    return targetNumber
}


class TargetNumber {
    // key : 숫자
    // value : 해당 숫자의 자리
    private val numberMap = mutableMapOf<Int, Int>()

    fun putDigitInfo(number: Int, digit: Int): Boolean {
        val digitInfo = getDigitInfoOrNull(number)

        if (digitInfo != null) return false

        numberMap[number] = digit

        return true
    }

    fun getDigitInfoOrNull(number: Int): Int? = numberMap[number]

    override fun toString(): String {
        return numberMap.toString()
    }
}


fun getValidUserInput(): Int {
    val input = readLine().toString().toInt()

    validateInput(input = input)

    return input
}


fun validateInput(input: Int) {
    require(input <= 999)

    var inputVar = input
    var digit = MAX_DIGIT

    with(TargetNumber()) {
        repeat(MAX_DIGIT) {
            // putDigitInfo의 경우 이미 있는 숫자를 put할 경우 false return
            require(putDigitInfo(inputVar % 10, digit))

            inputVar /= 10
            digit--
        }
    }
}


fun compareInput(input: Int, targetNumber: TargetNumber): CompareResult {
    var strike = 0
    var ball = 0

    var inputVar = input
    var currentDigit = MAX_DIGIT

    repeat(MAX_DIGIT) {
        targetNumber.getDigitInfoOrNull(number = inputVar % 10)?.let { digit ->
            if (digit == currentDigit) strike++ else ball++
        }

        inputVar /= 10
        currentDigit--
    }

    return CompareResult(strike = strike, ball = ball)
}


data class CompareResult(
    val strike: Int,
    val ball: Int
) {
    fun isCorrectGuess(): Boolean = strike == 3
}