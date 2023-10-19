package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    var ball = 0
    var strike = 0

    var computerRandomNumbers = getRandomNumber()
    println(computerRandomNumbers)
    println("숫자 야구 게임을 시작합니다.")

//    var userNumbers = Console.readLine().replace("\\s".toRegex(), "")
//    isThreeDigitNumber(userNumbers)

    while (strike != 3) {
        println("숫자를 입력해주세요 : ")
        val userNumbers = Console.readLine().replace("\\s".toRegex(), "")
        isThreeDigitNumber(userNumbers)
        ball = 0
        strike = 0

        for (i in computerRandomNumbers.indices) {
            if (computerRandomNumbers[i] == userNumbers.chunked(1)[i].toInt())
                strike++
            for (j in userNumbers.indices) {
                if (i != j && computerRandomNumbers[i] == userNumbers.chunked(1)[j].toInt())
                    ball++
            }
        }

        when {
            strike == 3 -> {
                println("3 스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

                val inputOneIsPlayTwoIsDone = Console.readLine().replace("\\s".toRegex(), "")
                when (inputOneIsPlayTwoIsDone) {
                    "1" -> {
                        computerRandomNumbers = getRandomNumber()
                        println(computerRandomNumbers)
                        strike = 0
                    }
                    "2" -> {
                        println("게임 종료")
                    }
                    else -> throw IllegalArgumentException("1과2중 에서만 입력해주세요")
                }
            }
            ball == 0 && strike == 0 -> println("낫싱")
            ball != 0 && strike != 0 -> println("$ball 볼 $strike 스트라이크")
            ball == 0 && strike != 0 -> println("$strike 스트라이크")
            else -> println("$ball 볼")
        }
    }

}

fun isThreeDigitNumber(number: String): Boolean {
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

fun getRandomNumber(): MutableList<Int> {
    val computerRandomNumbers = mutableListOf<Int>()

    while (computerRandomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if (!computerRandomNumbers.contains(randomNumber)) {
            computerRandomNumbers.add(randomNumber)
        }
    }
    return computerRandomNumbers
}
