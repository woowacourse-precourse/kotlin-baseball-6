package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private class Computer {

    val randomNumberList = mutableListOf<Int>()

    init {

        while (randomNumberList.size != 3) {

            val pickNumber = Randoms.pickNumberInRange(1, 9)


            if (randomNumberList.contains(pickNumber)) {

            } else {
                randomNumberList.add(pickNumber)
            }
        }
    }
}

private class Player {

    fun guessNumber(): String {
        val playerNumber = Console.readLine()
        if (playerNumber.length != 3) {

            throw IllegalArgumentException("숫자 입력이 잘못 되어, 게임이 종료 됩니다.")
            // 플레이어번호 사이즈가 3이 아니면 예외 처리
        }
        return playerNumber
    }
}

private class Exception {
    fun hasGameOver() {

        val playerNumber = Player().guessNumber()

        if (playerNumber.length != 3) {

            throw IllegalArgumentException()
            // 플레이어번호 3자리가 아니면 예외 처리
        }

        if (playerNumber.toIntOrNull() == null) {

            throw IllegalArgumentException()
            // 플레이어 번호가 숫자가 아니면 예외 처리
        }

        val numberList = playerNumber.toList().groupBy { it }
        val duplication = numberList.filter { it.value.size > 1 }.values

        if (duplication.isNotEmpty()) {

            throw IllegalArgumentException()
            // 플레이어 번호에 중복된 숫자가 있으면 예외 처리

        }
    }
}


private class Baseball {

    fun playBaseball() {

        println("숫자 야구 게임을 시작합니다.")

        loop@ while (true) {

            val computer = Computer().randomNumberList.joinToString("")

            while (true) {

                print("숫자를 입력해주세요 : ")
                val playerNumber = Player().guessNumber()

                var strikeCnt = 0
                var ballCnt = 0

                for (i in 0..2) {
                    for (j in 0..2) {
                        if (computer[i] == playerNumber[j]) {
                            if (i == j) {
                                strikeCnt++
                            } else {
                                ballCnt++
                            }
                        }
                    }
                }

                if (strikeCnt == 3) {

                    println("${strikeCnt}스트라이크")
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

                    break

                } else if (strikeCnt != 0 && ballCnt != 0) {

                    println("${ballCnt}볼 ${strikeCnt}스트라이크")

                } else if (strikeCnt == 0 && ballCnt == 0) {

                    println("낫싱")

                } else if (strikeCnt != 0) {

                    println("${strikeCnt}스트라이크")

                } else {

                    println("${ballCnt}볼")
                }

            }

            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
            val newGameInput = Console.readLine().toIntOrNull()
            if (newGameInput == 1) {
                continue@loop
            } else break
        }
    }
}


fun main() {

    Baseball().playBaseball()

}
