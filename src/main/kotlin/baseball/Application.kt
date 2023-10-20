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


fun baseballGame(user: List<Int>, computer: List<Int>): Pair<Int, Int> {

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



    println("computer: $computer")

    val strike = computer.zip(user).count { (c, u) -> c == u }
    val ball = computer.intersect(user.toSet()).size - strike

    return Pair(strike, ball)


}


fun displyResult(strike: Int, ball: Int): MutableList<String> {

    val result = mutableListOf<String>()

    if (ball == 0 && strike == 0) {
        result.add("낫싱")
        return result
    }

    if (ball > 0) result.add("${ball}볼")
    if (strike > 0) result.add("${strike}스트라이크")

    return result

}

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    loop@ do {

        // 1. 랜덤수 생성
        val computer = generateRandomNumber()

        do {

            //2. 숫자 입력받기
            print("숫자를 입력해주세요 : ")
            val userInput = readLine()
            val user: List<Int>

            try {
                user = processInputWithException(userInput)
            } catch (_: IllegalArgumentException) {
                println("ERROR: 잘못된 값을 입력하여, 프로그램을 종료 합니다.")
                break@loop
            }


            //3. 숫자 맞추기
            val (strike, ball) = baseballGame(user, computer)

            //3.1 출력형식
            val result = displyResult(strike, ball)
            println(result.joinToString(separator = " "))


        } while (strike < 3)

        //4. 종료 여부 확인

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        val isExit: Boolean
        val flag = readLine()

        isExit = try {

            when (flag) {
                "1" -> true
                "2" -> false
                else -> throw IllegalArgumentException()
            }

        } catch (_: IllegalArgumentException) {
            println("ERROR: 잘못된 값을 입력하여, 프로그램을 종료 합니다.")
            break@loop
        }

    } while (isExit)


}
