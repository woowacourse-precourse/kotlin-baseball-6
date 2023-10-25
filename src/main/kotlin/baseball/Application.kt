package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    do {
        playGame()
    } while (afterGame())

}

fun playGame() {
    val answer = genAnswer()
    println("숫자 야구 게임을 시작합니다.")
    do {
        print("숫자를 입력해주세요 : ")
        val input = getInput()
        val result = compare(answer, input)
        showResult(result)
    } while (result.first != 3)    // 스트라이크의 횟수가 3이 아닌 경우

}

fun genAnswer() : String {      // 세 자리의 난수 생성
    val answer = mutableListOf<Int>()
    while (answer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)  // 1부터 9까지의 수
        if (!answer.contains(randomNumber)) {       // 각 숫자가 겹치지 않게
            answer.add(randomNumber)
        }
    }
    return answer.joinToString("")
}

fun getInput() : String {
    val userInput = Console.readLine()

    validateInput(userInput)
    return userInput
}

fun validateInput(userInput: String) {
    var tmpList = mutableListOf<Char>()

    // 사용자의 입력이 세 글자가 아닌 경우
    if (userInput.length != 3) {
        throw IllegalArgumentException("세 글자가 아닙니다.")
    }

    for (index in userInput.indices) {
        // 사용자의 입력이 숫자가 아니거나 1부터 9까지의 정수가 아닌 경우
        if (userInput[index] < '1' || userInput[index] > '9') {
            throw IllegalArgumentException("1부터 9까지의 정수만 입력하실 수 있습니다.")
        }
        // 사용자의 입력에서 같은 숫자가 중복될 경우
        if (tmpList.contains(userInput[index])) {
            throw IllegalArgumentException("각 숫자는 달라야 합니다.")
        }
        tmpList.add(userInput[index])
    }

}

fun compare(answer: String, userInput: String): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for (index in userInput.indices) {
        if (userInput[index] == answer[index]) {
            strike++
            continue
        }
        if (answer.contains(userInput[index])) {
            ball++
        }
    }
    return Pair(strike, ball)

}

fun showResult(result : Pair<Int, Int>){
    val strike = result.first
    val ball = result.second

    if (strike == 0 && ball == 0) {
        println("낫싱")
        return
    }

    else if (strike == 0) {
        println("${ball}볼")
        return
    }

    else if (ball == 0) {
        println("${strike}스트라이크")
        return
    }
    else {
        println("${ball}볼 ${strike}스트라이크")
    }
}

fun afterGame(): Boolean {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val userInput = Console.readLine().toInt()
    if (userInput == 1) {
        return true
    }
    else if (userInput ==2 ){
        return false
    }
    else {
        throw IllegalArgumentException("1또는 2만 입력하세요.")
    }
}