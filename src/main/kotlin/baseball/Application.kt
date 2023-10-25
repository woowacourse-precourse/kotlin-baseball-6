package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("프로그램을 시작하려면 Enter 키를 눌러주세요.")
    readLine()
    println("숫자야구게임을 시작합니다.")

    val randomArray = generateRandomArray()

    do {
        val userArray = getUserInputArray()

        val (strikes, balls) = compareArrays(randomArray, userArray)

        if (strikes == 3) {
            println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        } else if (strikes > 0 || balls > 0) {
            println("$strikes 스트라이크, $balls 볼")
        } else {
            println("낫싱")
        }
    } while (strikes < 3)


    var playAgain: Boolean
    do {
        playAgain = askToPlayAgain()
    } while (playAgain)

    println("게임 종료. 감사합니다!")
}

fun generateRandomArray(): IntArray {
    return IntArray(3) { Randoms.pickNumberInRange(1, 9) }
}

fun getUserInputArray(): IntArray {
    val userArray = IntArray(3)

    println("1에서 9까지의 서로 다른 세 자리 숫자를 입력하세요. ")
    var userInput = readLine() ?: ""

    while (userInput.length != 3 || !userInput.all { it.isDigit() } || userInput.toSet().size != 3) {
        println("유효하지 않은 입력입니다. 서로 다른 세 자리 숫자를 다시 입력하세요.")
        userInput = readLine() ?: ""
    }

    for (i in 0 until 3) {
        userArray[i] = userInput[i].toString().toInt()
    }

    if (userArray.any { it < 1 || it > 9 }) {
        throw IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.")
    }

    return userArray
}

fun compareArrays(randomArray: IntArray, userArray: IntArray): Pair<Int, Int> {
    var strikes = 0
    var balls = 0

    for (i in 0 until 3) {
        if (randomArray[i] == userArray[i]) {
            strikes++
        } else if (randomArray.contains(userArray[i])) {
            balls++
        }
    }

    return Pair(strikes, balls)
}

fun askToPlayAgain(): Boolean {
    println("게임을 다시 시작하려면 1, 게임을 종료하려면 2를 입력하세요.")
    val input = readLine() ?: ""
    return input == "1"
}
