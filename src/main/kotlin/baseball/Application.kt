package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        val computer = mutableListOf<Int>()
        generateRandomNumber(computer)

        do {
            val player = mutableListOf<Int>()
            getPlayerNumber(player)

            val strike = countStrike(computer, player)
            val ball = countBall(computer, player)
            printHint(ball, strike)
        } while (strike < 3)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        when (getRestartOrNot()) {
            1 -> continue
            2 -> break
            else -> throw IllegalArgumentException()
        }
    }
}

private fun getRestartOrNot(): Int {
    val input = readlnOrNull()
    val throwIAE = ThrowIAE()
    throwIAE.checkNullOrBlank(input)

    return throwIAE.checkToInt(input!!)
}

private fun printHint(ball: Int, strike: Int) {
    when {
        ball == 0 && strike == 0 -> {
            println("낫싱")
        }

        ball == 0 && strike != 0 -> {
            println("${strike}스트라이크")
        }

        ball != 0 && strike == 0 -> {
            println("${ball}볼")
        }

        else -> {
            println("${ball}볼 ${strike}스트라이크")
        }
    }
}

private fun countBall(
    computer: MutableList<Int>,
    player: MutableList<Int>
): Int {
    var ball = 0
    for(index in 0 until 3){
        if(computer[index] != player[index] && player.contains(computer[index])){
            ball++
        }
    }
    return ball
}

private fun countStrike(
    computer: MutableList<Int>,
    player: MutableList<Int>
): Int {
    var strike = 0
    for (index in 0 until 3) {
        if (computer[index] == player[index]) {
            strike++
        }
    }
    return strike
}

private fun getPlayerNumber(player: MutableList<Int>) {
    print("숫자를 입력해주세요 : ")
    val input = readlnOrNull()
    val throwIAE = ThrowIAE()
    throwIAE.checkNullOrBlank(input)
    throwIAE.checkLength(input!!, 3)
    var intInput = throwIAE.checkToInt(input)

    while (player.size < 3) {
        val currentNum = intInput % 10
        throwIAE.checkNumZero(currentNum)
        throwIAE.checkElemDuplication(player, currentNum)
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