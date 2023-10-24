package validation

class UserInputValidation {
    public fun inputLength(input: String) {
        if (input.length != 3) {
            callInputLengthException()
        }
    }

    private fun callInputLengthException() {
        throw IllegalArgumentException("입력된 값이 3자리가 아닙니다.")
    }

    fun inputZeroToNine(inputs: String) {
        for (input in inputs) {
            if (input !in '1'..'9') {
                callInputRageException()
            }
        }
    }

    private fun callInputRageException() {
        throw IllegalArgumentException("1에서 9사이의 숫자가 아닙니다.")
    }
}