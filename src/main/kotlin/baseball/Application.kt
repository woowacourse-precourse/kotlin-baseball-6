package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val SIZE = 3 // 리스트의 길이
    val computer = mutableListOf<String>()
    val user = mutableListOf<String>()
    var s = 0
    var b = 0
    var keep = 0

    println("숫자 야구 게임을 시작합니다.")
    do {
        s = 0
        computer.clear()
        while (computer.size < SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString() // 랜덤 수 생성
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        while (s != 3) {
            s = 0
            b = 0
            user.clear()
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
            } else if (b > 0 && s > 0) {
                println("${b}볼 ${s}스트라이크")
            } else if (s > 0) {
                println("${s}스트라이크")
                if (s == 3) {
                    println("${SIZE}개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                    keep = readLine()?.toIntOrNull() ?: 0
                }
            } else if (b > 0) {
                println("${b}볼")
            }
        }
    } while (keep == 1)
    println("게임 종료")
}
