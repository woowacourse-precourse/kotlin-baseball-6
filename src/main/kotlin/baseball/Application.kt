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

        while(true) {
            var cntBall = 0
            var cntStrike = 0

            print("숫자를 입력해주세요 : ")
            val user: String = Console.readLine()


            for (i in 0..2){
                if (computer[i]==user[i].digitToInt()){
                    cntStrike += 1
                } else {
                    if (user.contains(computer[i].toString())) {
                        cntBall += 1
                    }
                }
            }

            if(cntStrike==3){
                println("3스트라이크")
                break
            }

            if (cntBall==0){
                if (cntStrike==0){
                    println("낫싱")
                } else {
                    println("${cntStrike}스트라이크")
                }
            } else {
                if (cntStrike==0){
                    println("${cntBall}볼")
                } else {
                    println("${cntBall}볼 ${cntStrike}스트라이크")
                }
            }
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
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
