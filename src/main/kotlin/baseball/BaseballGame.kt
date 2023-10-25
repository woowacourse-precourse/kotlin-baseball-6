package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    var restartNum = ""
    println(Dialogues.startGameMessage)
    do {
        val computerNum = generateRandomNum()
        try {
            solveBaseBallGame(computerNum)
        } catch (e: java.lang.IllegalArgumentException){
            throw IllegalArgumentException(Dialogues.illegalArgumentExceptionMessage)
        }
        println(Dialogues.restartMessage)
        restartNum = Console.readLine()
    } while (restartNum == "1")
    print(Dialogues.gameExitMessage)
}







