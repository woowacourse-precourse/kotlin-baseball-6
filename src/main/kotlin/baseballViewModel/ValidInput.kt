package baseballViewModel


class ValidInput {
    private fun sizeCheck(inputNumber: String) {
        if (inputNumber.length != 3)
            throw IllegalArgumentException("[Error]숫자는 3개 모두 입력하셔야합니다.")
    }

    private fun containZero(inputNumber: String) {
        if (inputNumber.contains("0"))
            throw IllegalArgumentException("[Error]숫자는 1부터 9까지로 구성되어있습니다.")
    }

    private fun duplicateNumber(inputNumber: String) {
        if (inputNumber.toSet().size != inputNumber.length)
            throw IllegalArgumentException("[Error]중복된 숫자가 존재합니다.")
    }

    private fun notInt(inputNumber: String) {
        if (inputNumber.toIntOrNull() == null)
            throw IllegalArgumentException("[Error]숫자만 입력 가능합니다.")
    }

    fun validUserNumber(inputNumber: String, userNumber: MutableList<Char>) {
        sizeCheck(inputNumber)
        containZero(inputNumber)
        duplicateNumber(inputNumber)
        notInt(inputNumber)
        userNumber.addAll(inputNumber.toList())
    }
}
