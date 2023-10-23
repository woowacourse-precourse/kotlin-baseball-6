package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO("프로그램 구현")
    println("숫자 야구 게임을 시작합니다.")
    val ComNumber = ComRandomNum()
}

// 컴퓨터가 세자리 수의 랜덤값 생성
fun ComRandomNum(): MutableList<Char> {
    val computerNum = mutableListOf<Char>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toChar()
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}

// 잘못된 입력값 점검
fun CheckNum(numbers: MutableList<Char>){
    if (numbers.size != 3) throw IllegalArgumentException("세자리의 수가 아닙니다.")

    for (i in numbers.indices){
        val number = Integer.parseInt(numbers[i].toString())
        if(number < 1 || number > 9) throw IllegalArgumentException("1과 9부터의 수가 아닙니다.")
        if (numbers.count { it == numbers[i] } > 1) throw IllegalArgumentException("세 개의 숫자가 서로 달라야 합니다")
    }
}

// 사용자로부터 입력값 받기
fun inputNum(): MutableList<Char> {
    val input = Console.readLine()
    CheckNum(input.toMutableList())
    return input.toMutableList()
}