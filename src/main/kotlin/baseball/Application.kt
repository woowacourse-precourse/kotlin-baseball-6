package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    do {
        val playAgain = playGame()
    } while (playAgain.again)

    println("게임 종료")
}


fun playGame(): PlayAgain {
    val targetNumber = createTargetNumber()

    // TODO: 유저 입력 가져오기 + validation

    // TODO: 입력과 target number 비교 + 출력

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