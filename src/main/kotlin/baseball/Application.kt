package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main(){
    var keepPlaying: Boolean
    do {
        println("숫자 야구 게임을 시작합니다.")
        val cN = randNumber()
        var strikeCount = 0

        while (strikeCount != 3) {
            strikeCount = compareNumber(cN)
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        keepPlaying = readLine()?.toLowerCase() == "1"

    } while (keepPlaying)

    println("게임을 종료합니다.")
}
fun randNumber(): List<Int> {
    var computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun inputNumber(): List<Int> {
    var input = readLine()!!.toString()
    if(input.contains('0')
        || input.length !=3
        || ((input[0] == input[1]) || (input[1] == input[2]) || (input[2] == input[0]))) {
        throw IllegalArgumentException()
    }
    return input.map { it.toString().toInt() }
}

fun compareNumber(cN : List<Int>): Int {
    print("숫자를 입력해주세요 : ")
    val userNumbers = inputNumber()
    var strikeCount: Int = 0
    var ballCount: Int = 0
    for (i in 0..2) {
        if (userNumbers[i] == cN[i]) {
            strikeCount++
        } else if (cN.contains(userNumbers[i])) {
            ballCount++
        }
    }
    when {
        strikeCount != 0 && ballCount != 0 -> println("${ballCount}볼 ${strikeCount}스트라이크")
        strikeCount != 0 -> println("${strikeCount}스트라이크")
        ballCount != 0 -> println("${ballCount}볼")
        else -> println("낫싱")
    }
    return strikeCount
}








