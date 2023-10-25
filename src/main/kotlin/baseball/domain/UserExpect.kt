package baseball.domain

class UserExpect(private val userInput: String) {

    fun convertToInt(): Int = userInput.toInt()

    fun getUserInput() = userInput
}