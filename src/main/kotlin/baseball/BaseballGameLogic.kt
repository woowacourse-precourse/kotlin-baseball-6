package baseball

import camp.nextstep.edu.missionutils.Console


fun solveBaseBallGame(computerNum: MutableList<Int>) {
    while (true) {
        val userNum = getUserInput()
        val userNumList = if (checkCorrectNum(userNum)) {
            convertStringToMutableList(userNum)
        } else {
            throw IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.")
        }

        var result = compareNum(computerNum, userNumList)
        var resultMessage = calculateBaseballGameResult(result)
        println(resultMessage)

        if (isGameOver(resultMessage)) {
            print(Dialogues.gameOverMessage)
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
    var resultHashMap: HashMap<String, Int> = hashMapOf("strike" to 0, "ball" to 0, "nothing" to 0)
    for (value in userNum) {
        val indexOfKey = computerNum.indexOf(value)
        if (indexOfKey != -1) {
            if (indexOfKey == userNum.indexOf(value)) {
                resultHashMap["strike"] = resultHashMap["strike"]!! + 1
            } else {
                resultHashMap["ball"] = resultHashMap["ball"]!! + 1
            }
        } else {
            resultHashMap["nothing"] = resultHashMap["nothing"]!! + 1
        }
    }
    return resultHashMap
}


fun calculateBaseballGameResult(numArray: HashMap<String, Int>): String {
    var strike = numArray["strike"]
    var ball = numArray["ball"]
    var nothing = numArray["nothing"]
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


fun isGameOver(result: String) = result == "3스트라이크"
