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
}