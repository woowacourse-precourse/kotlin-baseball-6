package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        val comArr = getComputerNum()
        while (true) {
            print("숫자를 입력해주세요 : ")
            val userNum = Console.readLine()
            val userArr = mutableListOf<Int>()

            if (userNum?.length != 3) throw IllegalArgumentException()
            for (i in userNum) {
                if (!i.isDigit() || userArr.contains(i.digitToInt()) || i == '0') throw IllegalArgumentException()
                userArr.add(i.digitToInt())
            }

            val result = playGame(userArr, comArr)
            println(result)
            if (result == "3스트라이크") break
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val again = Console.readLine()
        if (again == "1") continue
        else if (again == "2") break
        else throw IllegalArgumentException()
    }
    Console.close()

}

fun getComputerNum(): MutableList<Int> {
    val com = mutableListOf<Int>()
    while (com.size < 3) {
        val rand = Randoms.pickNumberInRange(1, 9)
        if (!com.contains(rand)) com.add(rand)
    }
    return com
}

fun playGame(user: List<Int>, com: List<Int>): String {
    var ball = 0
    var strike = 0
    for (i in 0..2) {
        if (com.contains(user[i])) {
            if (com[i] == user[i]) strike++
            else ball++
        }
    }
    var result = ""
    if (ball > 0) result += "${ball}볼"
    if (ball > 0 && strike > 0) result += " "
    if (strike > 0) result += "${strike}스트라이크"
    if (ball == 0 && strike == 0) result = "낫싱"
    return result
}
