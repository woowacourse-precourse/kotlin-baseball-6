package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

/**
 * 메인 게임 루프를 시작하는 함수.
 */
fun main() {
    baseballGame()
}

/**
 * 숫자 야구 게임을 진행하는 함수.
 */
fun baseballGame() {
    val numberSet: MutableSet<String> = mutableSetOf()
    var startGame = true

    println("숫자 야구 게임을 시작합니다.")

    while (startGame) {
        getThreeNumber(numberSet)
        while (true) {
            print("숫자를 입력해주세요 : ")
            val inputNumber = getUserInput()
            val result = gameResults(inputNumber, numberSet)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        startGame = makeGameChoice()
    }
}

/**
 * 게임에 사용할 3개의 서로 다른 숫자를 생성하여 MutableSet에 저장하는 함수.
 *
 * @param threeNumber 게임 숫자를 저장할 MutableSet
 */
fun getThreeNumber(threeNumber: MutableSet<String>) {
    threeNumber.clear()
    while (threeNumber.size < 3) {
        val number = pickNumberInRange(1, 9)
        if (number.toString() !in threeNumber) {
            threeNumber.add(number.toString())
        }
    }
}

/**
 * 사용자로부터 3자리 숫자 입력을 받는 함수.
 *
 * @return 사용자가 입력한 3자리 숫자
 * @throws IllegalArgumentException 잘못된 입력값일 경우 예외를 던짐
 */
fun getUserInput(): String {
    while (true) {
        val inputNumber = Console.readLine()
        val parsedNumber = inputNumber.toIntOrNull()
        if (parsedNumber != null && inputNumber.length == 3) {
            return inputNumber
        } else {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }
    }
}

/**
 * 게임 결과를 계산하는 함수.
 *
 * @param inputNumber 사용자 입력 숫자
 * @param numberSet 게임 숫자 세트
 * @return 게임 결과 메시지
 */
fun makeGameChoice(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (Console.readLine()) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException("잘못된 입력값입니다.")
    }
}

/**
 * 게임 종료 또는 새로운 게임 시작 여부를 사용자에게 물어 사용자 선택에 따라 반환하는 함수.
 *
 * @return 게임을 새로 시작할 경우 true, 종료할 경우 false
 * @throws IllegalArgumentException 잘못된 입력값일 경우 예외를 던짐
 */
fun gameResults(inputNumber: String, numberSet: MutableSet<String>): String {
    val inputNumIdx = inputNumber.toList().map { it.toString() }
    val strike = inputNumIdx.zip(numberSet).count { (inputIdx, targetNumIdx) -> inputIdx == targetNumIdx }
    val ball = inputNumIdx.count { it in numberSet } - strike

    return when {
        strike > 0 && ball > 0 -> "${ball}볼 ${strike}스트라이크"
        strike > 0 -> "${strike}스트라이크"
        ball > 0 -> "${ball}볼"
        else -> "낫싱"
    }
}