package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var S = 1
    var T = 1
    while (T == 1) {
        val computer = generateRandomNumber()


        while (S == 1) {
            val input = getUserInput()
            val (st, ball) = compare(input, computer)
            printScore(st, ball)

            if (st == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                S = 0
            }


        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val newgame = Console.readLine()?.toInt() ?: 0
        if(newgame == 1){
            S = 1
        }
        if (newgame == 2) {
            println("게임 종료")
            T = 0
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
    println("숫자를 입력해주세요: ")
    val input = Console.readLine()
    val inputArray = input.toCharArray().map { it.toString().toIntOrNull() }

    return inputArray.requireValidInput()
}

fun compare(inputArray: List<Int>, computer: List<Int>): Pair<Int, Int> {
    var st = 0
    var ball = 0

    for (i in inputArray.indices) {
        if (inputArray[i] == computer[i]) {
            st++
        } else if (inputArray[i] in computer) {
            ball++
        }
    }

    return st to ball
}

fun List<Int?>.requireValidInput(): List<Int> {
    val validInput = this.filterNotNull()
    if (validInput.size == 3 && validInput.all { it in 1..9 } && validInput.toSet().size == 3) {
        return validInput.mapNotNull { it }
    }
    throw IllegalArgumentException("1부터 9 사이의 서로 다른 숫자 3개를 입력하세요.")
}

fun printScore(st: Int, ball: Int) {
    if (ball > 0 && st > 0) {
        print(ball.toString() + "볼 " + st.toString() + "스트라이크")
    } else if (ball > 0) {
        print(ball.toString() + "볼")
    } else if (st > 0) {
        print(st.toString() + "스트라이크")
    }


    if (st == 0 && ball == 0) {
        print("낫싱")
    }
    println()
}
