package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    print("숫자를 입력해주세요 : ")
    val you = inputAndValidate()

}

fun inputAndValidate(): List<Int> {
    val input = Console.readLine()
    return validate(input)
}

fun validate(input: String): List<Int> {
    if(input.length > 3) {
        IllegalArgumentException("3자리 이상을 입력하였습니다.")
    }
    val numbers = input.toList().map { Character.getNumericValue(it) }
    for (number in numbers) {
        if (number !in (1..9)) {
            IllegalArgumentException("수를 잘못 입력하였습니다.")
        }
    }
    return numbers
}