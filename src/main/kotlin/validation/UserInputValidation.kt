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
}