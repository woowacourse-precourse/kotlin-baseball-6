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
    }

}