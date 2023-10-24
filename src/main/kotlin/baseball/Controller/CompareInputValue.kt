package baseball.Controller

import baseball.Model.GameModel

class CompareInputValue
{

    fun compareInputs(gameModel: GameModel):Boolean
    {

        var correctValueAndPosition = 0
        var correctValueOnly = 0

        val userNumbers = gameModel.userInputNumbers
        val computerNumbers = gameModel.computerNumbers


        for (i in userNumbers.indices)
        {
            if (userNumbers[i] == computerNumbers[i])
            {
                correctValueAndPosition++
            }
            else if (computerNumbers.contains(userNumbers[i]))
            {
                correctValueOnly++
            }
        }

        if (correctValueOnly > 0)
        {
            print("${correctValueOnly}볼 ")
        }
        if (correctValueAndPosition in 1..2)
        {
            println("${correctValueAndPosition}스트라이크")
        }
        else if (correctValueAndPosition == 3)
        {
            println("${correctValueAndPosition}스트라이크")
            return true
        }
        else if (correctValueAndPosition == 0 && correctValueOnly == 0)
        {
            println("낫싱")
        }
        if (correctValueOnly > 0 && correctValueAndPosition == 0) { println() }

        return false
    }

}