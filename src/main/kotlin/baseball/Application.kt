package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        startGame()
    } while (restartGame())
}

fun startGame() {
    val computer = setComputerNumber()
    var strike: Int
    var ball: Int
    while (true) {
        print("숫자를 입력해주세요 : ")
        val people = (readLine() ?: "").map { it.toString().toInt() }
        val set = HashSet<Int>(people)
        if (people.size != 3 || set.size < people.size) throw IllegalArgumentException()
        for (num in people) if (num !in 1..9) throw IllegalArgumentException()
        val total = countTotal(computer, people)
        strike = countStrike(computer, people)
        ball = (total - strike)
        if (strike == 3) {
            println("${strike}스트라이크")
            return
        }
        if (strike != 0 && ball != 0) println("${ball}볼 ${strike}스트라이크")
        if (strike == 0 && ball != 0) println("${ball}볼")
        if (ball == 0 && strike != 0) println("${strike}스트라이크")
        if (total == 0) {
            println("낫싱")
        }
    }
}

fun restartGame(): Boolean {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val restart = readLine()!!.toInt()
    if (restart != 1 && restart != 2) {
        throw IllegalArgumentException()
    }
    if (restart == 1) {
        return true
    }
    return false
}

fun setComputerNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer




}

fun countTotal(computer: MutableList<Int>, people: List<Int>): Int {
    var count = 0
    for (num in people) {
        if (num in computer) {
            count += 1
        }


    }
    return count
}

fun countStrike(computer: MutableList<Int>, people: List<Int>): Int {
    var strike = 0
    for (i in 0..2) {
        if (computer[i] == people[i]) {
            strike += 1
        }


    }
    return strike
}