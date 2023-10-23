package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val SUCCESS_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val INVALID_INPUT_MESSAGE = "숫자만 입력하세요"
const val INVALID_LENGTH_MESSAGE = "3자리 수를 입력하세요"
const val DUPLICATE_NUMBER_MESSAGE = "각기 다른 3개의 숫자를 입력하세요"
fun main() {
    println(START_MESSAGE)
    do {
        startBaseballGame()
    } while (isRestartable())
}

fun startBaseballGame() {
    val answer = creatRandomNumberList()
    println(answer) // 랜덤 생성된 정답 미리보기
    do {
        val user = getUserInput()
        countScore(answer, user)
    } while (!isSame(answer, user))
    println(SUCCESS_MESSAGE)
}

fun isSame(answer: List<Int>, user: List<Int>) = answer == user


fun creatRandomNumberList(): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber))
            numbers.add(randomNumber)
    }
    return numbers
}

fun getUserInput(): MutableList<Int> {
    print(INPUT_MESSAGE)
    val userInput = Console.readLine()
    isUserNumberInputValid(userInput)
    var userNumber = userInput.toInt()
    val userNumberList = mutableListOf<Int>()
    repeat(3) {
        userNumberList.add(0, userNumber % 10)
        userNumber /= 10
    }
    return userNumberList
}

fun isRestartable(): Boolean {
    println(RESTART_MESSAGE)
    val restartChar = Console.readLine()
    return ("1" == restartChar)
}

fun countScore(answer: List<Int>, user: List<Int>) {
    var strikeCount = 0
    var ballCount = 0
    repeat(3) {
        if (user[it] == answer[it]) strikeCount++
        else if (answer.contains(user[it])) ballCount++
    }
    val strikeMessage = if (0 < strikeCount) "${strikeCount}스트라이크" else ""
    val ballMessage = if (0 < ballCount) "${ballCount}볼 " else ""
    val finalMessage = if (strikeCount == 0 && ballCount == 0) "낫싱" else "$ballMessage$strikeMessage"
    println(finalMessage)
}

fun isUserNumberInputValid(userInput: String) {

    if (!userInput.all { it.isDigit() }) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
    if (userInput.length != 3) throw IllegalArgumentException(INVALID_LENGTH_MESSAGE)
    if (userInput.toSet().size != userInput.length) throw IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE)
}