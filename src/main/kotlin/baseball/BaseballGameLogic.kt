package baseball

import camp.nextstep.edu.missionutils.Console


fun solveBaseBallGame(computerNum: MutableList<Int>) {
    while (true) {
        val userNum = getUserInput()
        val userNumList = if (checkCorrectNum(userNum)) {
            convertStringToMutableList(userNum)
        } else {
            throw IllegalArgumentException(Dialogues.illegalArgumentExceptionMessage)
        }

        var result = compareNum(computerNum, userNumList)
        var resultMessage = calculateBaseballGameResult(result)
        println(resultMessage)

        if (isGameOver(resultMessage)) {
            println(Dialogues.gameOverMessage)
            break
        }
    }
}

fun getUserInput(): String {
    print(Dialogues.requestEnterNumMessage)
    var userNum = Console.readLine()
    println(userNum)
    return userNum
}

fun checkCorrectNum(num: String): Boolean {
    var isDigit = num.all { it.isDigit() }
    var hasThreeDistinctDigits = num.toSet().size == 3
    var containNoZero = !num.contains("0")

    return isDigit && hasThreeDistinctDigits && containNoZero
}

fun compareNum(
    computerNum: MutableList<Int>,
    userNum: MutableList<Int>
): HashMap<String, Int> {
    var resultHashMap: HashMap<String, Int> = hashMapOf(GameResult.STRIKE to 0, GameResult.BALL to 0, GameResult.NOTHING to 0)
    for (value in userNum) {
        val indexOfKey = computerNum.indexOf(value)
        if (indexOfKey != -1) {
            if (indexOfKey == userNum.indexOf(value)) {
                resultHashMap[GameResult.STRIKE] = resultHashMap[GameResult.STRIKE]!! + 1
            } else {
                resultHashMap[GameResult.BALL] = resultHashMap[GameResult.BALL]!! + 1
            }
        } else {
            resultHashMap[GameResult.NOTHING] = resultHashMap[GameResult.NOTHING]!! + 1
        }
    }
    return resultHashMap
}


fun calculateBaseballGameResult(gameResult: HashMap<String, Int>): String {
    var strike = gameResult[GameResult.STRIKE]
    var ball = gameResult[GameResult.BALL]
    var nothing = gameResult[GameResult.NOTHING]
    return if (nothing == 3) {
        Dialogues.nothingMessage
    } else if (strike == 3) {
        "3${Dialogues.strikeMessage}"
    } else {
        val result = mutableListOf<String>()

        if (ball!! > 0) {
            result.add("${ball}${Dialogues.ballMessage}")
        }

        if (strike!! > 0) {
            result.add("${strike}${Dialogues.strikeMessage}")
        }
        result.joinToString(" ")
    }
}


fun isGameOver(result: String) = result == "3${Dialogues.strikeMessage}"
