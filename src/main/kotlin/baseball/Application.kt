package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var isPlaying = true
    while (isPlaying) {
        val computer = initComputerNumber()
        var isRound = true
        while (isRound) {
            val player = inputNumber()
            val result = checkResult(computer, player)

            isRound = printResult(result)
        }

        isPlaying = inputRestart()
    }
}

fun inputRestart(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    val restart = readlnOrNull()!!.toInt()
    return when (restart) {
        2 -> {
            false
        }

        1 -> {
            true
        }

        else -> {
            throw IllegalArgumentException()
        }
    }
}

fun printResult(result: IntArray): Boolean {
    if (result[1] > 0) {
        print("${result[1]}볼 ")
    }

    if (result[0] > 0) {
        print("${result[0]}스트라이크")
        if (result[0] == 3) {
            println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return false
        }
    }

    if (result[0] == 0 && result[1] == 0) {
        print("낫싱")
    }

    println()

    return true
}

fun inputNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")

    val player = mutableListOf<Int>()
    val input = readlnOrNull()!!
    if (input.length != 3) {
        throw IllegalArgumentException()
    }

    if (Regex("[1-9]+").matches(input)) {
        for (c in input) {
            val i = c.digitToInt()
            if (player.contains(i)) {
                throw IllegalArgumentException()
            } else {
                player.add(c.digitToInt())
            }
        }
    } else {
        throw IllegalArgumentException()
    }

    return player
}

fun checkResult(computer: MutableList<Int>, player: MutableList<Int>): IntArray {
    var strike = 0
    var ball = 0
    for (i in player.indices) {
        val c = computer[i]
        val p = player[i]
        if (c == p) {
            strike++
        } else if (computer.contains(p)) {
            ball++
        }
    }

    return intArrayOf(strike, ball)
}

fun initComputerNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}