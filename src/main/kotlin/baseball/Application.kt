package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    println("숫자 야구 게임을 시작합니다.\n")
    var computer = generateComputerNumbers()

    while (true) {

            playGame(computer)

            val choice = Console.readLine()?.toIntOrNull()
            if (choice == 2) {
                println("게임을 종료합니다.")
                return
            } else if (choice == 1) {
                val newcomputer = generateComputerNumbers()
                computer = newcomputer
                continue

            } else {
                throw IllegalArgumentException()
            }

    }
}

fun generateComputerNumbers():List<Int> {
    var computer = mutableListOf(Randoms.pickNumberInRange(1,9))
    while(computer.size<3){
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun playGame(computer: List<Int>) {
    var gamewon = true
    while (gamewon) {
        print("숫자를 입력해주세요 : ")
        var strike = 0
        var ball = 0
        val input = Console.readLine()

        if (input == null || input.length != 3 || !input.all { it.isDigit() }) {
            throw IllegalArgumentException()
        }

        val n = input.map { it.toString().toInt() }

//        computer.forEach { print("$it") }

        computer.forEachIndexed() { i, x ->
            n.forEachIndexed() { j, y ->
                if (x == y) {
                    if (i == j) {
                        strike++
                    } else {
                        ball++
                    }
                }
            }
        }

        when {
            strike == 0 && ball != 0 -> {
                println("${ball}볼")
            }

            strike != 0 && ball == 0 -> {
                println("${strike}스트라이크")
                if (strike == 3 ){
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    gamewon = false
                }
            }

            strike > 0 && ball > 0 -> {
                println("${ball}볼 ${strike}스트라이크")
            }

            strike == 0 && ball == 0 -> {
                println("낫싱")
            }

            }
        }
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

}

