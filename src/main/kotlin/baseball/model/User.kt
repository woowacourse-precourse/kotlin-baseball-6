package baseball.model

class User {
    private lateinit var numbers : String

    fun setNumber(input:String) {
        numbers=input
    }
    fun getNumber() = numbers
}