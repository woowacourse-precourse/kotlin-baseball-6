package baseball

fun compareNumber(computerNumber: List<Int>): Int {         // 숫자 비교하기
    print("숫자를 입력해주세요 : ")
    val userNumbers = inputNumber()
    var strikeCount: Int = 0
    var ballCount: Int = 0
    for (i in 0..2) {
        if (userNumbers[i] == computerNumber[i]) {
            strikeCount++
        } else if (computerNumber.contains(userNumbers[i])) {
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