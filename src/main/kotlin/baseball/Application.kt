package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    runBaseballGame()
}

// 게임 매니져 메서드
fun runBaseballGame() {
    var userDecision = true

    while (userDecision) {
        val computerNumber = generateRandomComputerNumber()
        while (true) {
            print("숫자를 입력해주세요 : ")
            val userInput = getUserInput()
            if (!calculateResult(computerNumber, userInput)) {
                continue
            } else {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                when (getUserDecision()) {
                    1 -> {
                        userDecision = true
                        break
                    }

                    2 -> {
                        userDecision = false
                        break
                    }
                }
            }
        }
    }
}

// 컴퓨터의 랜덤한 숫자 생성
fun generateRandomComputerNumber(): ArrayList<Int> {
    val computerNumber = ArrayList<Int>()

    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }

    return computerNumber
}

// 사용자 입력
fun getUserInput(): ArrayList<Int> {
    val userInputString = Console.readLine()
    val userInputList = ArrayList<Int>()

    for (element in userInputString) {
        userInputList.add(element.toString().toInt())
    }

    if (userInputList.size != 3) {
        throw IllegalArgumentException("잘 못 된 길이의 숫자 입력")
    }
    if (userInputList.contains(0)) {
        throw IllegalArgumentException("잘 못 된 범위의 숫자 입력")
    }
    for (element in userInputList) {
        if (userInputList.count { it == element } != 1) {
            throw IllegalArgumentException("중복된 숫자 입력")
        }
    }

    return userInputList
}

// 컴퓨터의 난수와 사용자 입력을 대조해 결과 출력
fun calculateResult(computerNumber: ArrayList<Int>, userInput: ArrayList<Int>): Boolean {
    var ball = 0
    var strike = 0

    // 컴퓨터의 난수와 사용자의 입력을 대조해 결과 계산
    for (numberC in computerNumber) {
        for (numberU in userInput) {
            if (numberC == numberU) {
                if (computerNumber.indexOf(numberC) == userInput.indexOf(numberU)) {
                    strike++
                } else {
                    ball++
                }
            }
        }
    }

    // 결과 출력
    if (ball == 0) {
        if (strike == 0) {
            println("낫싱")
        } else {
            println("${strike}스트라이크")
        }
    } else {
        if (strike == 0) {
            println("${ball}볼")
        } else {
            println("${ball}볼 ${strike}스트라이크")
        }
    }

    return when (strike) {
        3 -> true
        else -> false
    }
}

fun getUserDecision(): Int {
    val userDecisionString = Console.readLine()
    val userDecisionList = ArrayList<Int>()

    for (element in userDecisionString) {
        userDecisionList.add(element.toString().toInt())
    }

    if (userDecisionList.size != 1) {
        throw IllegalArgumentException("잘 못 된 길이의 숫자 입력")
    }
    if (userDecisionList[0] != 1 && userDecisionList[0] != 2) {
        throw IllegalArgumentException("잘 못 된 범위의 숫자 입력")
    }

    return userDecisionList[0]
}
