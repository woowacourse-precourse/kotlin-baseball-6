package baseball.model

class RetryNumberModel(private var number:Int) {
    fun getNumber() = number
    fun setNumber(number:Int){
        this.number = number
    }
}