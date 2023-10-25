package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        val computer = generateRandomNumber()
        var attempts = 0

        while (true) {
            val userInput = getUserInput()
            val result = checkGuess(computer, userInput)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
            attempts++
        }

        if (!playAgain()) {
            break
        }
    }
}
    
fun generateRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserInput(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    return input.map { it.toString().toInt() }
}

fun checkGuess(computer: List<Int>, userInput: List<Int>): String {
    var strikes = 0
    var balls = 0

    for (i in computer.indices) {
        if (computer[i] == userInput[i]) {
            strikes++
        } else if (userInput.contains(computer[i])) {
            balls++
        }
    }

    return when {
        strikes > 0 && balls > 0 -> "$balls볼 $strikes스트라이크"
        strikes > 0 -> "$strikes스트라이크"
        balls > 0 -> "$balls볼"
        else -> "낫싱"
    }
}

fun playAgain(): Boolean {
    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = Console.readLine().toInt()
    if (choice == 1) {
        return true
    } else if (choice == 2) {
        return false
    } else {
        throw IllegalArgumentException("잘못된 값을 입력하셨습니다. 프로그램을 종료합니다.")
    }
}
