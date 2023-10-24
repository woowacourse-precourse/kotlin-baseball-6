package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun getResult(strike : Int, ball : Int) : String {
    if (ball > 0 && strike > 0) {
        return ball.toString() + "볼 " + strike.toString() + "스트라이크"
    }
    if (ball > 0) {
        return ball.toString() + "볼"
    }
    if (strike > 0) {
        return strike.toString() + "스트라이크"
    }
    return "낫싱"
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    do {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        do {
            var strike : Int
            strike = 0
            var ball : Int
            ball = 0
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            if (input!!.length != 3) {
                throw IllegalArgumentException()
            }
            val splitInput = input.toCharArray()
            val me = mutableListOf<Int>()
            for (char in splitInput) {
                val numberOfInput : Int = Character.getNumericValue(char)
                if (numberOfInput !in 1..9) {
                    throw IllegalArgumentException()
                }
                me.add(numberOfInput)
            }

            for (i in 0..<3) {
                for (j in 0..<3) {
                    if (me[i] == computer[j]) {
                        if (i == j) {
                            strike++
                        }
                        else {
                            ball++
                        }
                    }
                }
            }

            println(getResult(strike, ball))
        } while (strike < 3)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val flag = Console.readLine()
        if (flag != "1" && flag != "2") {
            throw IllegalArgumentException()
        }
    } while (flag == "1")

}
