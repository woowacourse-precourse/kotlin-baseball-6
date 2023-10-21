package baseball

interface Player<T> {
    fun generateNumbers(input: String = ""): T
}