package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
//    TODO("프로그램 구현")
    val computer = mutableListOf<Int>()
    val player = mutableListOf<Int>()

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        createRandomList(computer)

        print("숫자를 입력해 주세요 : ")

        val input = readLine()
        checkUserInput(input)

        player.clear()

        for (char in input.orEmpty()) {
            if (char.isDigit()) {
                player.add(char.toString().toInt())
            }
        }

        val (strike, ball) = compareList(computer, player)
        val print = printResult(strike, ball)
        println(print)

        if (strike == 3){
            println("3개의 숫자를 모두 맞히셨습니다! 게임종료")
            computer.clear()
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val isContinue = readLine()?.toInt() ?: 2
            if(isContinue == 2){
                println("게임 종료")
                break
            }
        } else {
            player.clear()
        }

    }

}

fun createRandomList(computer: MutableList<Int>): MutableList<Int> {
    while (computer.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNum)) {
            computer.add(randomNum)
        }
    }
    return computer
}

fun checkUserInput(input: String?) {
    if (input == null || input.length != 3) {
        throw IllegalArgumentException("올바른 입력이 아닙니다.")
    }
}

fun compareList(computer : MutableList<Int>, player: MutableList<Int> ): Pair<Int, Int>{
    var strike = 0
    var ball = 0

    for( i in computer.indices) {
        if (computer[i] == player[i]) {
            strike++
        } else if (player.contains(computer[i])) {
            ball++
        }
    }

    return Pair(strike, ball)
}

fun printResult(strike: Int, ball: Int): String {
    val result = mutableListOf<String>()

    if (ball > 0) {
        result.add("${ball}볼")
    }
    if (strike > 0) {
        result.add("${strike}스트라이크")
    }

    if (result.isEmpty()) {
        result.add("낫싱")
    }

    return result.joinToString(" ")
}