package baseball

class Referee {
    private val ballStrikeCounts = mutableListOf(0, 0)
    private var hasAnyMatchNumber = false
    private var resultMessage = ""

    fun judge(pitcherNumbers: List<Int>, batterNumbers: List<Int>) {
        checkNothingOrNot(pitcherNumbers, batterNumbers)

        if (hasAnyMatchNumber) {
            countBall(pitcherNumbers, batterNumbers)
            countStrike(pitcherNumbers, batterNumbers)
        }

        setResultMessage()
    }

    private fun countBall(pitcherNumbers: List<Int>, batterNumbers: List<Int>) {
        for (number in pitcherNumbers) {
            if (batterNumbers.contains(number)
                && pitcherNumbers.indexOf(number) != batterNumbers.indexOf(number)
            ) {
                ballStrikeCounts[0] += 1
            }
        }
    }

    private fun countStrike(pitcherNumbers: List<Int>, batterNumbers: List<Int>) {
        for (number in pitcherNumbers) {
            if (batterNumbers.contains(number)
                && pitcherNumbers.indexOf(number) == batterNumbers.indexOf(number)
            ) {
                ballStrikeCounts[1] += 1
            }
        }
    }

    private fun checkNothingOrNot(pitcherNumbers: List<Int>, batterNumbers: List<Int>) {
        hasAnyMatchNumber = false

        for (number in pitcherNumbers) {
            if (batterNumbers.contains(number)) {
                hasAnyMatchNumber = true
                break
            }
        }
    }

    fun showResult() {
        if (!hasAnyMatchNumber) println("낫싱")
        else println(resultMessage)
    }

    private fun setResultMessage() {
        resultMessage = ""
        val ballCounts = ballStrikeCounts[0]
        val strikeCounts = ballStrikeCounts[1]

        if (ballCounts > 0) resultMessage = "${ballCounts}볼 "
        if (strikeCounts > 0) resultMessage += "${strikeCounts}스트라이크"
    }
}