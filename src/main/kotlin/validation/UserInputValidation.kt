package validation

class UserInputValidation {
    fun inputLength(input: String) { // todo public제거
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

    private fun callInputRageException() { // todo 오타수정 range
        throw IllegalArgumentException("1에서 9사이의 숫자가 아닙니다.")
    }

    fun inputUnique(input: String) {
        val unique = input.toSet()

        if (unique.size != input.length) {
            callInputUniqueException()
        }
    }

    private fun callInputUniqueException() {
        throw IllegalArgumentException("중복된 숫자는 입력하면 안됩니다.")
    }
}