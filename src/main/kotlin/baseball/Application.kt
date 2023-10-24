package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 기본적으로 3자리로 설정한다.
    val baseballLength = 3
    println("숫자 야구 게임을 시작합니다.")

    // 게임을 종료할 때까지 무한 반복
    while (true) {
        val computer = mutableListOf<Int>()

        // 배열에 겹치지 않는 숫자들을 추가
        while (computer.size < baseballLength) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        // 3자리 모두 맞출 때까지 무한 반복
        while (true) {
            print("숫자를 입력해주세요 : ")
            val number = Console.readLine()

            // null, 정수, 입력 자리수 체크
            if (number != null && number.chars()
                    .allMatch { Character.isDigit(it) } && number.length == baseballLength
            ) {
                // 겹치지 않는 숫자 체크와 1-9 사이 체크
                for (i in 0..<baseballLength) {
                    if (number.count { it == number[i] } > 1 || Character.getNumericValue(number[i]) == 0) {
                        throw IllegalArgumentException()
                    }
                }

                var strike = 0
                var ball = 0

                // 자리가 같으면 strike, 포함만 되어있다면 ball에 1을 추가한다
                for (i in 0..<baseballLength) {
                    if (computer[i] == Character.getNumericValue(number[i])) {
                        strike++
                    } else if (computer.contains(Character.getNumericValue(number[i]))) {
                        ball++
                    }
                }


                if (ball > 0 || strike > 0) {
                    // 만약 ball이랑 strike가 1 이상일 경우, 공백도 포함하여 출력한다.
                    var result = ""
                    if (ball > 0) {
                        result += "${ball}볼"
                    }
                    if (ball > 0 && strike > 0) {
                        result += " "
                    }
                    if (strike > 0) {
                        result += "${strike}스트라이크"
                    }
                    println(result)

                    // 만약 strike가 baseballLength 값과 같다면 게임을 종료한다.
                    if (strike == baseballLength) {
                        println("${baseballLength}개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        break
                    } else {
                        continue
                    }
                } else {
                    println("낫싱")
                    continue
                }
            } else {
                throw IllegalArgumentException()
            }
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val regame = Console.readLine()
        when (regame) {
            "1" -> {
                continue
            }

            "2" -> {
                break
            }

            // 1 혹은 2가 아닐 경우 throw
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    Console.close()
}