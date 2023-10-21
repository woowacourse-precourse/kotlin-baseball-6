package baseball

interface Player<T> {
    fun generateNumbers(input: String = "", testNumbers: List<Int> = listOf()): T
}