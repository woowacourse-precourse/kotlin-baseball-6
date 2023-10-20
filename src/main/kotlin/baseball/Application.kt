package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun randomNum(): String {
    val number= mutableListOf<Int>()
    while (number.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!number.contains(randomNumber)) {
            number.add(randomNumber)
        }
    }
    val computer = number.joinToString("")
    return computer
}
fun getUserNum(): String {
    print("숫자를 입력해주세요 : ")
    return Console.readLine()
}
fun checkNum(computerNumber: String, userNumber: String): String {
    var strikes = 0
    var balls = 0

    for (i in computerNumber.indices) {
        if (computerNumber[i] == userNumber[i]) { //computerNumber[i]의 값이랑 userNumber[i]의 값이 같을때
            strikes++ // strikes up
        } else if (computerNumber.contains(userNumber[i])) { //computerNumber 리스트 안에 userNumber[i]가 포함되면
            balls++ //balls up
        }
    }

    return when {
        strikes == 3 -> "3 스트라이크!"
        strikes > 0 || balls > 0 -> "$strikes 스트라이크, $balls 볼"
        else -> "낫싱"
    }
}
fun validateUser(guess: String) {
    if (guess.length != 3 || guess.toSet().size != 3 || guess.any { it !in '1'..'9' }) {
        throw IllegalArgumentException()
    }
}
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = randomNum()
    while (true){
        val user = getUserNum()
        validateUser(user)
        try {
            val result = checkNum(computer,user)
            println(result)
        } catch (e:IllegalArgumentException){
            break
        }
    }

}
