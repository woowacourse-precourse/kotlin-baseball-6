package baseball
import kotlin.random.Random

fun main() {

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Random.nextInt(1, 10)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    println("숫자 야구 게임을 시작합니다.")
    var isCorrect = false

    while (!isCorrect) {
        print("숫자를 입력해주세요 : ")
        val inputNum = readLine()
        if (inputNum != null && inputNum.length== 3 && inputNum.all{ it.isDigit() }) {
            val myNum = inputNum.map { it.toString().toInt() }
            val result = checkNum(computer, myNum)
            if (result == "3스트라이크") {
                isCorrect = true
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            } else {
                println(result)
            }
        }
    }
}

fun checkNum(num: List<Int>, myNum: List<Int>): String {
    var ball = 0
    var strike = 0

    for (i in num.indices) {
        if (myNum[i] == num[i]) {
            strike++
        } else if (myNum[i] in num) {
            ball++
        }
    }

    return when {
        strike > 0 && ball > 0 -> "${ball}볼 ${strike}스트라이크"
        strike > 0 -> "${strike}스트라이크"
        ball > 0 -> "${ball}볼"
        else -> "아웃"
    }
}
