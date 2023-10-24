package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStartGame()
    startGame()
}

fun printStartGame() {
    println("숫자 야구 게임을 시작합니다.")
}

fun startGame() {
    var stopFlag = 1
    var numberOfComputer = getNumberFromComputer()

    do {
        val numberOfPlayer = getNumberFromPlayer()
        val gameResult = compareNumbers(numberOfComputer, numberOfPlayer)

        printResult(gameResult)

        if (gameResult.strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            stopFlag = setStopFlag()

            if (stopFlag == 1) {
                numberOfComputer = getNumberFromComputer()
            }
        }
    } while (stopFlag == 1)

    Console.close()
}

fun getNumberFromComputer(): List<String> {
    val randomNumbers = arrayListOf<String>()

    while (randomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }

    return randomNumbers
}

fun getNumberFromPlayer(): List<String> {
    print("숫자를 입력해주세요 : ")

    val randomNumbers = arrayListOf<String>()
    val inputNumber = Console.readLine()

    checkNumberOfPlayer(inputNumber)

    inputNumber.forEach {
        val number = it.toString()
        randomNumbers.add(number)
    }

    return randomNumbers
}

fun checkNumberOfPlayer(numbers: String) {
    if (numbers.length != 3 ||
        numbers.distinctString().length != 3
    ) {
        throw IllegalArgumentException()
    } else {
        numbers.forEach {
            val number = it.code

            if (number < 49 || number > 57) {
                throw IllegalArgumentException()
            }
        }
    }
}

fun compareNumbers(numberOfComputer: List<String>, numberOfPlayer: List<String>): Result {
    val result = Result()

    numberOfPlayer.forEachIndexed { index, number ->
        if (numberOfComputer.contains(number)) {
            if (numberOfComputer.indexOf(number) == index) {
                result.strike++
            } else {
                result.ball++
            }
        }
    }

    return result
}

fun printResult(result: Result) {
    if (result.sumResult() == 0) {
        println("낫싱")
    } else {
        if (result.strike == 0) {
            println("${result.ball}볼")
        } else if (result.ball == 0 && result.strike < 3) {
            println("${result.strike}스트라이크")
        } else if (result.strike < 3 && result.ball != 0) {
            println("${result.ball}볼 ${result.strike}스트라이크")
        }
    }
}

fun setStopFlag(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    val flagFromPlayer = Console.readLine()

    if (!(flagFromPlayer.equals("1")) && !(flagFromPlayer.equals("2"))) throw IllegalArgumentException()

    return flagFromPlayer.toInt()
}