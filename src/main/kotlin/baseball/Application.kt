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
                throw IllegalArgumentException("Invalid input. Please enter a 3-digit number with distinct digits.")
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

