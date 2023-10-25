package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess


class Game {

    companion object {

        private var strike: Int = 0
        private var ball: Int = 0


        fun play() {
            do{
                performBaseballGame()

            }while(askRestartGame())
        }
        fun performBaseballGame() {

            val computer = mutableListOf<Int>()
            var userInput = ""
            createRandomNum(computer)


            do {
                printUserInputMessage()
                userInput = Console.readLine()
                verifyInput(userInput)
                compareToComputer(userInput, computer)

            } while (!isAllStrikes())

            askRestartGame()

        }

        fun createRandomNum(computer: MutableList<Int>) {
            while (computer.size < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber)
                }
            }
        }
        fun printUserInputMessage() {
            print("숫자를 입력해주세요 : ")
        }

        fun verifyInput(input: String) {

            try {
                val inputNum = input.toInt()

                try {
                    if (inputNum != null) {
                        if (isValidNumber(inputNum)) {
                        } else {
                            throw IllegalArgumentException("잘못된 숫자 입력")
                        }
                    } else {
                        throw IllegalArgumentException("숫자가 아닌 값 입력")
                    }
                } catch (e: IllegalArgumentException) {
                    println("${e.message}\n")
                    exitProcess(1)

                }

            }catch (e: NumberFormatException) {
                println("숫자 형식이 아닙니다.\n")
                exitProcess(1)

            }


        }

        fun isValidNumber(number: Int): Boolean {
            return number in 100..999 && hasUniqueDigits(number) && !containZero(number)
        }

        fun hasUniqueDigits(number: Int): Boolean {
            val digits = number.toString().toSet()
            return digits.size == 3
        }

        fun containZero(number: Int): Boolean {
            return number.toString().contains("0")
        }

        fun compareToComputer(user: String, computer: MutableList<Int>) {

            val UserinputArray = user.toCharArray()
            strike = numOfStrike(UserinputArray, computer)
            ball = numOfBall(UserinputArray, computer)

            println(getResultMessage())

        }

        fun numOfStrike(user: CharArray, computer: MutableList<Int>): Int {
            var result = 0

            for (i in 0 until 3) {
                if (user.get(i).digitToInt() == computer.get(i)) result++
            }

            return result
        }

        fun numOfBall(user: CharArray, computer: MutableList<Int>): Int {
            var result = 0
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    if (i != j && user.get(i).digitToInt() == computer.get(j)) result++
                }
            }
            return result
        }

        fun getResultMessage(): String {
            if (isNothing()) {
                return "낫싱"
            } else if (isStrike()) {
                return strike.toString() + "스트라이크"
            } else if (isBall()) {
                return ball.toString() + "볼"
            } else return ball.toString() + "볼" + " " + strike.toString() + "스트라이크"
        }

        fun isNothing(): Boolean {
            return strike == 0 && ball == 0
        }

        fun isStrike(): Boolean {
            return 0 < strike && ball == 0
        }

        fun isBall(): Boolean {
            return strike == 0 && 0 < ball
        }

        fun isAllStrikes(): Boolean {
            if (strike == 3) {
                printEndMessage()
                return true
            }
            return false
        }

        private fun printEndMessage() {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n")
        }

        private fun askRestartGame() : Boolean {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n")
            val restartInput = Console.readLine()
            verifyRestart(restartInput)

            return isRestart(restartInput.toInt())
        }

        private fun verifyRestart( input: String) {
            try {
                val restartFlag = input.toInt()

                try {
                    if (restartFlag != null) {
                        if (isValidRestart(restartFlag)) {
                        } else {
                            throw IllegalArgumentException("1,2 만 입력해주세요.\n")

                        }
                    } else {
                        throw IllegalArgumentException("1,2 만 입력해주세요.\n")
                    }
                } catch (e: IllegalArgumentException) {
                    println("${e.message}\n")
                    exitProcess(1)
                }

            }catch (e: NumberFormatException) {
                println("1,2 만 입력해주세요.\n")
                exitProcess(1)
            }

        }

        private fun isRestart(restartFlag: Int) :Boolean{
            return restartFlag == 1
        }

        private fun isValidRestart(restartFlag : Int) : Boolean {
            return !(restartFlag != 1 && restartFlag != 2)
        }



    }

}

