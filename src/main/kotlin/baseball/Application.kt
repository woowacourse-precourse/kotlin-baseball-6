package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    var oneOrTwo: Int = 1
    var myAnswer: String
    var comAnswer: String

    println("숫자 야구 게임을 시작합니다.")

    while(oneOrTwo==1){
        print("숫자를 입력해주세요 : ")
        comAnswer = pickNumberInRange(100,999).toString()
        myAnswer = readLine()!!.toString()
        checkLengthAndNumeric(myAnswer)

        while(!AnswerCheck(myAnswer, comAnswer)){
            print("숫자를 입력해주세요 : ")
            myAnswer =  readLine()!!.toString()
        }
    }

}

fun checkLengthAndNumeric(s: String) {
    if (s.length != 3) {
        throw IllegalArgumentException("The length of the input must be 3")
    }

    if (!isNumeric(s)) {
        throw IllegalArgumentException("The input is not a valid number")
    }
}
fun isNumeric(s: String): Boolean {
    return try {
        s.toDouble()
        true
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException()
    }
}
fun AnswerCheck(myAnswer: String, comAnswer: String): Boolean{

    var numOfBall: Int = 0
    var numOfStrike: Int = 0

    val comList: List<String> = comAnswer.split("").subList(1,4)
    val myAnswerList: List<String> = myAnswer.split("").subList(1,4)

    comList.forEachIndexed { index, s ->
        if(myAnswerList.indexOf(s)!=-1){
            if(myAnswerList.indexOf(s)==index){
                numOfStrike++
            }else{
                numOfBall++
            }
        }
    }
    return myAnswer == comAnswer

}