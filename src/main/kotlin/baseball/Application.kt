package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println(START_PLAY_TEXT)
    do {
        startBaseballPlay()
    } while (restartBaseballPlay())

}

fun startBaseballPlay() {
    val computerRandomNum = createComputerRandomNum()
    do {
        val playerAnswer = inputPlayerNum()
        strikeAndBall(computerRandomNum, playerAnswer)
    } while (!compareComputerAndPlayer(computerRandomNum, playerAnswer))
    endBaseballPlay()
}

fun createComputerRandomNum(): String {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < INPUT_ANSWER_LENGTH) {
        val randomNumber = Randoms.pickNumberInRange(MIN_INPUT_NUM, MAX_INPUT_NUM)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum.joinToString("")
}

fun inputPlayerNum(): String {
    print(INPUT_ANSWER_TEXT)
    val inputPlayer = Console.readLine()
    val playerNum = mutableListOf<Char>()
    if (!isNum(inputPlayer)) {
        throw IllegalArgumentException(WRONG_NUM_EXCEPTION)
    }
    if (inputPlayer.length != INPUT_ANSWER_LENGTH) {
        throw IllegalArgumentException(WRONG_NUM_LENGTH_EXCEPTION)
    }
    for (index in inputPlayer.indices) {
        if (playerNum.contains(inputPlayer[index])) {
            throw IllegalArgumentException(DUPLICATED_NUM_EXCEPTION)
        }
        playerNum.add(inputPlayer[index])
    }
    return playerNum.joinToString("")
}

fun compareComputerAndPlayer(computer: String, player: String): Boolean {
    return computer == player
}

fun strikeAndBall(computer: String, player: String) {
    var strike = NO_STRIKE
    var ball = NO_BALL
    for (index in MIN_ANSWER_INDEX_NUM..MAX_ANSWER_INDEX_NUM) {
        if (computer[index] == player[index]) {
            strike++
        } else {
            if (computer.contains(player[index])) {
                ball++
            }
        }
    }
    baseballHint(strike, ball)
}

fun baseballHint(strike: Int, ball: Int) {
    when {
        (strike == NO_STRIKE && ball == NO_BALL) -> println("낫싱")
        (strike != NO_STRIKE && ball == NO_BALL) -> println("${strike}스트라이크")
        (strike == NO_STRIKE && ball != NO_BALL) -> println("${ball}볼")
        (strike != NO_STRIKE && ball != NO_BALL) -> println("${ball}볼 ${strike}스트라이크")
    }
}

fun isNum(inputPlayer: String): Boolean {
    var isNum = true
    inputPlayer.forEach { char ->
        val charConvertToInt = char.digitToIntOrNull()
        val charConvertToCode = char.code
        if (charConvertToCode > MAX_NUM_RANGE_ASCII || charConvertToCode < MIN_NUM_RANGE_ASCII) {
            isNum = false
            return isNum
        }
        if (charConvertToInt == null) {
            throw IllegalArgumentException(NO_EXIST_INPUT_NUM_TEXT)
            isNum = false
            return isNum
        }
        if (charConvertToInt > MAX_INPUT_NUM || charConvertToInt < MIN_INPUT_NUM) {
            throw IllegalArgumentException(WRONG_INPUT_NUM_RANGE_EXCEPTION)
            isNum = false
            return isNum
        }
    }
    return isNum
}

fun endBaseballPlay() {
    println(END_PLAY_TEXT)
}

fun restartBaseballPlay(): Boolean {
    println(RESTART_PLAY_TEXT)

    val inputPlayerRestart = Console.readLine()
    if (inputPlayerRestart.toInt() == RESTART_INPUT_NUM) {
        return true
    }
    if (inputPlayerRestart.toInt() == END_INPUT_NUM) {
        return false
    }
    throw IllegalArgumentException(WRONT_RESTART_NUM_EXCEPTION)
}
