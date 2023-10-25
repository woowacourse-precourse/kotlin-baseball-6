package baseball

object ValidateUtils {
    fun validateLength(input: String) {
        if (input.length != 3) {
            throw IllegalArgumentException()
        }
    }

    fun validateDigit(input: String){
        input.forEach {
            if (!it.isDigit()) throw IllegalArgumentException()
        }
    }

    fun validateDigitRange(input: String){
        input.forEach {
            if (it < '1' || it > '9') throw IllegalArgumentException()
        }
    }

    fun validateDuplicateNumber(input: String){
        if (input[0] == input[1] || input[1] == input[2] || input[0] == input[2]) {
            throw IllegalArgumentException()
        }
    }
}