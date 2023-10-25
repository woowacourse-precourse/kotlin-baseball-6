package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO("프로그램 구현")
    EndGame()
}

// 컴퓨터가 세자리 수의 랜덤값 생성
fun ComRandomNum(): MutableList<Char> {
    var computerNum = mutableListOf<Char>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
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
        if( number < 1 || number > 9) throw IllegalArgumentException("1과 9부터의 수가 아닙니다.")
        if (numbers.count { it == numbers[i] } > 1) throw IllegalArgumentException("세 개의 숫자가 서로 달라야 합니다")
    }
}

// 사용자로부터 입력값 받기
fun InputNum(): MutableList<Char> {
    val input = Console.readLine()
    CheckNum(input.toMutableList())
    return input.toMutableList()
}

// 스트라이크와 볼 개수 계산
fun GameNum(userNum: MutableList<Char>, randNum: MutableList<Char>): MutableList<Int> {
    var ball = 0
    var strike = 0

    for (i in userNum.indices){
        if(userNum[i] == randNum[i]){
            strike += 1
        } else if (randNum.contains(userNum[i])){
            ball += 1
        }
    }
    return mutableListOf(ball, strike)
}

// 스트라이크 볼 개수 출력
fun GamePrint(gameNum: MutableList<Int>){
    var ball = gameNum[0]
    var strike = gameNum[1]
    if (ball != 0) print("${ball}볼")
    if (strike != 0) print("${strike}스트라이크")
    if (ball == 0 && strike == 0) print("낫싱")
    println()
}

// 게임 시작과 종료
fun PlayGame() {
    var randNums = ComRandomNum()
    while (true) {
        print("숫자를 입력해주세요 :")
        var userNums = InputNum()
        var gameNums = GameNum(userNums, randNums)
        GamePrint(gameNums)
        if(gameNums[1] == 3){
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }
}

// 게임 재개 및 끝
fun EndGame() {
    var EndNum: Int
    println("숫자 야구 게임을 시작합니다.")
    while(true) {
        PlayGame()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        EndNum = Console.readLine().toInt()
        if(EndNum != 1 && EndNum != 2) throw IllegalArgumentException("1 또는 2를 입력하세요")
        if(EndNum == 2) break
    }
}
