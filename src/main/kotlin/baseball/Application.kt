package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    val computer = mutableListOf<Int>()
    generateRandomNumber(computer)

    val player = mutableListOf<Int>()
    getPlayerNumber(player)
}

private fun getPlayerNumber(player: MutableList<Int>) {
    print("숫자를 입력해주세요 : ")
    val input = readlnOrNull()
    if (input.isNullOrBlank()) {
        throw IllegalArgumentException()
    }
    if (input.length != 3) {
        throw IllegalArgumentException()
    }
    var intInput = try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }

    while (player.size < 3) {
        val currentNum = intInput % 10
        if (currentNum == 0) {
            throw IllegalArgumentException()
        }
        if (player.contains(currentNum)) {
            throw IllegalArgumentException()
        }
        player.add(currentNum)
        intInput /= 10
    }
    player.reverse()
}

private fun generateRandomNumber(computer: MutableList<Int>) {
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}