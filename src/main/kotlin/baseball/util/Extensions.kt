package baseball.util

fun String.toIntList(): List<Int> =
    this.map { char -> char.toString().toInt() }