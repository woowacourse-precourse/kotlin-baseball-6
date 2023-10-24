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
    }
}


