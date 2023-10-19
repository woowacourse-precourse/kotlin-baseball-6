package baseball

import camp.nextstep.edu.missionutils.Randoms

class NumberBaseball {
    val comnumber= mutableListOf<Int>()
    fun inputException() {
        if(comnumber.size!=3)
            throw IllegalArgumentException("입력된 숫자가 3개가 아닙니다.")
        for(index in 0 .. comnumber.size){
            if(!comnumber[index].toChar().isDigit())
                throw IllegalArgumentException("입력은 숫자만 가능합니다.")
        }
    }
    fun main() {
        TODO()
    }
}
