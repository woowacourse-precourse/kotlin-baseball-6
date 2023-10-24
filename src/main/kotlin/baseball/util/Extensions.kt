package baseball.util

fun String.toIntList(): List<Int> =
    this.map { char ->
        val current = char.toString()
        if (!current.isInt()) {
            throw IllegalArgumentException("Int 타입이 아님")
        }
        current.toInt()
    }

fun String.isInt(includeSign: Boolean = true): Boolean {
    val value = if (!includeSign) {
        this.removeSign()
    } else {
        this
    }

    return value.toIntOrNull() != null
}

fun String.removeSign(): String {
    if (containsSign()) {
        return this.substring(1)
    }
    return this
}

fun String.containsSign(): Boolean =
    listOf('+', '-').contains(this.getOrNull(0)) ?: false