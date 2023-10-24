package baseball.util

fun String.toIntList(): List<Int> =
    this.map { char ->
        val current = char.toString()
        if (!current.isInt()) {
            throw IllegalArgumentException("Int 타입이 아님")
        }
        current.toInt()
    }

fun String.isInt(): Boolean = toIntOrNull() != null

fun String.containsSign(): Boolean =
    listOf('+', '-').contains(this.getOrNull(0)) ?: false