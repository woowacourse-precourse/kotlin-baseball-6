package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGameMessage()
    do {
        onGame()
    } while (isRestart())
}

fun onGame() {
    val computerNumber = generationNumber()
    do {
        val userNumber = getUserNumber()
        val isEndGame = gameResults(computerNumber, userNumber)
    } while (!isEndGame)
}


fun generationNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

fun startGameMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun getUserNumber(): String {
    print("숫자를 입력해주세요 : ")
    val userNumber = Console.readLine()
    validateUserValue(userNumber)
    return userNumber
}

fun validateUserValue(userNumber: String) {
    if (userNumber.length != 3) throw IllegalArgumentException("3자리의 수만 입력할 수 있습니다.")
    if (userNumber.toList().distinct().size != 3) throw IllegalArgumentException("숫자를 중복하여 쓸 수 없습니다.")
    for (i in userNumber) {
        if (i < '1' || i > '9') throw IllegalArgumentException("1~9사이의 숫자만 입력할 수 있습니다.")
    }
}

fun gameResults(computer: String, user: String): Boolean {
    var ball = 0
    var strike = 0

    for (i in computer.indices) {
        if (computer[i] == user[i]) {
            strike++
            continue
        }
        if (computer.contains(user[i])) {
            ball++
        }
    }

    if (ball == 0 && strike == 0) {
        print("낫싱")
    }
    if (ball != 0) {
        print("${ball}볼 ")
    }
    if (strike != 0) {
        print("${strike}스트라이크")
    }
    println()
    return strike == 3
}

fun isRestart(): Boolean {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val restartInput = Console.readLine().toInt()
    validateRestartValue(restartInput)
    return restartInput == 1
}

fun validateRestartValue(restartInput: Int) {
    if(restartInput != 1 && restartInput != 2) throw IllegalArgumentException("1이나 2만 입력해주세요.")
}