package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        val computer = computerNumbers()
        playGame(computer)
        do {
            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
            val userInput = Console.readLine()
            if (userInput == "1" || userInput == "2") {
                if (userInput == "2") return
                break
            } else {
                throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
            }
        } while (true)
    } while (true)
}
fun computerNumbers(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun playGame(computer: List<Int>) {
    while (true) {
        print("숫자를 입력해주세요 : ")
        val userInput = Console.readLine().orEmpty()

        // 입력값이 없는 경우
        if (userInput.isEmpty()) {
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
        }
        val userGuess = try {
            userInput.map { it.toString().toInt() }
        } catch (e: NumberFormatException) {
            // 입력값이 숫자가 아닌 경우
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
        }
        // 입력값의 길이, 중복, 1~9 범위 검사
        if (userGuess.size != 3 || userGuess.toSet().size != 3 || userGuess.any { it < 1 || it > 9 }) {
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
        }
        val result = ballStatus (computer, userGuess)
        if (result == "3스트라이크") {
            println(result)
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return
        }
        println(result)
    }
}
fun ballStatus (computer: List<Int>, userGuess: List<Int>): String {
    var strikes = 0
    var balls = 0

    for (i in userGuess.indices) {
        if (userGuess[i] == computer[i]) {
            strikes++
        } else if (computer.contains(userGuess[i])) {
            balls++
        }
    }
    if (strikes == 0 && balls == 0) return "낫싱"
    return "${if (balls > 0) "${balls}볼 " else ""}${if (strikes > 0) "${strikes}스트라이크" else ""}".trim()
}
