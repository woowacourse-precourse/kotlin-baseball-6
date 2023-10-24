package baseball.util

fun String.toIntList(): List<Int> =
    this.map { char ->
        char.toString().toInt()
    }

fun String.containsSign(): Boolean =
    listOf('+', '-').contains(this.getOrNull(0)) ?: false