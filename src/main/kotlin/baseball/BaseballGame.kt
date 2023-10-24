package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var restartNum = ""
    print(Dialogues.startGameMessage)
    do {
        var computerNum = generateRandomNum()
        try{
            solveBaseBallGame(convertStringToHashMap(computerNum.joinToString("")))

        } catch (e:java.lang.IllegalArgumentException){
            return throw IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.")
        }
        print(Dialogues.restartMessage)
        restartNum = Console.readLine()
    } while (restartNum == "1")
    print("게임 종료")
    return
}

fun solveBaseBallGame(computerNum:HashMap<Int, Int>){
    while(true) {
        var userNum = getUserInput()
        var userNumHashMap = HashMap<Int, Int>()

        if (checkCorrectNum(userNum)) {
            userNumHashMap = convertStringToHashMap(userNum)
        } else {
            throw IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.")
        }

        var result = compareNum(computerNum, userNumHashMap)
        var resultMessage = printBaseBallGameResult(result)
        println(resultMessage)

        if(isGameOver(resultMessage)){
            print(Dialogues.gameOverMessage)
            break
        }
    }
}





