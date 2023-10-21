package baseball

typealias BaseballNum = Triple<Int, Int, Int>

fun String.toBaseballNum(): BaseballNum =
    Triple(this[0].digitToInt(), this[1].digitToInt(), this[2].digitToInt())