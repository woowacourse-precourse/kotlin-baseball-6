package baseballViewModel


class ValidInput {
    companion object{
        val size_limit=3
    }
    private fun sizeCheck(inputNumber: String) {
        if (inputNumber.length != size_limit)
            throw IllegalArgumentException(ErrorMessage.INPUT_SIZE_ERROR.message)
    }

    private fun containZero(inputNumber: String) {
        if (inputNumber.contains("0"))
            throw IllegalArgumentException(ErrorMessage.MISS_RANGE.message)
    }

    private fun duplicateNumber(inputNumber: String) {
        if (inputNumber.toSet().size != inputNumber.length)
            throw IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.message)
    }

    private fun notInt(inputNumber: String) {
        if (inputNumber.toIntOrNull() == null)
            throw IllegalArgumentException(ErrorMessage.ONLY_NUMBERS.message)
    }

    fun validUserNumber(inputNumber: String, userNumber: MutableList<Char>) {
        sizeCheck(inputNumber)
        containZero(inputNumber)
        duplicateNumber(inputNumber)
        notInt(inputNumber)
        userNumber.addAll(inputNumber.toList())
    }
}
