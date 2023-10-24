package baseball

import baseball.domain.Computer
import baseball.domain.GameLogic
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val computer = Computer()

    do {
        val userNum = userInputNum()
        val game = GameLogic(computer.computerNum, userNum)

        if(game.checkResult()) {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val command = Console.readLine().toInt()
            if(command == 2) break

            computer.updateNumber()
        }
    } while (true)
}


fun userInputNum(): Int {
    print("숫자를 입력하세요: ")
    val input = Console.readLine()

    if (input.length != 3 || !input.all { it.isDigit() }) {
        throw IllegalArgumentException()
    }
    return input.toInt()
}

fun gameRestartOrExit(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val command = Console.readLine().toInt()
    return command != 2
}
