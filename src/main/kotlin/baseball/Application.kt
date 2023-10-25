package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun generateRandomNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
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
fun calculateHint(secret: String, guess: String): Pair<Int, Int> {
    var ball = 0
    var strike = 0

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            strike++
            continue
        }
        if (secret.contains(guess[i])) {
            ball++
        }
    }
    return strike to ball
}


fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var playAgain = true

    while (playAgain) {
        val randomNumber by lazy {
            generateRandomNumber()
        }

        while (true) {
            val userGuess = getUserNumber()
            val (strikes, balls) = calculateHint(randomNumber, userGuess)

            if (balls == 0 && strikes == 0) {
                print("낫싱")
            }
            if (balls != 0) {
                print("${balls}볼 ")
            }
            if (strikes != 0) {
                print("${strikes}스트라이크 ")
            }
            println()

            if (strikes == 3) {
                break
            }
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val restartInput = Console.readLine().toInt()
        val isRestart = validateRestartValue(restartInput)
        if (!isRestart) return
    }
}

fun validateRestartValue(restartInput: Int) : Boolean {
    if(restartInput != 1 && restartInput != 2) throw IllegalArgumentException("1이나 2만 입력해주세요.")
    if(restartInput == 2){
        return false
    }
    return true
}