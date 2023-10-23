package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private const val START_INCLUSIVE = 1    // 1부터
private const val END_INCLUSIVE = 9    // 9까지
const val COUNT = 3    // 3자리 수를 맞추는 게임
private const val RESTART = "1"    // 재시작 상수
private const val TERMINATION = "2"    // 종료 상수

val answer = IntArray(COUNT) // 정답 저장할 배열

fun run() {
    try {
        setGame()
        playGame()
        askRestart()
    } catch (e: IllegalArgumentException){
        throw IllegalArgumentException("올바르지 않은 입력값입니다.", e)
    }
}

private fun setGame() {
    // 랜덤한 수를 answer 배열에 저장해 게임의 정답을 셋팅함
    for(i in 0 until COUNT) { answer[i] = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) }
}

private fun playGame() {
    do {
        val userInput = getUserNumber()    // 수 입력 받기
        val (strike, ball) = answerCheck(answer, userInput)    // 입력 받은 수 검사
        printResult(strike, ball)    // 결과 출력
    } while (strike != COUNT)    // strike수가 COUNT와 같으면 반복문 탈출
    println("${COUNT}개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

private fun getUserNumber(): IntArray {
    print("숫자를 입력해주세요 : ")
    val readLine = Console.readLine().split("").drop(1).dropLast(1)    // split함수의 시작과 끝에 추가되는 빈 문자열 제거
    return readLine.map { it.toInt() }.toIntArray()    // 사용자 입력값을 정수형 배열로 변환해서 반환함
}

private fun printResult(strike: Int, ball: Int) {
    when {
        strike == 0 && ball == 0 -> println("낫싱")    // 하나도 없는 경우
        strike > 0 && ball == 0 -> println("${strike}스트라이크")    // 스트라이크만 있는 경우
        ball > 0 && strike == 0 -> println("${ball}볼")    // 볼만 있는 경우
        else -> println("${ball}볼 ${strike}스트라이크")    // 볼과 스트라이크가 같이 있는 경우
    }
}

private fun askRestart() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val userInput = Console.readLine()
    when(userInput) {
        RESTART -> run()    // 사용자가 "1"을 입력했으면 게임 재시작
        TERMINATION -> return    // 사용자가 "2"를 입력했으면 함수 종료 (게임 종료)
        else -> throw IllegalArgumentException("올바르지 않은 입력값입니다.")
    }
}
