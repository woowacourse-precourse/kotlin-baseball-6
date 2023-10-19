package baseball

import camp.nextstep.edu.missionutils.Randoms

class NumberBaseball {
    val computerNumber= mutableListOf<Int>()
    val userNumber= mutableListOf<String>()
    private fun inputException(inputNumber:MutableList<String>) {
        if(inputNumber.size!=3)
            throw IllegalArgumentException("입력된 숫자가 3개가 아닙니다.")
        for(index in 0 .. inputNumber.size){
            if(!(inputNumber[index].toInt() in 49..57))
                //아스키 코드표상 49가 숫자 1 57이 9이므로 이 사이에 없다면 숫자가 아닌 것
                throw IllegalArgumentException("입력은 숫자만 가능합니다.")
            if(inputNumber[index]==inputNumber[index+1])
                throw IllegalArgumentException("숫자의 중복 여부를 확인해주세요")
        }
    }
    fun createComputerNumber(){
        while(computerNumber.size<3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
    }
    fun startUser(){
        println("숫자를 입력해주세요 : ")

    }
    fun readInputNumber(){
        startUser()
        var userInput= readLine().toString()
        userNumber.add(userInput)
        inputException(userNumber)
    }
    fun gameStart(){
        println("숫자 야구 게임을 시작합니다.")
    }
    fun main() {
       gameStart()
    }
}
