package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val SIZE = 3 // 리스트의 길이
    val computer = mutableListOf<String>()
    val user = mutableListOf<String>()
    var s = 0
    var b = 0

    while (computer.size < SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString() // 랜덤 수 생성
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    print("숫자를 입력해주세요 : ")
    val userNumber = readLine() ?: throw IllegalArgumentException("입력값이 NULL")// 사용자에게 입력받기
    for (i in 0 until SIZE) {
        user.add(userNumber[i].toString())
    }

    for (i in 0 until SIZE) {
        for (j in 0 until SIZE) {
            if (computer[i] == user[j]) {
                if (i == j) {
                    s++
                } else {
                    b++
                }
            }
        }
    }
    if (b == 0 && s == 0) {
        println("낫싱")
    }

    println(computer)
    println(user)
}
