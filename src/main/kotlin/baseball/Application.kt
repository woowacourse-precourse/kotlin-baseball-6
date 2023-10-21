package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms


fun generateRandomNumber(): List<Int> {

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun processInputWithException(input: String): List<Int> {

    try {

        val number = input.map { it.toString().toInt() }.distinct()

        if (input.length != number.size || number.size != 3)
            throw IllegalArgumentException()

        return number

    } catch (_: NumberFormatException) {
        throw IllegalArgumentException()

    }

}

fun baseballGame(user: List<Int>, computer: List<Int>): Pair<Int, Int> {

    val strike = computer.zip(user).count { (c, u) -> c == u }
    val ball = computer.intersect(user.toSet()).size - strike

    return Pair(strike, ball)


}

fun displayResult(strike: Int, ball: Int): MutableList<String> {

    val result = mutableListOf<String>()

    if (ball == 0 && strike == 0) {
        result.add("낫싱")
        return result
    }

    if (ball > 0) result.add("${ball}볼")
    if (strike > 0) result.add("${strike}스트라이크")

    return result

}

fun terminateProgram(flag: String): Boolean {

    val isExit = when (flag) {
        "1" -> false
        "2" -> true
        else -> throw IllegalArgumentException()
    }

    return isExit

}

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    do {

        // TODO("1. computer 랜덤수 생성")
        val computer = generateRandomNumber()

        do {

            // TODO("2. 숫자 입력 받기 - 예외처리")
            print("숫자를 입력해주세요 : ")
            val userInput = readLine()
            val user = processInputWithException(userInput)

            // TODO("3. 숫자 비교 하기")
            val (strike, ball) = baseballGame(user, computer)


            // TODO("4. 결과 출력 하기")
            val result = displayResult(strike, ball)
            println(result.joinToString(separator = " "))


        } while (strike < 3)


        // TODO("5. 종료 여부 확인 - 예외처리")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")


        val flag = readLine()
        val isExit = terminateProgram(flag)


    } while (!isExit)


}
