package baseball.Controller

import baseball.Model.GameModel

class GameController
{

    private var computerNumber = mutableListOf<Int>()

    fun gameStarter()
    {
        var gameController=true
        while(gameController)
        {
            computerNumber=RandomNumberGenerator().createComputerNumbers()
            GameModel(computerNumber)
            gameController=WaitForAnswer()
        }
    }
    fun WaitForAnswer(): Boolean
    {
        var answer = false
        while (!answer) {
            var usernumber=UserInputCheck().userInputValidation()
            val gameModel = GameModel(usernumber, computerNumber)
            answer = CompareInputValue().compareInputs(gameModel)
            if (answer)
            {
                return Retry().askContinue()
            }
        }
        return true
    }
}
