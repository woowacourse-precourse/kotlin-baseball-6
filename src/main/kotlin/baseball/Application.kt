package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.Exception

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val computer: List<Int> = generateRandomThreeNumber()

    val user: List<Int> = inputThreeAnswerNumber()

    checkAnswer(computer, user)
}

/*
    기능1. 랜덤숫자 3개 생성
    : 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
 */
fun generateRandomThreeNumber(): List<Int> {
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

    if (inputList.length != 3) {
        throw IllegalArgumentException("길이가 3이 되게 입력해주세요.")
    }

    for (input in inputList) {
        try {
            val number = input.toString().toInt()

            if (answerList.contains(number)) {
                throw IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.")
            }

            answerList.add(number)

        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("1~9사이의 숫자만 입력해주세요.")
        }
    }

    return answerList
}

/*
    기능3. 정답 확인
    : 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻는다.
    이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
 */
fun checkAnswer(computer: List<Int>, user: List<Int>) {
    var ball = 0
    var strike = 0

    for (i in 0..2) {
        if (computer[i] == user[i]) {
            strike += 1
        }

        if (user.contains(computer[i])) {
            ball += 1
        }
    }

    if (strike == 3) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    if (ball == 0 && strike == 0) {
        println("낫싱")
    }

    if (ball != 0 && strike != 0) {
        println("${ball}볼 ${strike}스트라이크")
    }

    if (ball != 0) {
        println("${ball}볼")
    }

    if (strike != 0) {
        println("${strike}스트라이크")
    }
}