package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {

    var playAgain = true

    while (playAgain) {

        println("숫자 야구 게임을 시작합니다.")
        val answer = generateRandomNumber()

        var isGameWon = false

        while (!isGameWon) {

            print("숫자를 입력해주세요 : ")

            val guess = Console.readLine()

            if (guess != null && guess.length == 3 && guess.all { it.isDigit() } && hasDuplicateDigits(guess)) {

                val result = getResult(sortStringAscending(guess), answer)

                println(result)

                if (result == "3스트라이크") {

                    isGameWon = true
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

                }

            } else {
                throw IllegalArgumentException("삐빅! 잘못된 입력입니다.")
            }//예외처리

        }


        do{

            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val choice = Console.readLine()
            playAgain = choice == "1"

        }while(choice == "1" || choice == "2")



    }


}

private fun hasDuplicateDigits(input: String): Boolean {
    val digits = input.toList()
    return digits.toSet().size != digits.size
}

private fun sortStringAscending(input: String): String {
    return input.toList().sorted().joinToString("")
}



private fun generateRandomNumber(): String {

    var number1: String
    var number2: String
    var number3: String

    do {
        number1 = Randoms.pickNumberInRange(0, 9).toString()
        number2 = Randoms.pickNumberInRange(0, 9).toString()
        number3 = Randoms.pickNumberInRange(0, 9).toString()
    } while (hasDuplicate(listOf(number1, number2, number3)))

    return sortAndConcatenateNumbers(number1, number2, number3)
}


private fun sortAndConcatenateNumbers(number1: String, number2: String, number3: String) = listOf(number1, number2, number3).sorted().joinToString("")

private fun hasDuplicate(numbers : List<String>) = numbers.toSet().size != numbers.size


private fun getResult(guess: String, answer: String) : String {

    var strikes = 0
    var balls = 0

    for ((guessDigit, answerDigit) in guess.zip(answer)) {
        if (guessDigit == answerDigit) {
            strikes++
        } else if (guessDigit in answer) {
            balls++
        }
    }

    val strikesText = if (strikes > 0)  "$strikes"+"스트라이크" else ""
    val ballsText = if (balls > 0) "$balls"+"볼 " else ""
    return if (strikes == 0 && balls == 0) "낫싱" else "$ballsText$strikesText"

}




