package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    baseballGameMain()
}

private fun baseballGameMain() {
    val questionNums : MutableList<Char> = createQuestion()
    val userNums :  MutableList<Char> = inputNums()
    countHintNum(questionNums, userNums)
}

private fun createQuestion(): MutableList<Char> {
    val questionNums : MutableList<Char> = mutableListOf<Char>()
    while (questionNums.size < 3) {
        val curNum : Char = Randoms.pickNumberInRange(1, 9).toChar()
        if(!questionNums.contains(curNum)) {
            questionNums.add(curNum)
        }
    }
    return questionNums
}

private fun inputNums() : MutableList<Char> {
    val input : String = Console.readLine()
    checkInput(input.replace(" ", ""))
    return input.toMutableList()
}

private fun checkInput(input : String){
    if(input.length != 3) {throw IllegalArgumentException("3개의 숫자를 입력 해야 합니다.")}
    for(i in input){
        if(!i.isDigit()){throw IllegalArgumentException("숫자를 입력 해야 합니다.")}
        if (input.count { it == i } > 1) throw IllegalArgumentException("세 개의 다른 숫자를 입력 해야 합니다.")
    }
}



private fun countHintNum(questionNums : MutableList<Char>, userNums : MutableList<Char>): Array<Int> {
    var bollCnt : Int = 0
    var strikeCnt : Int = 0

    for(i in userNums.indices){
        if(questionNums[i] == userNums[i]){
            strikeCnt += 1
        }
        if(questionNums[i] != userNums[i] && questionNums.contains(userNums[i])){
            bollCnt += 1
        }
    }

    return arrayOf(bollCnt, strikeCnt)
}



