package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        print("숫자를 입력해주세요 : ")
        val userNum = Console.readLine()
        val userArr = mutableListOf<Int>()

        if (userNum?.length != 3) throw IllegalArgumentException()
        for (i in userNum) {
            if (!i.isDigit() || userArr.contains(i.digitToInt())) throw IllegalArgumentException()
            userArr.add(i.digitToInt())
        }

        val comArr = getComputerNum()




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
        if (com.contains(rand)) com.add(rand)
    }
    return com
}
