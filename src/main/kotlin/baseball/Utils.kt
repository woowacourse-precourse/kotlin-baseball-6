package baseball

fun stringToUniqueIntArray(inputData: String): IntArray {
    return inputData
        .map { it.toString().toInt() }
        .toSet()
        .toIntArray()
}