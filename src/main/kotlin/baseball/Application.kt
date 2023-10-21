package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val resultMap = mutableMapOf<String, Int>()
    val BALL = "볼"
    val STRIKE = "스트라이크"
    var finishSignal = "1"
    println("숫자 야구 게임을 시작합니다.")
    val baseBallCreator = BaseBallCreator()
    while (true) {
        val answerBaseBalls = baseBallCreator.createAnswerBalls()

        do {
            print("숫자를 입력해주세요 : ")

            val input = runCatching {
                Console.readLine().trim().map { it.toString().toInt() }
            }.getOrNull()
                ?: run {
                    throw IllegalArgumentException()
                }

            // valid 검증
            if (BaseBallsValidator().validate(input).not()) throw IllegalArgumentException()

            // 이제 숫자 비교
            input.indices.forEach { idx ->
                val num = input[idx]
                if (answerBaseBalls[idx] == num) {
                    resultMap += STRIKE to resultMap.getOrDefault(STRIKE, 0) + 1
                    return@forEach
                }
                if (num in answerBaseBalls) {
                    resultMap += BALL to resultMap.getOrDefault(BALL, 0) + 1
                }
            }
            if (resultMap.getOrDefault(STRIKE, 0) + resultMap.getOrDefault(BALL, 0) == 0) {
                println("낫싱")
                continue
            }
            val res = run {
                var str = ""
                val strikeCnt = resultMap.getOrDefault(STRIKE, 0)
                val ballCnt = resultMap.getOrDefault(BALL, 0)
                if (ballCnt > 0) str += "${ballCnt}볼 "
                if (strikeCnt > 0) str += "${strikeCnt}스트라이크"
                str
            }
            println(res)
            resultMap.clear()
        } while (answerBaseBalls != input)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        finishSignal = runCatching {
            Console.readLine().trim()
        }.getOrNull()
            ?: run {
                throw IllegalArgumentException()
            }
        if (finishSignal == "1") continue
        if (finishSignal == "2") return
        throw IllegalArgumentException()
    }
}
