package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf

//숫자야구는 3개 혹은 4개의 숫자로 하는 게임이다. 변경 여지 있음.

fun makeSecretNumber(): String {
    val computer: MutableList<Int> = mutableListOf()
    for (it in 0 until MAX_NUMBER) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

fun isValidGuessNumber(input: String) =
    input.length == MAX_NUMBER && !hasDuplicatedNumberInside(input) && input.all { isNumber(it) }
fun hasDuplicatedNumberInside(input: String) = input.length != input.toSet().size
fun isNumber(input: Char) = input in '0'..'9'
fun isValidContinueNumber(input: String) = input.length == 1 && input[0] in '1'..'2'

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        val secretNumber = makeSecretNumber()
        while (true) {
            print("숫자를 입력해주세요 : ")
            val guessNumber = Console.readLine()
            require(isValidGuessNumber(guessNumber)) {
                "Wrong guessNumber $guessNumber"
            }
            val guessResult = GuessResult(secretNumber, guessNumber)
            println(guessResult.toString())
            if (guessResult.isCorrect()) {
                println("${MAX_NUMBER}개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val continueNumber = Console.readLine()
        require(isValidContinueNumber(continueNumber)) {
            "Wrong continueNumber $continueNumber"
        }
        if (continueNumber[0] == '2') {
            break
        }
    }
}
