package baseball

import camp.nextstep.edu.missionutils.Randoms //Random 값 추출 - pickNumberInRange()
import camp.nextstep.edu.missionutils.Console //사용자 입력 값 - readLine()

fun main() {

    // 게임 시작
    println("숫자 야구 게임을 시작합니다.")
    startBaseballPlay()

}

fun startBaseballPlay() {

    // 컴퓨터 랜덤 값 생성
    val computerRandomNum = createComputerRandomNum().joinToString("")

    // 플레이어 입력 값
    val playerAnswer = inputPlayerNum().joinToString("")

    println(computerRandomNum)
    println(playerAnswer)

    if (compareComputerAndPlayer(computerRandomNum, playerAnswer) == 0) {
        baseballHint(computerRandomNum, playerAnswer)
    } else {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}

fun createComputerRandomNum(): MutableList<Int> {

    val computerNum = mutableListOf<Int>()
    // list 크기 3 미만, 즉 3글자가 아닐경우 1~9 사이 랜덤값 생성
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        // 서로 다른 수만 생성
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    // list 공백 제거하고 문자열로
    return computerNum
}

fun inputPlayerNum(): MutableList<Char> {

    val playerNum = mutableListOf<Char>()

    print("숫자를 입력해주세요 : ")
    val inputPlayer = Console.readLine()

    for (index in 0..inputPlayer.length - 1) {
        playerNum.add(inputPlayer[index])
    }
    return playerNum
}

fun compareComputerAndPlayer(computer: String, player: String): Int {
    if (computer == player) {
        return 1
    } else {
        return 0
    }
}

fun baseballHint(computer: String, player: String) {

    var strike = 0
    var ball = 0

    for (index in 0..2) {
        if (computer[index] == player[index]) {
            strike++
        }
        if (computer.contains(player[index])) {
            ball++
        }
    }

    when {
        (strike == 0 && ball == 0) -> println("낫싱")
        (strike != 0 && ball == 0) -> println("${strike}스트라이크")
        (strike == 0 && ball != 0) -> println("${ball}볼")
        (strike != 0 && ball != 0) -> println("${ball}볼 ${strike}스트라이크")
//        else -> 오류 처리?
    }
}