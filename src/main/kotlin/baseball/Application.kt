package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun isCheck(s: String): Boolean {
    if(s.length != 3) throw IllegalArgumentException()
    return try {
        s.toInt()
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}

fun main() {
    //TODO("프로그램 구현")
    var flag:Boolean = true //flag of start
    while(flag) {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        //computer select random number
        while(true) {
            var strike:Int = 0
            var ball:Int = 0
            //variable strike and ball
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            //input
            isCheck(input)
            //check isNum and length == 3
            for(i in 0..2) {
                if(Character.getNumericValue(input[i]) == computer[i]) {
                    strike++
                }
                //check strike
                else {
                    for(j in 0..2) {
                        if(i == j) continue
                        if(Character.getNumericValue(input[i]) == computer[j]) {
                            ball++
                        }
                    }
                }
                //check ball
            }
            if(strike == 0 && ball == 0)
                println("낫싱")
            else if(strike == 3) {
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
            else {
                if(ball > 0)
                    print("${ball}볼 ")
                if(strike > 0)
                    print("${strike}스트라이크")
                print("\n")
            }
            //print strike and ball
            //check strike == 3
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        while(true) {
            val temp = Console.readLine()
            if(temp == "1") {
                flag = true
                break
            }
            else if(temp == "2") {
                flag = false
                break
            }
            else println("다시 입력해주세요")
        }
        //restart game
    }
}
