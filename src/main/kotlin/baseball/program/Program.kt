package baseball.program

class Program {
    var randomNumber = "000"

    fun setRandomNumber() {
        var set = mutableSetOf<Int>()

        while(set.size < 6) {
            set.add((1..9).random())
        }

        this.randomNumber = set.toString()
    }

    fun checkThreeNumbers(input: String): Boolean {
        var bool = if (input.length == 3) true else false
        return bool
    }


}