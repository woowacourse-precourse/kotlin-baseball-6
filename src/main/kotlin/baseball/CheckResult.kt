package baseball

data class CheckResult(
    val strike: Int = 0,
    val ball: Int = 0
) {
    override fun toString(): String {
        val msg = StringBuilder()
        if (ball != 0) {
            msg.append("${ball}볼 ")
        }

        if (strike != 0) {
            msg.append("${strike}스트라이크 ")
        }

        if (strike == 0 && ball == 0) {
            msg.append("낫싱")
        }

        msg.trim()
        return msg.toString()
    }

}
