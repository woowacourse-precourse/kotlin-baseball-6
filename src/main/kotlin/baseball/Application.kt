import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        val targetNumber = generateTargetNumber()
        var attempts = 0

        while (true) {
            val inputNumber = InputNumber()
            val result = calculateResult(targetNumber, inputNumber)
            Console.print(result)

            if (result == "3스트라이크") {
                Console.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }

            attempts++
        }

        val choice = restartGame()
        if (choice == 2) {
            Console.println("게임을 종료합니다.")
            break
        }
    }
}

private fun generateTargetNumber(): List<Int> {
    val numbers = Randoms.pickNumberInRange(1, 9, 3)
    return numbers
}

private fun InputNumber(): List<Int> {
    while (true) {
        Console.print("숫자를 입력해주세요 : ")
        val input = Console.readLine()

        if (input.length != 3 || input.any { !it.isDigit() }) {
            Console.println("잘못된 값을 입력했습니다. 다시 입력하세요.")
        } else {
            return input.map { it.toString().toInt() }
        }
    }
}

private fun calculateResult(targetNumber: List<Int>, inputNumber: List<Int>): String {
    var strikes = 0
    var balls = 0

    for (i in 0 until 3) {
        if (targetNumber[i] == inputNumber[i]) {
            strikes++
        } else if (targetNumber.contains(inputNumber[i])) {
            balls++
        }
    }

    return when {
        strikes == 3 -> "3스트라이크"
        strikes > 0 || balls > 0 -> "${balls}볼 ${strikes}스트라이크"
        else -> "낫싱"
    }
}

private fun restartGame(): Int {
    while (true) {
        Console.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
        val choice = Console.readLine().toIntOrNull()
        if (choice == 1 || choice == 2) {
            return choice!!
        } else {
            Console.println("잘못된 선택입니다. 다시 입력하세요.")
        }
    }
}
