package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        print("숫자를 입력해주세요 : ")
        val userNum = Console.readLine()
        val userArr = mutableListOf<Int>()


        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val again = Console.readLine()
        if (again == "1") continue
        else if (again == "2") break
//        else
    }
    Console.close()

}

fun getComputerNum(): MutableList<Int> {
    val computer = mutableListOf<Int>()

}
