package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var playAgain = true

    println("숫자 야구 게임을 시작합니다.")

    while (playAgain) {
        val computerNumber = generateRandomNumber()

        while (true) {
            print("숫자를 입력해주세요 : ")

            val userInput = readLine()

            try {
                val userGuess = userInput?.toInt()

                if (userGuess == null || !input(userGuess)) {
                    throw IllegalArgumentException()
                } else {
                    val result = checkGuess(userGuess, computerNumber)

                    if (result == 30) {
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        break
                    } else {
                        displayResult(result)
                        if (result == 0) {
                            println("낫싱")
                        }
                    }
                }
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException()
            }
        }

        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
        val choice = readLine()
        if (choice == "2") {
            println("게임을 종료합니다.")
            playAgain = false
        } else if (choice != "1") {
            println("올바른 선택이 아닙니다. 게임을 종료합니다.")
            playAgain = false
        }
    }
}

fun generateRandomNumber(): Int {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    val result = computer[0] * 100 + computer[1] * 10 + computer[2]
    return result
}


fun size(num: Int): Boolean {
    val digits = num.toString().toSet()
    return digits.size == 3
}

fun input(num: Int): Boolean {
    return num in 100..999 && size(num)
}

fun checkGuess(userGuess: Int, computerNumber: Int): Int {
    val userDigits = userGuess.toString().toCharArray()
    val computerDigits = computerNumber.toString().toCharArray()

    var strikes = 0
    var balls = 0

    for (i in 0 until 3) {
        if (userDigits[i] == computerDigits[i]) {
            strikes += 1
        } else if (computerDigits.contains(userDigits[i])) {
            balls += 1
        }
    }

    return strikes * 10 + balls
}

fun displayResult(result: Int) {
    val strikes = result / 10
    val balls = result % 10
    if (strikes > 0 && balls > 0) {
        println("$strikes 스트라이크 $balls 볼")
    } else if (strikes > 0) {
        println("$strikes 스트라이크")
    } else if (balls > 0) {
        println("$balls 볼")
    }
}
