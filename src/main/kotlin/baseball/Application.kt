package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val NUMBERLENGTH: Int = 3
const val INITALMESSAGE = "숫자 야구 게임을 시작합니다."
const val GUESSINPUTREQUESTMESSAGE = "숫자를 입력해주세요 : "
const val BALLMESSAGE: String = "볼"
const val STRIKEMESSAGE: String = "스트라이크"
const val NOTINGMESSAGE: String = "낫싱"
const val ERRORMESSAGE: String = "잘못된 값이 입력되었습니다. 프로그램을 종료합니다."
const val VICTORYMESSAGE: String = "개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val ASKREPLAYMESSAGE: String = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val RESTARTCODE: String = "1"
const val FINISHCODE: String = "2"

fun checkPlayerInput(playerInput : String) {
    val cache = BooleanArray(10)
    if(playerInput.length != NUMBERLENGTH)
    {
        throw IllegalArgumentException(ERRORMESSAGE)
    }
    for(i in playerInput.indices) {
        if(cache[playerInput[i].digitToInt()]) {
            throw IllegalArgumentException(ERRORMESSAGE)
        }
        cache[playerInput[i].digitToInt()] = true
    }
    for(i in playerInput.indices) {
        if(playerInput[i] !in '1'..'9') {
            throw IllegalArgumentException(ERRORMESSAGE)
        }
    }
}

fun guessInput() : String {
    print(GUESSINPUTREQUESTMESSAGE)
    val playerInput : String = Console.readLine()
    checkPlayerInput(playerInput)
    return playerInput
}

fun comp(playerInput : String, answerArray : CharArray, cache : BooleanArray) : Pair<Int, Int> {
    var strike = 0
    var ball = 0
    for(i in 0 until NUMBERLENGTH)
    {
        if(playerInput[i] == answerArray[i])
        {
            strike++
        }
        else if(cache[playerInput[i].digitToInt()])
        {
            ball++
        }
    }
    return Pair(strike, ball)
}

fun showResult(result : Pair<Int, Int>) {
    if (result.first == 0 && result.second == 0) {
        print(NOTINGMESSAGE)
    }
    if (result.second > 0) {
        print(result.second.digitToChar() + BALLMESSAGE)
    }
    if (result.first > 0 && result.second > 0) {
        print(" ")
    }
    if (result.first > 0) {
        print(result.first.digitToChar() + STRIKEMESSAGE)
    }
    println()
    if (result.first == NUMBERLENGTH) {
        println(NUMBERLENGTH.digitToChar() + VICTORYMESSAGE)
    }
}

fun game() : Int {
    val answerArray = CharArray(NUMBERLENGTH)
    val cache = BooleanArray(10)
    var result: Pair<Int, Int>
    var gameStatus = 1
    var tempNum: Int
    for (i in answerArray.indices) {
        do {
            tempNum = Randoms.pickNumberInRange(1, 9)
        } while (cache[tempNum])
        answerArray[i] = tempNum.digitToChar()
        cache[tempNum] = true
    }
    do {
        result = comp(guessInput(), answerArray, cache)
        showResult(result)
    } while(result.first != NUMBERLENGTH)
    println(ASKREPLAYMESSAGE)
    val selectRestart: String = Console.readLine()
    if (selectRestart == RESTARTCODE) {
        gameStatus = 1
    } else if (selectRestart == FINISHCODE) {
        gameStatus = 2
    } else {
        throw IllegalArgumentException(ERRORMESSAGE)
    }
    return gameStatus
}

fun main() {
    //TODO("프로그램 구현")
    var gameStatus = 1
    println(INITALMESSAGE)
    while(gameStatus == 1) {
        gameStatus = game()
    }
}