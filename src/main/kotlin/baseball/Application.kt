package baseball

import baseball.domain.Computer
import baseball.domain.GameLogic
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        val userNum = userInputNum()
        val game = GameLogic(Computer.computerNum, userNum)
        if(game.checkResult()) break
    }
}

fun userInputNum(): Int {
    print("숫자를 입력하세요: ")
    return Console.readLine().toInt()
}