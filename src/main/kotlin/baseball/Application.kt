package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {

    while(true) {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        //computer.forEach { print(it) }


        println("숫자 야구 게임을 시작합니다.")

        while(true) {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine().trim()
            checkValidInput(input)
            val inputList = mutableListOf<Int>()
            input.forEach { inputList.add(it-'0') }
        }
    }

}

fun checkValidInput(input : String) {
    if(input.length != 3) throw IllegalArgumentException()
    for(i in input.indices){
        if(input[i] !in '1' .. '9') throw IllegalArgumentException()
        if(input[i] == input[(i+1)%3] || input[i] == input[(i+2)%3]) throw IllegalArgumentException()
    }
}

fun checkStrikes(random : MutableList<Int>, input : MutableList<Int>) : Int {
    var strikes = 0
    for(i in 0 until 3) {
        if(random[i] == input[i]) strikes++
    }
    return strikes
}
