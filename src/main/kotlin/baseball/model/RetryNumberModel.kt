package baseball.model

class RetryNumberModel(private val number:Int) {

    fun isRetry() = number == RETRY_NUM

    companion object {
        const val RETRY_NUM = 1
    }
}