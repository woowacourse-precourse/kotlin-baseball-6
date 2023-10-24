package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

interface InputProvider { // 입력 제공.
    fun provideInput(): String
}

class ConsoleInputProvider : InputProvider { // Application.kt에서 컴파일할 때 사용되는 클래스 / Console.readLine()으로 사용자 입려을 받음.
    override fun provideInput(): String = Console.readLine()?.replace(" ", "") ?: throw IllegalArgumentException()
}

class TestInputProvider(private val inputs: List<String>) : InputProvider { // 테스트 코드에서 컴파일할 때 사용되는 클래스.
    private var index = 0

    override fun provideInput(): String =
        if (index < inputs.size) inputs[index++] else throw IllegalArgumentException("더 이상의 입력값이 없습니다.")
}

fun main() {
    val inputProvider: InputProvider = ConsoleInputProvider()
    val game = BaseballGame(inputProvider)
    game.start()
}

class BaseballGame(private val inputProvider: InputProvider) {

    // 서로 다른 3개의 숫자로 이루어진 문자열 생성, 반환하는 함수.
    private fun generateAnswer(): String {
        val answer = mutableListOf<Int>()
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
        return answer.joinToString("")
    }


    // 추측값과 정답을 비교해 스트라이크, 볼, 낫싱을 출력할 수 있고, 얼마나 일치하는지 확인할 수 있는 함수.
    private fun checkGuess(answer: String, guess: String): Boolean {
        if (guess.length != 3) throw IllegalArgumentException("세 자리 숫자를 입력해야 합니다.")

        var strikes = 0
        var balls = 0

        for (i in guess.indices) {
            if (guess[i] == answer[i]) {
                strikes++
            } else if (answer.contains(guess[i])) {
                balls++
            }
        }

        when {
            strikes == 0 && balls == 0 -> println("낫싱")
            strikes > 0 && balls > 0 -> println("${balls}볼 ${strikes}스트라이크")
            strikes > 0 -> println("${strikes}스트라이크")
            else -> println("${balls}볼")
        }

        return strikes == 3
    }

    // 사용자의 게임을 다시 할 것인지 종료할 것인지 묻는 함수.
    private fun shouldContinue() : Boolean {
        println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력해주세요. : ")

        val userInput = inputProvider.provideInput()

        if (userInput != "1" && userInput != "2") {
            throw IllegalArgumentException("잘못된 입력입니다. 1 또는 2만 입력해주세요.")
        }

        if (userInput == "2") {
            println("게임 종료")
            return false
        }

        return true
    }

    fun start() {
        do {
            println("숫자 야구 게임을 시작합니다.")
            val answer = generateAnswer()

            var isCorrect : Boolean

            do {
                print("숫자를 입력해주세요. : ")
                val guess = inputProvider.provideInput()
                isCorrect = checkGuess(answer, guess)
            } while(!isCorrect)

            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료하겠습니다.")
        } while (shouldContinue())
    }
}

