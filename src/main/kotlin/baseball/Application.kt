package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun generateRandomNumber(): Int {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("").toInt()
}
fun hasDuplicateDigits(number: Int): Boolean{
    val digits = number.toString().toCharArray()
    return digits.toSet().size != digits.size
}
fun compareNumbers(number1: Int, number2: Int): String {
    val str1 = number1.toString()
    val str2 = number2.toString()
    var strike = 0
    var ball = 0
    for (i in 0 until minOf(str1.length, str2.length)) {
        if (str1[i] == str2[i]) {
            strike++
        } else if (str1.any { it == str2[i] }) {
            ball++
        }
    }
    return if(strike == 0 && ball == 0){
        "낫싱"
    }else if(strike == 0) {
        "$ball"+"볼"
    }else if(ball == 0){
        "$strike"+"스트라이크"
    }else{
        "$ball"+"볼 "+"$strike"+"스트라이크"
    }
}
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var number = generateRandomNumber()
    while(true) {
        print("숫자를 입력해주세요 : ")
        val num = Console.readLine()
        if(num.length != 3 || !num.all { it.isDigit() } || hasDuplicateDigits(num.toInt())){
            throw IllegalArgumentException("[Error]")
        }
        println(compareNumbers(num.toInt(), number));
        if(num.toInt().equals(number)){
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }
}