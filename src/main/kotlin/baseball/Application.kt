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
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var number = generateRandomNumber()
    while(true) {
        print("숫자를 입력해주세요 : ")
        val num = Console.readLine()
        if(num.length != 3 || !num.all { it.isDigit() } || hasDuplicateDigits(num.toInt())){
            throw IllegalArgumentException("[Error]")
        }
    }
}