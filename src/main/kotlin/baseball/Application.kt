package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    do {
        val answer = generateAnswer()   //정답 생성
        playGame(answer)                //게임 시작
        var check = isRestart()         //재시작 여부
    } while (check[0] == 1)
}

fun generateAnswer(): ArrayList<Int> {
    // 1. 게임 시작을 위한 세팅
    val computer = arrayListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun readInput(): IntArray {
    // 2. 사용자 입력
    print("숫자를 입력해주세요 : ")
    var inputData = Console.readLine()?.toCharArray()?.map { it.toString().toInt() }?.toIntArray()

    if (isValidInput(inputData, 3, 1..9)) return inputData!!
    throw IllegalArgumentException()
}

fun isRestart(): IntArray {
    // 4. 게임 종료 후 재시작 or 종료 입력받기
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var inputData = Console.readLine()?.toCharArray()?.map { it.toString().toInt() }?.toIntArray()

    if (isValidInput(inputData, 1, 1..2)) return inputData!!
    throw IllegalArgumentException()
}

//유효값 검증 함수
fun isValidInput(input: IntArray?, size: Int, range: IntRange): Boolean {
    return input != null && input.size == size && input.all { it in range } && input.toSet().size == size
}

fun playGame(answer: ArrayList<Int>) {
    // 3. Ball, Strike 검증 및 결과 출력

    println("숫자 야구 게임을 시작합니다.")

    var strike = 0

    while (strike != 3) {
        strike = 0
        var ball = 0

        val inputData = readInput()

        for ((index, i) in answer.withIndex()) {
            if (answer[index] == inputData[index]) strike++
            if (i in inputData) ball++
        }
        ball -= strike
        if (strike == 0 && ball == 0) {
            println("낫싱")
        } else {
            if (ball != 0) {
                print("${ball}볼 ")
            }
            if (strike != 0) {
                print("${strike}스트라이크")
            }
            println()
        }
    }
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}