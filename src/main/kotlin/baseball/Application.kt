package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

fun processInputWithException(input: String): List<Int> {

    /*
     * 1. 예외 처리
     * - 숫자 이외의 값을 입력 받을 경우 ex) a12, dog, *&^ ...
     * - 서로 다른 숫자가 3개가 아닐 경우 ex) 112, 233, 242 ...
     * */

    try {

        val number = input.map { it.toString().toInt() }.distinct()

        if (input.length != number.size || number.size != 3)
            throw IllegalArgumentException()

        return number

    } catch (_: NumberFormatException) {
        throw IllegalArgumentException()

    }

}

fun baseballGame(user: List<Int>): Pair<Int, Int> {

    /*
    * 2. 게임 설계
    * - 서로다른 3개의 수로 이루어진 랜덤 숫자 생성
    * - 컴퓨터와 사용자의 숫자를 비교하여 결과 출력
    *   - 스트라이크: 같은 자리에 숫자가 동일할 경우
    *       - 스트라이크의 개수가 3일 경우,
    *       - 게임을 새로시작 1, 종료 2 입력 받음.
    *   - 볼: 동일한 숫자의 개수 - 스트라이크 개수
    *   - 낫싱: 3개의 숫자가 모두 다를 경우
    * */

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    println("computer: $computer")

    val strike = computer.zip(user).count { (c, u) -> c == u }
    val ball = computer.intersect(user).size - strike

    return Pair(strike, ball)


}

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    print("숫자를 입력해주세요 : ")
    val userInput = readLine()
    val number = processInputWithException(userInput)

    val (strike, ball) = baseballGame(number)

    val output = mutableListOf<String>()

    if (ball == 0 && strike == 0) {
        output.add("낫싱")
    } else if (ball > 0) {
        output.add("${ball}볼")
    } else if (strike > 0) {
        output.add("${strike}스트라이크")
    }

    println(output.joinToString(separator = " "))


}
