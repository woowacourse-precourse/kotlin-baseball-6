package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.util.Stack

class NumberBaseball {
    var computerNumber = mutableListOf<String>()
    var userNumber = mutableListOf<String>()
    var startMent: String = "숫자를 입력해주세요:"

    private fun inputException(inputNumber: MutableList<String>) {
        for (index in 0 until inputNumber.size) {
            if (inputNumber[index].length != 3)
                throw IllegalArgumentException("입력된 숫자가 3개가 아닙니다.")
            if (!inputNumber[index].matches(Regex("\\d+"))) {
                throw IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.")
            }
        }
        if (inputNumber.toSet().size != inputNumber.size) {
            throw IllegalArgumentException("중복된 숫자가 존재합니다")
        }
    }

    fun createComputerNumber(): MutableList<String> {
        val newComputerNumber = mutableListOf<String>()
        while (newComputerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
            if (!newComputerNumber.contains(randomNumber))
                newComputerNumber.add(randomNumber)
        }
        return newComputerNumber
    }

    fun nothing(userNumber: List<String>, computerNumber: List<String>): Boolean {
        for (index in 0 until userNumber.size) {
            if (!computerNumber.contains(userNumber[index])) {
                println("낫띵")
                return true
            }
        }
        return false
    }

    fun ballOrstrike(userNumber: List<String>, computerNumber: List<String>): Boolean {
        var strikeCount: Int = 0
        var ballCount: Int = 0
        for (index in 0 until userNumber.size) {
            if (computerNumber[index] == userNumber[index])
                strikeCount++
            else if (computerNumber.contains(userNumber[index]))
                ballCount++
        }
        println("${ballCount}볼 ${strikeCount}스트라이크")
        return strikeCount == 3
    }

    fun readInputNumber(): MutableList<String> {
        val userInput = readLine().toString()
        userNumber.add(userInput)
        inputException(userNumber)
        return userNumber
    }

    fun gameStart() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun main() {
        while (true) {
            userNumber.clear()
            computerNumber = createComputerNumber()
            gameStart();
            readInputNumber()
            if (ballOrstrike(userNumber, computerNumber)) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            }
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            var userInput = readLine()!!.toInt()
            if (userInput == 2) {
                break
            }
        }
    }
}