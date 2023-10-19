package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.Exception

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val computer: List<Int> = generateRandomThreeNumber()

    val user: List<Int> = inputThreeAnswerNumber()
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