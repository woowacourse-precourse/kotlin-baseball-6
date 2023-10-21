package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    startGame()
}

fun startGame() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        try {
            val randomNumbers = createRandomNumber()
            while (true) {
                print("숫자를 입력해주세요 : ")
                val inputtedNumbers = readUserNumber()
                val compareResult = compareNumbers(randomNumbers, inputtedNumbers)
                if (compareResult) break
            }
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val userInput = Console.readLine()
            val userChoice = chooseRestart(userInput)
            if (userChoice) {
                println("게임 종료")
                return
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(e.message)
        }
    }
}


//랜덤 세자리 숫자 생성 함수
fun createRandomNumber(): MutableList<Int> {
    val randomNumbers = mutableListOf<Int>()
    while (randomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }

    return randomNumbers
}

//사용자의 입력을 받는 함수
fun readUserNumber(): MutableList<Int> {
//    println(randomNumbers)
    val userInput = Console.readLine()
    var userNumber = userInput.toInt()
    if (userNumber >= 1000 ||
        userNumber < 100
    ) {
        throw IllegalArgumentException("범위 외 입력!")
    } else {
        val userNumbers = mutableListOf<Int>()
        val lastNumber = userNumber % 10
        if (lastNumber == 0) throw IllegalArgumentException("0 입력 오류!")
        userNumbers.add(lastNumber)
        userNumber /= 10

        val middleNumber = userNumber % 10
        if (middleNumber == 0) throw IllegalArgumentException("0 입력 오류!")
        userNumbers.add(0, middleNumber)
        userNumber /= 10

        val firstNumber = userNumber % 10
        userNumbers.add(0, firstNumber)
        return userNumbers

    }
}

fun compareNumbers(randomNumbers: MutableList<Int>, userNumbers: MutableList<Int>): Boolean {
    var strikes = 0
    var balls = 0
    userNumbers.forEachIndexed { index, number ->
        if (randomNumbers.contains(number)) {
            if (randomNumbers.indexOf(number) == index) {
                strikes++
            } else {
                balls++
            }
        }
    }
    return printResult(strikes, balls)
}

fun printResult(strikes: Int, balls: Int): Boolean {
    if (strikes == 3) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    } else {
        if (strikes == 0 &&
            balls == 0
        ) {
            println("낫싱")
        } else {
            if (balls != 0) {
                print("${balls}볼 ")
            }
            if (strikes != 0) {
                println("${strikes}스트라이크")
            } else {
                println()
            }
        }
        return false
    }
}

fun chooseRestart(userInput: String): Boolean {
    val userChoice = userInput.toInt()
    return when (userChoice) {
        1 -> false
        2 -> true
        else -> {
            throw IllegalArgumentException("선택지 오류!")
        }
    }
}



