package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun createRandomNumbers(): List<Int>{
    var randomNumbers = mutableListOf<Int>()

    while(randomNumbers.size < 3){
        val number = Randoms.pickNumberInRange(1,9)
        if(!randomNumbers.contains(number)){
            randomNumbers.add(number)
        }
    }
    return randomNumbers
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")

}
