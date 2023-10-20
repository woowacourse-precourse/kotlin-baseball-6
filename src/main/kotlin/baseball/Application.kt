package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    // 랜덤한 3개의 숫자 생성
    val computer = createNumber()
    //야구 게임 시작
    println("숫자 야구 게임을 시작합니다.")
    val guessNum = guessNumber()

}

//컴퓨터가 랜덤한 3개의 숫자를 생성하는 함수
// 입력 : X
// 출력 : 랜덤한 숫자 3개가 담긴 MutableList<Int>
fun createNumber () :MutableList<Int> {
    val computer :MutableList<Int>  = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

//3자리의 숫자를 입력 받는 함수
// 입력 : X
// 출력 : 입력 받은 숫자 3개가 담긴 MutableList<Int>
// 예외 : 잘못된 입력을 받는 경우 "IllegalArgumentException" 발생
fun guessNumber() : MutableList<Int> {
    val human :MutableList<Int>  = mutableListOf()
    var guessNum : Int =0
    print("숫자를 입력해주세요 : ")
    try {
        guessNum = readLine()?.toInt() ?: 0
    } catch (ex: NumberFormatException){
        throw IllegalArgumentException("숫자를 입력해 주세요")
    }
    // 4자리 이상의 숫자 입력 시 오류 발생
    if (guessNum>999){
        throw IllegalArgumentException("3자리의 숫자를 입력해 주세요.")
    }
    // 0 이하의 숫자 입력시 오류 발생
    else if (guessNum<1){
        throw IllegalArgumentException("3자리의 숫자를 입력해 주세요.")
    }
    // 입력 받은 3자리의 숫자를 리스트에 삽입
    while (human.size < 3) {
        val pickNumber = guessNum%10
        // 0이 포함되는 경우 오류 발생
        if (pickNumber==0) {
            throw IllegalArgumentException("0이 포함될 수 없습니다.")
        }
        // 중복된 숫작가 있는 경우 오류 발생
        else if (human.contains(pickNumber)) {
            throw IllegalArgumentException("서로 다른 수를 넣어야합니다.")
        }
        guessNum=guessNum/10
        human.add(0,pickNumber)

    }
    return human

}





