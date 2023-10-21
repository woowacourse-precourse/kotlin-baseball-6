package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class NumberBaseball {
    fun inputException(userNumber: MutableList<Char>, inputNumber: String) {
        if (inputNumber.length != 3) {
            throw IllegalArgumentException("입력된 숫자가 3자리가 아닙니다.")
        }
        if (!inputNumber.matches(Regex("\\d+"))) {
            throw IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.")
        }
        if (inputNumber.toSet().size != inputNumber.length) {
            throw IllegalArgumentException("중복된 숫자가 존재합니다.")
        }
        for (index in inputNumber.indices) {
            userNumber.add(inputNumber[index])
        }
    }

    fun createComputerNumber(): String {
        val newComputerNumber = mutableListOf<String>()
        while (newComputerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
            if (!newComputerNumber.contains(randomNumber)) {
                newComputerNumber.add(randomNumber)
            }
        }
        return newComputerNumber.joinToString("")
    }

    fun seekAnswer(newComputerNumber: String, userNumber: String) {
        var strikeCount: Int = 0
        var ballCount: Int = 0

        for (index in userNumber.indices) {
            if (userNumber[index] == newComputerNumber[index]) {
                strikeCount++
            } else if (newComputerNumber.contains(userNumber[index])) {
                ballCount++
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            println("낫싱")
        } else if (strikeCount == 3) {
            println("${strikeCount}스트라이크")
            endGame()
        } else {
            println("${ballCount}볼 ${strikeCount}스트라이크")
        }
    }

    fun gameStart() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun endGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    fun playing() {
        val computer = createComputerNumber()
        var user: String
        while (true) {
            user = readInputNumber()
            seekAnswer(computer, user)
            if (computer == user) {
                break
            }
        }
    }

    fun readInputNumber(): String {
        print("숫자를 입력해주세요: ")
        val userInput = Console.readLine().toString()
        var userNumber = mutableListOf<Char>()
        inputException(userNumber, userInput)
        return userNumber.joinToString("")
    }

    fun resetGame(): Boolean {
        val inputNumber = Console.readLine().toString()
        if (inputNumber == "1") {
            return true
        }
        return false
    }

    fun main() {
        gameStart()
        do {
            playing()
        } while (resetGame())
    }
}

fun main() {
    val numberBaseball = NumberBaseball()
    numberBaseball.main()
}