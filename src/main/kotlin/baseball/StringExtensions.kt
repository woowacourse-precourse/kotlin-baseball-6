fun String?.getNotEmptyInt(): Int {
    val input = this?.trim()
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException("input String is null or empty")
    }
    if (input.toIntOrNull() == null) {
        throw IllegalArgumentException("input String cannot be parsed Int")
    }
    return input.toInt()
}

fun String?.isValidateInputNumber() {
    val num = this.getNotEmptyInt()
    if (num < 123 || num > 987) {
        throw IllegalArgumentException("input number is unavailable")
    }
}