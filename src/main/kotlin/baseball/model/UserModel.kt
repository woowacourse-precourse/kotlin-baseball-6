package baseball.model

class UserModel(private var numbers: List<Int>){
    fun getNumbers() = numbers

    fun setNumbers(numbers:MutableList<Int>){
        this.numbers = numbers
    }
}
