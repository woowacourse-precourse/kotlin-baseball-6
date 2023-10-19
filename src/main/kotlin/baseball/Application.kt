package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    val computerRandomNumbers = mutableListOf<Int>()

    while (computerRandomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if (!computerRandomNumbers.contains(randomNumber)) {
            computerRandomNumbers.add(randomNumber)
        }
    }

    println(computerRandomNumbers)
    println("숫자 야구 게임을 시작합니다.")
    println("숫자를 입력해주세요 : ")

    var userNumbers = Console.readLine().replace("\\s".toRegex(), "")
    isThreeDigitNumber(userNumbers)

}

fun isThreeDigitNumber(number: String) : Boolean {
    if (number.isBlank())
        throw IllegalArgumentException("비어있습니다")
    if (!number.all { it.isDigit()})
        throw IllegalArgumentException("숫자만 입력 해 주세요")
    if (number.contains("0"))
        throw IllegalArgumentException("1~9사이 숫자만 입력 해주세요")
    if (number.length != 3)
        throw IllegalArgumentException("세자리수를 입력 해주세요")
    if (number.chunked(1).distinct().size != 3)
        throw IllegalArgumentException("중복된 숫자는 입력 불가 합니다")
    return true
}
