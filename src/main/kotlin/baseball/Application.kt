package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var ans : MutableList<Int> = createQuestion()
    guessNums()
}

private fun createQuestion(): MutableList<Int> {
    val questionNums : MutableList<Int> = mutableListOf<Int>()
    while (questionNums.size < 3) {
        val curNum : Int = Randoms.pickNumberInRange(1, 9)
        if(!questionNums.contains(curNum)) {
            questionNums.add(curNum)
        }
    }
    return questionNums
}

private fun guessNums(){
    val input : String = Console.readLine()
    checkInput(input.replace(" ", ""))

}

private fun checkInput(input : String){
    if(input.length != 3) {
        throw IllegalArgumentException("3개의 숫자를 입력 해야 합니다.")
    }

    for(i in input){
        if(!i.isDigit()){throw IllegalArgumentException("숫자를 입력 해야 합니다.")}
        if (input.count { it == i } > 1) throw IllegalArgumentException("세 개의 다른 숫자를 입력 해야 합니다.")
    }

}

