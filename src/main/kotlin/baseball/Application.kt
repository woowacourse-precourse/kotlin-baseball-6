package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    // 게임 실행
    do {
        // 야구 게임 시작
        println("숫자 야구 게임을 시작합니다.")
        // 랜덤한 3개의 숫자 생성
        val computer = createNumber()
        do {
            // 숫자 추론 하기
            val guessNum = guessNumber()
            // 정답인지 확인
            val check = checkNum(computer, guessNum)

        }
        // 정답이 아닌 경우 반복
        while (check)
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val restartNum= Console.readLine()?.toInt() ?: 0
        // 1인경우 재시작, 2인 경우 종료
        // 1 또는 2가 아닌 경우 예외 처리
        val resart = when(restartNum){
            1-> true
            2->false
            else->throw IllegalArgumentException("1또는 2를 입력 하세요.")
        }
    }
    //재시작을 원하는 경우 다시 실행
    while (resart)

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
    var guessNum : Int
    print("숫자를 입력해주세요 : ")
    try {
        guessNum = Console.readLine()?.toInt() ?: 0
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
        guessNum /= 10
        human.add(0,pickNumber)

    }
    return human
}

// 입력 받은 숫자를 판단해주는 함수
// 입력 : 정답 MutableList<Int> , 추론한 숫자 MutableList<Int>
// 출력 : 맞춘 경우 false, 틀린 경우 true를 출력
//  - 자리와 숫자가 일치하는 경우 1스트라이크 추가
//  - 자리가 틀리고 숫자가 존재하는 경우 1볼 추가
//  - 전부 다 틀린 경우 낫싱 출력
fun checkNum(computer : MutableList<Int>, guessNum:MutableList<Int>) : Boolean{
    var strike=0
    var ball=0
    for (i : Int in 0..2){
        // 위치와 숫자가 동일한 경우
        if (guessNum[i]==computer[i]){
            strike+=1
        }
        else {
            // 숫자는 동일하지만 자리가 틀린 경우
            for ( j : Int in 0..2){
                if(guessNum[i]==computer[j]){
                    ball+=1
                }
            }
        }
    }
    //볼이 있는 경우
    if(ball!=0) {
        //볼도 있고 스트라이크도 있는 경우
        if(strike!=0){
            println("${ball}볼 ${strike}스트라이크")
        }
        //볼만 있는 경우
        else {
            println("${ball}볼")
        }
    }
    //스트라이크만 있는 경우
    else if(strike!=0){
        println("${strike}스트라이크")
        if (strike==3){
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return false
        }
    }
    //아무 것도 없는 경우
    else{
        println("낫싱")
    }
    return true
}





