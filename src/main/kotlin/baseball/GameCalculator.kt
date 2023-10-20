package baseball

class GameCalculator {

   private var gameResult = GameResult()
    fun calculate(ansNum : List<Int>, inputNum : List<Int>) : GameResult {

        //초기화
        gameResult = GameResult(0,0)

        inputNum.forEachIndexed {
             inputIndex ,input->

            if(ansNum.contains(input)){

                ansNum.forEachIndexed { ansIndex, ans ->
                    if(ans == input && inputIndex==ansIndex) gameResult.strike +=1
                    else if(ans == input && inputIndex != ansIndex) gameResult.ball +=1
                }


        }

        }


        return gameResult

    }
}