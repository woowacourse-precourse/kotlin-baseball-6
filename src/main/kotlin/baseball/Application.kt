package baseball

import baseball.program.Program
import baseball.user.User

fun main() {
//    TODO("프로그램 구현")

    val user = User()
    val program = Program()

    while (true) {
        var countOfBall = 0
        var countOfStrike = 0
        var restart = ""
        var isValidInput = false

        println("숫자 야구 게임을 시작합니다.")
        program.setRandomNumber()
        println(program.randomNumber)

        while (countOfStrike != 3) {
            isValidInput = false
            countOfBall = 0
            countOfStrike = 0

            while (!isValidInput) {
                try {
                    print("숫자를 입력해주세요 : ")
                    val input = user.inputRandomNumber()
                    program.checkThreeNumbers(input)
                    program.checkDistinctNumbers(input)
                    program.checkOnlyDigits(input)
                    isValidInput = true
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }

            for (idx in 0..2) {
                if (program.isNumberPresent(user.randomNumber[idx])) {
                    if (program.isSamePlaceSameNumber(user.randomNumber, idx)) {
                        countOfStrike += 1
                    } else {
                        countOfBall += 1
                    }
                }
            }

            program.returnResult(countOfStrike, countOfBall)
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        try {
            restart = user.inputRestartNumber()
            program.checkRestartNumber(restart)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }

        if (restart == "2") break
    }

}
