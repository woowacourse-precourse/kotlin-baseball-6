package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

private const val START = 1
private const val END = 9
private const val LENGTH = 3

fun main() {

}

private fun generateRandomNumberList(): List<Int> {
    val numberSet = mutableSetOf<Int>()

    while (numberSet.size < LENGTH) {
        numberSet.add(pickNumberInRange(START, END))
    }
    return numberSet.toList()
}
