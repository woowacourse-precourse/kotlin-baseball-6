package baseball

data class CheckResult(
    val strike: Int = 0,
    val ball: Int = 0
) {
    override fun toString(): String {
        val msg = StringBuilder()
        if (ball != 0) {
            msg.append("${ball}${StringRes.BALL} ")
        }

        if (strike != 0) {
            msg.append("${strike}${StringRes.STRIKE} ")
        }

        if (strike == 0 && ball == 0) {
            msg.append(StringRes.NOTHING)
        }

        msg.trim()
        return msg.toString()
    }

}
