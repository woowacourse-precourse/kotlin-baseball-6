package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
import java.util.regex.Pattern

    private fun inputException(userNumber: MutableList<Char>, inputNumber: String) {
        if (inputNumber.length != 3) {
            throw IllegalArgumentException("입력된 숫자가 3자리가 아닙니다.")
        }
        if (!inputNumber.matches(Regex("\\d+"))||inputNumber.matches(Regex("^0$"))){
            throw IllegalArgumentException("숫자가 아닌 문자 또는 0이 포함되어있습니다.")
        }
        val uniqueNumbers = inputNumber.toSet().size
        if (uniqueNumbers != inputNumber.length) {
            throw IllegalArgumentException("중복된 숫자가 존재합니다.")
        }
        userNumber.addAll(inputNumber.toList())
    }

    private fun createComputerNumber(): String {
        val uniqueNumbers = mutableSetOf<Char>()
        while (uniqueNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString().single()
            uniqueNumbers.add(randomNumber)
        }
        return uniqueNumbers.joinToString("")
    }

    private fun readInputNumber(): String {
        print("숫자를 입력해주세요: ")
        val userInput = Console.readLine()
        val userNumber = mutableListOf<Char>()
        inputException(userNumber, userInput)
        return userNumber.joinToString("")
    }

    private fun seekAnswer(newComputerNumber: String, userNumber: String): List<Int> {
        val scoreResult = mutableListOf(0, 0)
        for (index in userNumber.indices) {
            if (newComputerNumber[index] == userNumber[index]) {
                scoreResult[0]++
            } else if (newComputerNumber.contains(userNumber[index])) {
                scoreResult[1]++
            }
        }
        return scoreResult
    }

    private fun printScore(scoreResult: List<Int>) {
        if (scoreResult[0] == 0 && scoreResult[1] == 0) {
            println("낫싱")
        } else if (scoreResult[0] == 3) {
            println("\n${scoreResult[0]}스트라이크")
            endGame()
        } else {
            println("\n${scoreResult[1]}볼 ${scoreResult[0]}스트라이크")
        }
    }

    private fun endGame() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    private fun resetGame(): Boolean {
        val inputNumber = Console.readLine().toInt()
        if (inputNumber == 1) {
            println(1)
            return true
        }
        if(inputNumber==2)
            return false
        if (inputNumber!=1||inputNumber!=2) {
            throw IllegalArgumentException("1 또는 2를 입력하세요.")
            return false
        }
        return false
    }

    fun main() {
        println("숫자 야구 게임을 시작합니다.")
        var wantPlaying = true
        while (wantPlaying) {
            val computer = createComputerNumber()
            var user: String
            while (true) {
                user = readInputNumber()
                print("숫자를 입력해주세요: $user")
                val scoreResult = seekAnswer(computer, user)
                printScore(scoreResult)
                if (computer == user) {
                    break
                }
            }
            wantPlaying = resetGame()
        }
    }