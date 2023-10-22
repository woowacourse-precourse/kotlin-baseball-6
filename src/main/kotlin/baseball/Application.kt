package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerList = mutableListOf<Int>()
    while (computerList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (randomNumber !in computerList) {
            computerList.add(randomNumber)
        }
    }

    val playerList = mutableListOf<Int>()
    var playerString: String?

    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        print("숫자를 입력해주세요 : ")
        playerString = Console.readLine()
        playerString?.let {

            // 세자리가 아닌 예외
            if (it.length != 3) throw IllegalArgumentException()
            for (index in it.indices) {
                // 숫자가 아닌 예외
                if (it[index] < '1' || it[index] > '9') throw IllegalArgumentException()
                // 숫자가 중복된 예외
                if (playerList.contains(it[index] - '0')) throw IllegalArgumentException()
                // 정수 리스트에 넣어주기
                playerList.add(it[index] - '0')
            }
        } ?: throw IllegalArgumentException() // null인 예외


    }
}


