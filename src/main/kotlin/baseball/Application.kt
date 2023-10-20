package baseball

import camp.nextstep.edu.missionutils.Console.readLine

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

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    print("숫자를 입력해주세요 : ")
    val userInput = readLine()

    /*
   * 1. 예외 처리
   * - 숫자 이외의 값을 입력 받을 경우 ex) a12, dog, *&^ ...
   * - 서로 다른 숫자가 3개가 아닐 경우 ex) 112, 233, 242 ...
   * */

    try {
        val number = processInputWithException(userInput)
        println("숫자: $number")
    } catch (_: IllegalArgumentException) {
        println("시스템 종료")
    }


    /*
    * 숫자 야구 게임을 시작합니다.
    * 숫자를 입력해주세요 : 123
    * 1볼 1스트라이크
    * 숫자를 입력해주세요 : 145
    * 1볼
    * 숫자를 입력해주세요 : 671
    * 2볼
    * 숫자를 입력해주세요 : 216
    * 1스트라이크
    * 숫자를 입력해주세요 : 713
    * 3스트라이크
    * 3개의 숫자를 모두 맞히셨습니다! 게임 종료
    * 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
    * 1
    * 숫자를 입력해주세요 : 123
    * 1볼
    */


}
