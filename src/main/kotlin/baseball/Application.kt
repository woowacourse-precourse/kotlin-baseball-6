package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 1. 게임 시작을 위한 세팅
    val answer = answerSelect()
//    println("answer : ${answer}")
    println("숫자 야구 게임을 시작합니다.")

    // 2. 사용자 입력
    println("숫자를 입력해주세요 : ")
    var inputData = Console.readLine()
    if(inputData.length != 3){ // 입력 자리수 검증
        throw IllegalArgumentException()
    }
    // 0~9 외의 숫자 검증
    else if(!inputData.all{it in CharRange(start = '0', endInclusive = '9')}){
        throw IllegalArgumentException()
    }
    println("inputData : ${inputData}")
}

fun answerSelect(): ArrayList<Int> {
    // 1. 게임 시작을 위한 세팅
    val computer = arrayListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}