package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var computer: List<Int> = generateThreeRandomNumber()

    var start = true
    while (start) {
        val user: List<Int> = inputThreeAnswerNumber()

        val isAnswer = checkAnswer(computer, user)

        if (isAnswer) {
            start = gameRestartOrOver()
        }

        if (isAnswer && start) {
            computer = generateThreeRandomNumber()
        }
    }
}

/*
    기능1. 랜덤숫자 3개 생성
    : 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
 */
fun generateThreeRandomNumber(): List<Int> {
    val randomList = mutableListOf<Int>()

    while (randomList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomList.contains(randomNumber)) {
            randomList.add(randomNumber)
        }
    }

    return randomList
}

/*
    기능2. 정답숫자 3개 입력
    : 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력한다.
    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
 */
fun inputThreeAnswerNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val inputList = Console.readLine()
    val answerList = mutableListOf<Int>()

    val isValid = checkValidation(inputList)

    if (!isValid) {
        throw IllegalArgumentException("1~9사이의 서로 다른 3개의 숫자를 입력한다.")
    }

    for (input in inputList) {
        val number = Character.getNumericValue(input)
        answerList.add(number)
    }

    return answerList
}

/*
    기능2-1. 입력한 정답 유효성 검사
    : 예외1. 입력 길이가 3이 아니다.
      예외2. 숫자 1~9사이의 값이 아니다.
      예외3. 입력 숫자가 중복된다.
 */
fun checkValidation(checkList: String): Boolean {
    val duplicateCheckList = mutableListOf<Int>()

    var isValid = true

    if (checkList.length != 3) {
        isValid = false
    }

    for (check in checkList) {
        val number = Character.getNumericValue(check)

        if (number !in 1..9) {
            isValid = false
        }

        if (duplicateCheckList.contains(number)) {
            isValid = false
        }
    }

    return isValid
}

/*
    기능3. 정답 확인
    : 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻는다.
    이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
 */
fun checkAnswer(computer: List<Int>, user: List<Int>): Boolean {
    var ball = 0
    var strike = 0

    for (i in 0..2) {
        if (computer[i] == user[i]) {
            strike += 1
            continue
        }

        if (user.contains(computer[i])) {
            ball += 1
        }
    }

    printHint(ball, strike)

    if (strike == 3) {
        return true
    }

    return false
}

/*
    기능3-1. 힌트 출력
    : 컴퓨터는 입력한 숫자에 대한 결과(힌트)를 출력한다.
 */
fun printHint(ball: Int, strike: Int) {
    if (strike == 3) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return
    }

    if (ball != 0 && strike != 0) {
        println("${ball}볼 ${strike}스트라이크")
        return
    }

    if (ball != 0) {
        println("${ball}볼")
        return
    }

    if (strike != 0) {
        println("${strike}스트라이크")
        return
    }

    println("낫싱")
}

/*
    기능4. 게임 재시작 및 종료
    : 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
    게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
 */
fun gameRestartOrOver(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    val decision = Console.readLine()

    if (decision == "1") {
        return true
    }

    if (decision == "2") {
        return false
    }

    throw IllegalArgumentException("숫자 1과 2 중 하나의 수만 입력해주세요.")
}