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
    println("정답 : ${computerList.toString()}")

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


        // 게임 결과 분기
        if (!compareList(computerList, playerList)) {
            // 정답을 못찾았다. 계속해서 맞추기
            playerList.clear()
            continue
        } else {
            // 3 스트라이크. 게임 끝.
            return
        }
    }
}

// 게임 결과 처리 함수
fun compareList(computerList: List<Int>, playerList: List<Int>): Boolean {
    val strikes = computerList.zip(playerList).count { (comp, player) -> comp == player }
    val balls = playerList.count { it in computerList }
    val result = when {
        strikes > 0 -> "$strikes 스트라이크"
        balls > 0 -> "$balls 볼"
        else -> "낫싱"
    }
    println(result)
    return strikes == 3
}






