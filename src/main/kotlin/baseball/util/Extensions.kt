package baseball.util

fun String.toIntList(): List<Int> =
    this.map { char -> char.toString().toInt() }

fun String.containsSign(): Boolean =
    this.getOrNull(0) in listOf('+', '-')