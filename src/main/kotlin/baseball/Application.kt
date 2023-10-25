package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var restart = true
    while(restart) {
        val answer = makeAnswer()
        var guess: String?
        //입력 check
        var gamegoing = true
        while(gamegoing) {
            try {
                print("숫자를 입력해주세요 : ")
                guess = Console.readLine()
                println(guess)
                checkInput(guess)
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException()
                return
            }

            val result = gameResult(answer, guess)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                gamegoing = false
            }
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var newgame = Console.readLine()
        println(newgame)
        when (newgame) {
            "1" -> { continue}
            "2" -> restart = false
            else -> throw IllegalArgumentException()
        }
    }
}

fun makeAnswer(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}


fun gameResult(answer: List<Int>, guess: String): String {
    val guessDigits = guess.toCharArray().map { it.toString().toInt() }

    var strike = 0
    var ball = 0

    for (i in 0 until 3) {
        if (answer[i] == guessDigits[i]) {
            strike++
        } else if (answer.contains(guessDigits[i])) {
            ball++
        }
    }

    return when {
        strike == 3 -> "3스트라이크"
        strike > 0 && ball > 0 -> "${ball}볼 ${strike}스트라이크"
        strike > 0 -> "${strike}스트라이크"
        ball > 0 -> "${ball}볼"
        else -> "낫싱"
    }
}

fun checkInput(number: String) {
    // null, 정수, 입력 자리수 체크
    if (number.isNotEmpty() && number.chars()
            .allMatch { Character.isDigit(it) } && number.length == 3
    ) {
        // 겹치지 않는 숫자 체크와 1-9 사이 체크
        for (i in 0..<3) {
            if (number.count { it == number[i] } > 1 || Character.getNumericValue(number[i]) == 0) {
                throw IllegalArgumentException()
            }
        }
    } else {
        throw IllegalArgumentException()
    }
}
