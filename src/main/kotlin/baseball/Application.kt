package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    runGame()//게임을 실행 하는 메인 함수
}

fun runGame() {
    var continueGame = true //게임 지속 여부

    println("숫자 야구 게임을 시작합니다.")

    while (continueGame) {//종료전까지 반복 실행
        val target = generateTarget()
        var guess: String
        var result: Pair<Int, Int>

        do {
            println("숫자를 입력해주세요: ")
            guess = Console.readLine()
            if (!isValidInput(guess)) {//예외설정
                throw IllegalArgumentException("잘못된 입력입니다. 숫자 야구 게임을 종료합니다.")
            }

            result = checkGuess(guess, target)//입력값과 목표값 비교

            when {
                result.first == 0 && result.second == 0 -> println("낫싱")
                else -> println("${result.second}볼 ${result.first}스트라이크")
            }
        } while (result.first < 3)//스트라이크가 3개 미만이 될 때 까지 반복

        println("축하합니다! 3개의 숫자를 모두 맞추셨습니다.")
        println("게임을 새로 시작하려면 '1'을, 종료하려면 '2'를 입력하세요: ")

        when(Console.readLine()) {
            "1" -> continueGame = true
            "2" -> {
                continueGame = false
                println("게임 종료")
            }
            else -> {
                throw IllegalArgumentException("잘못된 선택입니다. 게임을 종료합니다.")
            }
        }
    }
}

fun generateTarget(): String {//목표 숫자를 생성
    val numbers = mutableListOf<Int>()//생성된 숫자를 저장할 리스트

    while (numbers.size < 3) {//3개의 숫자를 생성한다.
        val randomNumber = Randoms.pickNumberInRange(1, 9)//1~9랜덤값 생성
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }

    return numbers.joinToString(separator="")
}

fun isValidInput(input: String): Boolean {//입력받은 값에 대한 유효성 확인
    if (input.length != 3 || input.toSet().size != input.length) {//길이가 3인지 겹치는지 확인
        return false
    }

    for (char in input) {// 각 자리수 확인
        val digit = char.toString().toIntOrNull()//정수값이며 1~9사이에 있어야 한다.
        if (digit == null || digit < 1 || digit > 9) {
            return false
        }
    }

    return true
}

fun checkGuess(guess: String, target: String): Pair<Int, Int> {//추측값과 변수를 비교하여 볼과 스트라이크 개수 계산
    var strikes = 0
    var balls = 0

    for (i in guess.indices) {//각 자리 수에 스트라이크와 볼을 체크하는 반복문 설정
        if (guess[i] == target[i]) {//같은 위치에 같은 숫자가 있으면 스트라이크
            strikes++
        } else if (target.contains(guess[i])) {//다른 위치에 같은 숫자가 있으면 볼
            balls++
        }
    }

    return Pair(strikes, balls) // 계산된 스트라이크와 볼 의 개수를 반환
}