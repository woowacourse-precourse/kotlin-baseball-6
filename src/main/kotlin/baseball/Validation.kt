package baseball

object Validation {
    fun checkInput(input: String){
        checkLength(input)
        checkNumber(input)
        checkZero(input)
        checkDuplication(input)
    }
    private fun checkLength(input: String) {
        if (input.length != 3){
            throw IllegalArgumentException(Message.ERROR_LENGTH)
        }
    }
    private fun checkNumber(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(Message.ERROR_NUMBER)
        }
    }
    private fun checkZero(input: String) {
        if (input.contains("0")) {
            throw IllegalArgumentException(Message.ERROR_ZERO)
        }
    }
    private fun checkDuplication(input: String) {
        if (input.toSet().size != 3) {
            throw IllegalArgumentException(Message.ERROR_DUPLICATION)
        }

    }
}