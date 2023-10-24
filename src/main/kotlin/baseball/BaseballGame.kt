package baseball

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







