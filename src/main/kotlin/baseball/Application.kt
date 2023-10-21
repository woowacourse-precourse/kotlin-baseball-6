package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        startBaseballGame()
    } while (isRestartable())
}

fun startBaseballGame() {
    val answer = creatRandomNumberList()
//    println(answer) // 랜덤 생성된 정답 미리보기
    while (true) {
        val user = getUserInput()
        if (user == answer) {
            println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
        countScore(answer, user)
    }
}

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
    print("숫자를 입력해주세요 : ")
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
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
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

    if (!userInput.all { it.isDigit() }) throw IllegalArgumentException("숫자만 입력하세요")
    if (userInput.length != 3) throw IllegalArgumentException("3자리 수를 입력하세요")
    if (userInput.toSet().size != userInput.length) throw IllegalArgumentException("각기 다른 3개의 숫자를 입력하세요")
}