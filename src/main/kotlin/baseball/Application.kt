package baseball

import camp.nextstep.edu.missionutils.Randoms //pickNumberInRange
import camp.nextstep.edu.missionutils.Console //readLine

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    val computer = mutableListOf<Int>()
    var stop = 1
    var reStart = 0
    
    while (stop == 1) {
        if (reStart == 0) {
            computer.clear()
            
            while (computer.count() < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber)
                }
            }
            reStart = 1
        }

        print("숫자를 입력해주세요 : ")
        
        var userNum = Console.readLine()
        if(userNum.length != 3) {
            throw IllegalArgumentException();  
        }

        var strike = 0
        var ball = 0
        var nothing = 0

        for (i: Int in 0..2) {
            if (computer.get(i) == Character.getNumericValue(userNum[i])) {
                strike++
            } else if (computer.contains(Character.getNumericValue(userNum[i]))) {
                ball++
            } else {
                nothing++
            }
        }
        
        if (strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            
            var re = Console.readLine().toInt()
            if (re != 1 && re != 2) {
                throw IllegalArgumentException();  
            }
            
            if (re == 2) {
                stop = 0
            } else {
                reStart = 0
            }
        } else if (nothing == 3) {
            println("낫싱")
        } else if (ball == 0) {
            println("${strike}스트라이크")
        } else if (strike == 0) {
            println("${ball}볼")
        } else {
            println("${ball}볼 ${strike}스트라이크")
        }
    }
}


