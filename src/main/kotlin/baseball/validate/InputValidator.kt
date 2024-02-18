package baseball.validate

class InputValidator {
    companion object {

         fun validateInputNumberSize(inputNumbers: String, numberSize: Int) {
            if (inputNumbers.length != numberSize) {
                throw IllegalArgumentException("숫자는 ${numberSize}자리를 입력해주세요")
            }
        }

        fun validateNumberFormat(inputNumbers: String) {
            try {
                inputNumbers.toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("숫자를 입력해주세요")
            }
        }

        fun validateNumberDuplicate(inputNumbers: String) {
            val existCount = IntArray(10)

            for (element in inputNumbers) {
                val number = element.toString().toInt()
                if (existCount[number] != 0) {
                    throw IllegalArgumentException("중복되지 않는 숫자를 입력해주세요")
                }
                existCount[number]++
            }
        }

    }
}