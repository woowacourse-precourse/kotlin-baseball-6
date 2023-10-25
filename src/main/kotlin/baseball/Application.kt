package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

fun getRandomNumber (): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun checkNumberFormat (numberStringFormat : String) : Int {
    var number = 0
    // 숫자로 변환 불가능 시 에러 발생
    try {
        number = numberStringFormat.toInt()
    }
    catch (e: NumberFormatException){
        throw IllegalArgumentException()
    }

    return number
}

fun compareNumberList (computer : MutableList<Int>, user : MutableList<Int>) : Pair<Int, Int>{
    // 정답 비교에 필요한 변수 선언
    var strike = 0
    var ball = 0

    // c. 정답과 각 자리 비교해서 변수 ball, strike 증가
    for (i in 0 until  computer.size){
        for (j in 0 until user.size){
            if (computer[i] == user[j]){
                if ( i == j ) strike++
                else ball++
            }
        }
    }

    return Pair(strike, ball)

}

fun printResult(strike : Int, ball: Int) : Boolean{
    // d. 값에 맞는 결과값 출력
    if (ball + strike == 0) println("낫싱")
    else if ( strike == 3) {
        println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return false
    }
    else {
        if (strike == 0)
            println("${ball}볼")
        else if ( ball == 0 )
            println("${strike}스트라이크")
        else
            println("${ball}볼 ${strike}스트라이크")
    }
    return true
}
fun playGame(computer: MutableList<Int>) {
    // 게임 재시작 여부
    var switch = true

    // ii. 반복
    while (switch) {
        // a. 숫자 입력 문구 출력
        print("숫자를 입력해주세요 : ")

        var userList = mutableListOf<Int>()
        var userNumber = 0

        // b. 입력값 받기 -> 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료
        val userNumberStringFormat = Console.readLine()
        userNumber = checkNumberFormat(userNumberStringFormat)

        // 숫자로 입력된 값을 리스트로 변환
        while (userNumber > 0) {
            userList.add(0, userNumber % 10)
            userNumber /= 10
        }

        // 세 자리 수가 아니거나 중복되는 수가 있으면 에러 발생
        userList = userList.distinct().toMutableList()
        if (userList.size != 3) throw IllegalArgumentException()


        // c. 정답과 각 자리 비교해서 변수 ball, strike 증가
        val (strike, ball) = compareNumberList(computer, userList)

        // d. 값에 맞는 결과값 출력
        switch = printResult(strike, ball)


    }

}

fun main() {
    // 1. 게임 시작 문구 출력
    println("숫자 야구 게임을 시작합니다.")


    // 2. 반복
    while(true){
        // i. 정답 값 random 지정
        val computer = getRandomNumber()

        // 게임 시작
        playGame(computer)

        // iii. 재시작 여부 문구 출력
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        // iv. 입력값 받기 -> 2이면 반복 종료
        if (Console.readLine().toInt() == 2) break
    }
}
