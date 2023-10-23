package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun makeSecretNumber(): String {
    val stringBuilder = StringBuilder()
    repeat(3) {
        val randomNumber = Randoms.pickNumberInRange(0,9)
        stringBuilder.append(randomNumber)
    }
    return stringBuilder.toString()
}
fun main() {
    var secretNumber = makeSecretNumber()
}
