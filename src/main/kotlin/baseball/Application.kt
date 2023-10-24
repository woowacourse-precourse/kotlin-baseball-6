package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        // 컴퓨터 숫자 설정
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        // println(computer)

        while (true) {
            var user = mutableListOf<Int>()
            print("숫자를 입력해주세요 : ")
            var input = readLine()

            if (input?.length == 3) { // 입력이 세 자리인 경우
                for (char in input) {
                    val digit = char.toString().toIntOrNull()
                    if (digit != null) {
                        user.add(digit)
                    } else { // 숫자가 아닌 경우
                        throw IllegalArgumentException("Invalid input. Please enter a valid number.")
                    }
                }
            } else { // 입력이 잘못된 경우
                throw IllegalArgumentException("Invalid input. Please enter a valid number.")
            }

            // 볼, 스트라이크, 낫싱 판별
            var ball = 0
            var strike = 0
            // 볼 판별
            for (i in computer.indices) {
                for (j in user.indices) {
                    if (i != j) {
                        if (computer[i] == user[j]) {
                            ball = ball + 1
                        }
                    }
                }
            }

            // 스트라이크 판별
            for (i in computer.indices) {
                if (computer[i] == user[i]) {
                    strike = strike + 1
                }
            }

            if (ball == 0 && strike == 0) {
                println("낫싱")
            } else if (ball == 0) {
                println("$strike" + "스트라이크")
            } else if (strike == 0) {
                println("$ball" + "볼")
            } else {
                println("$ball" + "볼 " + "$strike" + "스트라이크")
            }

            if (strike == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break;
            }
        }

        // 게임 새로 시작(1), 종료(2)
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var ifStart = readLine().toString().toIntOrNull()
        if (ifStart != null) {
            if (ifStart == 1) {
                continue
            } else if (ifStart == 2) {
                break
            } else {
                throw IllegalArgumentException("Invalid input. Please enter a valid number.")
            }
        } else {
            throw IllegalArgumentException("Invalid input. Please enter a valid number.")
        }
    }
}

