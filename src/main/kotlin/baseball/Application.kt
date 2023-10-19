package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    val computerRandomNumbers = mutableListOf<Int>()

    while (computerRandomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if (!computerRandomNumbers.contains(randomNumber)) {
            computerRandomNumbers.add(randomNumber)
        }
    }

    println(computerRandomNumbers)
    println("숫자 3개 입력")

    var userNumbers = Console.readLine().replace("\\s".toRegex(), "")

    while (isThreeDigitNumber(userNumbers) != "pass") {
        //값비교
        println(isThreeDigitNumber(userNumbers))
        userNumbers = Console.readLine().replace("\\s".toRegex(), "")
    }
}

fun isThreeDigitNumber(number: String) : String {
    if (number.isBlank())
        return "입력 하지 않았습니다"
    if (!number.all { it.isDigit()})
        return "숫자를 입력 해 주세요"
    if (number.length != 3)
        return "세자리수를 입력 해주세요"
    if (number.chunked(1).distinct().size != 3)
        return "중복된 숫자는 입력 불가 합니다"
    return "pass"
}
