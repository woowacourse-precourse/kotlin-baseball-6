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