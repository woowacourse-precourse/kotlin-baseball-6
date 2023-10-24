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

fun hasDuplicateDigits(number: Int): Boolean {
    val digits = number.toString().toCharArray()
    return digits.toSet().size != digits.size
}

fun compareNumbers(number1: Int, number2: Int): String {
    val str1 = number1.toString()
    val str2 = number2.toString()

    var strike = 0
    var ball = 0

    for (i in str1.indices) {
        if (str1[i] == str2[i]) strike++
        else if (str1.any { it == str2[i] }) ball++
    }

    return when{
        strike == 0 && ball == 0 -> "낫싱"
        strike == 0 -> "$ball"+"볼"
        ball == 0 -> "$strike"+"스트라이크"
        else -> "$ball"+"볼 "+"$strike"+"스트라이크"
    }
}
fun main() {

    println("숫자 야구 게임을 시작합니다.")
    var number = generateRandomNumber()

    while(true) {

        print("숫자를 입력해주세요 : ")
        val numString = Console.readLine() ?: throw IllegalArgumentException("[Error]")
        val numInt= numString.toIntOrNull() ?: throw IllegalArgumentException("[Error]")

        if(numString.length != 3 || !numString.all { it.isDigit() } || hasDuplicateDigits(numInt)){
            throw IllegalArgumentException("[Error]")
        }

        println(compareNumbers(numInt, number))

        if(numInt.equals(number)){
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

            when(Console.readLine()?.toIntOrNull()){
                null -> throw IllegalArgumentException("[Error]")
                2 -> break
                else->{
                    number=generateRandomNumber()
                }
            }

        }
    }
}