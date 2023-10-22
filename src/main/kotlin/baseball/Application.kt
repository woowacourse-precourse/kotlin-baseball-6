package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var startOrExit = 1
    while (startOrExit == 1) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        startOrExit = Console.readLine().toInt()
    }
}
