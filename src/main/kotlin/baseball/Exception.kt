package baseball

object Exception {
    fun wrongNumException(answer: String) {
        if (!isNum(answer)) throw IllegalArgumentException(WRONG_NUM_EXCEPTION)
    }

    fun isNum(answer: String): Boolean {
        answer.forEach { char ->
            val charConvertToInt = char.digitToIntOrNull()
            val charConvertToCode = char.code
            if (charConvertToCode > MAX_NUM_RANGE_ASCII || charConvertToCode < MIN_NUM_RANGE_ASCII) {
                throw IllegalArgumentException(WRONG_INPUT_EXCEPTION)
            }
            if (charConvertToInt == null) {
                throw IllegalArgumentException(NO_EXIST_INPUT_NUM_EXCEPTION)
            }
            if (charConvertToInt > MAX_INPUT_NUM || charConvertToInt < MIN_INPUT_NUM) {
                throw IllegalArgumentException(WRONG_INPUT_NUM_RANGE_EXCEPTION)
            }
        }
        return true
    }
}