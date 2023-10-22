package baseball

class BaseBallGameCounter {

    private val LENGTH = 3
     fun calCount(
        inputList: MutableList<Int>,
        numberList: MutableList<Int>
     ) : Pair<Int, Int> {
        var strike = 0
        var ball = 0
        for(i: Int in 0..< LENGTH) {
            for(j: Int in 0..< LENGTH) {
                if(inputList[i] == numberList[j]) {
                    if(i != j) ball += 1 else strike += 1
                }
            }
        }
        return Pair(strike, ball)
    }

}