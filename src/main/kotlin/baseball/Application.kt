package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        startBaseballPlay()
    } while (restartBaseballPlay())

}

fun startBaseballPlay() {

    val computerRandomNum = createComputerRandomNum()

    do {
        val playerAnswer = inputPlayerNum()

        strikeAndBall(computerRandomNum, playerAnswer)

    } while (compareComputerAndPlayer(computerRandomNum, playerAnswer) == 0)
    endBaseballPlay()


}

fun createComputerRandomNum(): String {

    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum.joinToString("")
}

fun inputPlayerNum(): String {

    val playerNum = mutableListOf<Char>()

    print("숫자를 입력해주세요 : ")
    val inputPlayer = Console.readLine()

    if (!isNum(inputPlayer)) {
        throw IllegalArgumentException("잘못된 입력 형식")
    }
    if (inputPlayer.length != 3) {
        throw IllegalArgumentException("잘못된 길이의 입력값 (3자리 수로 입력하세요.)")
    }
    for (index in inputPlayer.indices) {
        if (playerNum.contains(inputPlayer[index])) {
            throw IllegalArgumentException("중복된 숫자가 존재")
        }
        playerNum.add(inputPlayer[index])
    }
    return playerNum.joinToString("")
}

fun compareComputerAndPlayer(computer: String, player: String): Int {
    return if (computer == player) {
        1
    } else {
        0
    }
}

fun strikeAndBall(computer: String, player: String) {
    var strike = 0
    var ball = 0

    for (index in 0..2) {
        if (computer[index] == player[index]) {
            strike++
        } else {
            if (computer.contains(player[index])) {
                ball++
            }
        }
    }

    baseballHint(strike, ball)
}

fun baseballHint(strike: Int, ball: Int) {

    when {
        (strike == 0 && ball == 0) -> println("낫싱")
        (strike != 0 && ball == 0) -> println("${strike}스트라이크")
        (strike == 0 && ball != 0) -> println("${ball}볼")
        (strike != 0 && ball != 0) -> println("${ball}볼 ${strike}스트라이크")
    }
}

fun isNum(inputPlayer: String): Boolean {

    var isNum = true

    inputPlayer.forEach { char ->
        val charConvertToInt = char.digitToIntOrNull()
        val charConvertToCode = char.code
        if (charConvertToCode > 57 || charConvertToCode < 48) {
            isNum = false
            return isNum
        }
        if (charConvertToInt == null) {
            throw IllegalArgumentException("입력값이 존재하지 않습니다.")
            isNum = false
            return isNum
        }
        if (charConvertToInt > 9 || charConvertToInt < 1) {
            throw IllegalArgumentException("입력값 범위가 옳지 않습니다. 1~9범위 사용해주세요")
            isNum = false
            return isNum
        }
    }
    return isNum
}

fun endBaseballPlay() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun restartBaseballPlay(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    val inputPlayerRestart = Console.readLine()
    if (inputPlayerRestart.toInt() == 1) {
        return true
    }
    return false
}
