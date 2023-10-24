package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class NumberBaseball {
    val input = InputGame()
    inner class InputGame {
        fun inputException(userNumber: MutableList<Char>, inputNumber: String) {
            if (inputNumber.length != 3) {
              throw  IllegalArgumentException()
            }
            for(index in inputNumber.indices){
                if(!inputNumber[index].isDigit())
                    throw IllegalArgumentException()
            }
            if (inputNumber.toSet().size != inputNumber.length) {
               throw  IllegalArgumentException()
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
            //joinTostring을 사용하면 컬렉션의 요소를 문자열로 결합하기 때문에 각각 따로 사용할 떄 보다 관리가 용이
        }

        fun readInputNumber(): String {
            val userInput = Console.readLine().toString()
            var userNumber = mutableListOf<Char>()
            inputException(userNumber, userInput)
            return userNumber.joinToString("")
        }
    }

    inner class Gaming() {
        fun seekAnswer(newComputerNumber: String, userNumber: String): List<Int> {
            val scoreResult = mutableListOf(0, 0) // 초기값 설정

            for (index in userNumber.indices) {
                if (newComputerNumber[index] == userNumber[index]) {
                    scoreResult[0]++ // 스트라이크 증가
                } else if (newComputerNumber.contains(userNumber[index])) {
                    scoreResult[1]++
                }
            }

            return scoreResult
        }

        fun printScore(scoreResult: List<Int>) {
            if (scoreResult[0] == 0 && scoreResult[1] == 0) {
                println("\n낫싱")
            } else if (scoreResult[0] == 3) {
                println("\n3스트라이크")
                endGame()
            } else {
                println("\n${scoreResult[1]}볼 ${scoreResult[0]}스트라이크")
            }
        }

        fun endGame() {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        }

        fun playing() {
            val computer = input.createComputerNumber()
            var user: String
            while (true) {
                user = input.readInputNumber()
                print("숫자를 입력해주세요 : $user")
                printScore(seekAnswer(computer,user))
                if(computer==user) {
                    break
                }
            }
        }
    }
    fun resetGame(): Boolean {
        val inputNumber = Console.readLine().toInt()
        if (inputNumber == 1) {
            println("$inputNumber")
            return true
        }
        if(!(inputNumber==1||inputNumber==2))
           throw IllegalArgumentException()
        return false
    }
    fun main() {
        println("숫자 야구 게임을 시작합니다.")
        var wantPlaying = true
        while (wantPlaying) {
            Gaming().playing()
            wantPlaying = resetGame()
        }
    }
}
