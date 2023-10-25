package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    do{
        baseballGameMain()
    } while (inputToContinue() == 1)
}

private fun baseballGameMain() {
    val questionNums : MutableList<Char> = createQuestion()

    do{
        print("숫자를 입력해주세요 : ")
        val userNums :  MutableList<Char> = inputNums()
        val hintNums : Array<Int> = countHintNum(questionNums, userNums)
        printHint(hintNums)
    } while (hintNums[1] < 3)
}

private fun createQuestion(): MutableList<Char> {
    var questionNums : String = ""
    while (questionNums.length < 3) {
        val curNum : String = Randoms.pickNumberInRange(1, 9).toString()
        if(!questionNums.contains(curNum)) {
            questionNums += curNum
        }
    }

    return questionNums.toMutableList()
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

private fun printHint(hintNums : Array<Int>) {
    val hintStatement : StringBuilder = StringBuilder()

    if (hintNums[0] != 0) hintStatement.append("${hintNums[0]}볼 ")
    if (hintNums[1] != 0) hintStatement.append("${hintNums[1]}스트라이크")
    if (hintNums[0] == 0 && hintNums[1] == 0) hintStatement.append("낫싱")

    println(hintStatement)
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

private fun inputToContinue() : Int {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val continueNum : Int = Console.readLine().toInt()
    if (continueNum != 1 && continueNum != 2) throw IllegalArgumentException("1 또는 2를 입력하세요")

    return continueNum
}


