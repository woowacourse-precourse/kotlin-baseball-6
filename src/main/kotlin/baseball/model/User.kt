package baseball.model

class User {
    private lateinit var _numbers : String
    val numbers get () = _numbers
    fun setNumber(input:String) {
        _numbers=input
    }
}