package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame {
    fun baseballGame(): String {
        val makeQuestion = MakeQuestion()
        val question = makeQuestion.makeThreeNumbers()
        do {
            print("숫자를 입력해주세요 : ")
            val answer: String = Console.readLine()
            if (answer.length != 3){
                throw IllegalArgumentException("3자리 숫자를 입력해야 합니다.")
            }
            if (answer.toSet().size != 3){
                throw IllegalArgumentException("각 자리의 숫자는 중복이 없어야 합니다.")
            }
            if (answer.contains("0")){
                throw IllegalArgumentException("입력한 숫자에 0이 있으면 안됩니다.")
            }

            var ballCnt = 0
            var strikeCnt = 0

            for (i in 0..2) {
                if (question.contains(answer[i])) {
                    if (answer[i] == question[i]) {
                        strikeCnt++
                    } else if (answer[i] != question[i]) {
                        ballCnt++
                    }
                }
            }
            if (strikeCnt == 0 && ballCnt == 0) {
                println("낫싱")
            }
            if (strikeCnt != 0 || ballCnt != 0) {
                println("${ballCnt}볼 ${strikeCnt}스트라이크")
            }
        } while (strikeCnt != 3)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        val restart = Console.readLine()
        if (restart != "1" && restart != "2"){
            throw IllegalArgumentException("1또는 2만 입력해야 합니다!")
        }
        return restart
    }
}