package baseball.model

class BaseballModel(private var numbers:MutableList<Int>){

    fun getNumbers() = numbers

    fun setNumbers(numbers:MutableList<Int>){
        this.numbers = numbers
    }

}