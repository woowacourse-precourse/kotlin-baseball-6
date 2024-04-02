package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {

    var playAgain = true

    while (playAgain) {

        println("숫자 야구 게임을 시작합니다.")

        val answer = generateRandomNumber()
        // println(answer)
        var isGameWon = false

        while (!isGameWon) {

            print("숫자를 입력해주세요 : ")
            val guess = Console.readLine()

            //guess.all { it.isDigit() } -> 사용자가 입력한 문자가 모두 숫자인지를 확인하는 코틀린의 내장 함수

            if (guess != null && guess.length == 3 && guess.all { it.isDigit() }) {

                val result = getResult(guess, answer)
                println(result)

                if (result == "3스트라이크") {

                    isGameWon = true
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

                }

            } else {

                throw IllegalArgumentException("")

            }//예외처리



        }

        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val choice = Console.readLine()
        playAgain = choice == "1"


    }


}


fun generateRandomNumber(): String {

    val number1 = Randoms.pickNumberInRange(0,9).toString()
    var number2: String
    var number3: String

    do {
        number2 = Randoms.pickNumberInRange(0, 9).toString()
    } while (number2 == number1)

    do {
        number3 = Randoms.pickNumberInRange(0, 9).toString()
    } while (number3 == number1 || number3 == number2)

    return "$number1$number2$number3"


} //서로 다른 3자리수 구현

fun getResult(guess: String, answer: String): String {

    var strikes = 0
    var balls = 0

    for (i in guess.indices) {

        if (guess[i] == answer[i]) {
            strikes++
        } else if (guess[i] in answer) {
            balls++;
        }

    }

    val strikesText = if (strikes > 0)  "$strikes"+"스트라이크" else ""
    val ballsText = if (balls > 0) "$balls"+"볼 " else ""
    return if (strikes == 0 && balls == 0) "낫싱" else "$ballsText$strikesText"


}




