package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

var resultStrike = 0
const val NUMBER_SIZE = 3

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startGame()
}

fun startGame() {
    val computer = getRandomNumbers()
    while (resultStrike != 3) {
        val user = getUserNumbers()
        getHints(computer, user)
    }

    if (resultStrike == 3) {
        QuitOrRetry()
    }
}

fun getRandomNumbers(): MutableList<Int> { // 랜덤값 얻기
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < NUMBER_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserNumbers(): MutableList<Int> { // 사용자 입력값 얻기
    print("숫자를 입력해주세요 : ")

    val user: MutableList<Int> = mutableListOf()
    var userNumber: Int
    var userInput = Console.readLine()

    try {
        userNumber = userInput.toInt()
        userInputCheck(userInput)
    } catch (e: NumberFormatException) { // 문자열을 입력할 경우 예외처리
        throw IllegalArgumentException("문자가 아닌 숫자를 입력하세요.")
    }

    var intOne: Int = userNumber/100
    var intTwo: Int = (userNumber%100)/10
    var intThree: Int = userNumber%10

    user.add(intOne)
    user.add(intTwo)
    user.add(intThree)

    return user
}

fun userInputCheck(userInput: String) {
    val user: MutableList<Char> = mutableListOf()
    if (userInput.length != 3) // 3자리 정수가 아닌 경우 예외처리
         throw IllegalArgumentException("3자리 정수를 입력하세요.")

    for (i: Int in 0 until NUMBER_SIZE)
        user.add(userInput[i])

    if (!user.distinct().equals(user)) // 중복된 숫자를 입력한 경우 예외처리
        throw IllegalArgumentException("중복되지 않는 숫자를 입력하세요.")
}

fun getStrikeBall(computer: MutableList<Int>, user: MutableList<Int>): MutableList<Int> { // 스트라이크, 볼 개수 구하기
    val hint: MutableList<Int> = mutableListOf()
    var strike = 0
    var ball = 0
    for (i in computer.indices) {
        if (computer[i] == user[i]) {
            strike++
            continue
        }

        if (computer.contains(user[i])) {
            ball++
        }
    }
    hint.add(strike)
    hint.add(ball)

    return hint
}

fun getHints(computer: MutableList<Int>, user: MutableList<Int>) { // 스트라이크, 볼, 낫싱 힌트 얻기
    var hints = getStrikeBall(computer, user)
    var strike = hints[0]
    var ball = hints[1]

    if (strike == 0 && ball == 0) {
        println("낫싱")
        return
    }
    if (strike == 0) {
        println("${ball}볼")
        return
    }
    if (ball == 0) {
        println("${strike}스트라이크")
        if (strike == 3)
            resultStrike = 3
        return
    }

    println("${ball}볼 ${strike}스트라이크")
}

fun QuitOrRetry() {
    println("${NUMBER_SIZE}개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    var userInput = Console.readLine()

    QuitOrRetryCheck(userInput)

    if (userInput == "1") {
        resultStrike = 0
        startGame()
    }

    if (userInput == "2") {
        return
    }
}

fun QuitOrRetryCheck(userInput: String) {
    if (userInput != "1" && userInput != "2")
        throw IllegalArgumentException("1과 2 둘 중 하나를 선택하세요.")
}

