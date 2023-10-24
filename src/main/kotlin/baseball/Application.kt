package baseball

import kotlin.collections.mutableListOf
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true){
        println("숫자 야구 게임을 시작합니다.")

        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        print("숫자를 입력해주세요 : ")
        val user: String = Console.readLine()


        if (computer[1]==user[1].digitToInt()){
            println("맞습니다.")
        } else {
            continue
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val choice = Console.readLine()
        if (choice=="2") {
            break
        } else if (choice=="1"){
            continue
        } else (
            throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
        )
    }
}
