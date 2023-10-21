package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gamePlay()
}
//야구 게임 진행
fun gamePlay() {
    println("숫자 야구 게임을 시작합니다.")
    var computer = makeComputerNumber()
    println("컴퓨터 숫자 : $computer")
    while(true) {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        try {
            inputUserNumber(input)
        } catch (e: IllegalArgumentException) {
            break
        }
        val result = calCount(computer, input)
        println(result)
        if(result.equals("3스트라이크")) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val reInput = Console.readLine()
            if(reInput[0] == '1') {
                computer = makeComputerNumber()
                println("컴퓨터 숫자 : $computer")
                continue
            }
            else if (reInput[0] == '2') {
                break
            }
        }
    }
}

//컴퓨터의 수를 생성하는 함수
fun makeComputerNumber() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputUserNumber(input: String) {
    if(input.length != 3) {
        throw IllegalArgumentException("3자리 수를 입력하지 않았습니다.")
    }
}

fun calCount(computer: MutableList<Int>, input: String) : String {
    var ball = 0
    var strike = 0
    for(i: Int in 0..2) {
        val c = computer[i]
        val u = input[i] - '0'
        if(c == u) {
            strike += 1
        }
    }
    val c1 : Int = computer[0]
    val c2 : Int = computer[1]
    val c3 : Int = computer[2]
    val u1 : Int = input[0] - '0'
    val u2 : Int = input[1] - '0'
    val u3 : Int = input[2] - '0'
    if(u1 == c2 || u1 == c3) {
        ball += 1
    }
    if(u2 == c1 || u2 == c3) {
        ball += 1
    }
    if(u3 == c1 || u3 == c2) {
        ball += 1
    }
    if(strike == 0 && ball == 0) {
        return "낫싱"
    }
    else if(strike == 3) {
        return "${strike}스트라이크"
    }
    else if(strike == 0) {
        return "${ball}볼"
    }
    else if(ball == 0) {
        return "${strike}스트라이크"
    }
    else {
        return "${ball}볼 ${strike}스트라이크"
    }
}
