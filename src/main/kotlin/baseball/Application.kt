package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    // A. 컴퓨터는 사용자가 맞힐 정답을 생성한다.
    val answer = mutableListOf<Int>()
    while (answer.size < 3) {
        val randomNum = pickNumberInRange(1, 9)
        if (!answer.contains(randomNum)) {
            answer.add(randomNum)
        }
    }
    println(answer)
    while (true) {
        var ballCnt = 0
        var strikeCnt = 0

        // B: 사용자의 수를 입력받는다.
        print("숫자를 입력해주세요 : ")
        val input = readLine()

        // B-2 유효성 검증
        if (input.length != 3) {
            throw IllegalArgumentException("입력한 수가 3자리가 아닙니다.")
        }
        if (input.contains("""[^123456789]""".toRegex())) {
            throw IllegalArgumentException("유효하지 않은 형식입니다.")
        }

        val numSet = input.toCharArray().toSet()
        if (numSet.size < 3) {
            throw IllegalArgumentException("중복된 수를 가집니다.")
        }

        // C: 정답과 사용자의 입력을 비교해서 결과를 리턴받는다.
        for (i in 0..2) {
            if (answer.contains(input[i] - '0')) {
                ballCnt++
            }
            if (input[i] - '0' == answer[i]) {
                strikeCnt++
            }
        }
        ballCnt -= strikeCnt

        // C-2 모두 맞히지 못했을 경우
        if (ballCnt == 0 && strikeCnt == 0) {
            println("낫싱")
        } else if (strikeCnt == 0) {
            println("${ballCnt}볼")
        } else if (ballCnt == 0) {
            println("${strikeCnt}스트라이크")
        } else {
            println("${ballCnt}볼 ${strikeCnt}스트라이크")
        }

        // C-1 모두 맞힌 경우
        if (strikeCnt == 3) {
            println("""3개의 숫자를 모두 맞히셨습니다! 게임 종료
                |게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
            """.trimMargin())

            when (readLine().toIntOrNull()) {
                1 -> {
                    answer.clear()
                    while (answer.size < 3) {
                        val randomNum = pickNumberInRange(1, 9)
                        if (!answer.contains(randomNum)) {
                            answer.add(randomNum)
                        }
                    }
                    println(answer)
                    continue
                }

                2 -> break
                else -> throw IllegalArgumentException("유효하지 않은 형식입니다.")
            }

        }
    }
}
