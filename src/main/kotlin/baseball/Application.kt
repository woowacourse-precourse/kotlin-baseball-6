package baseball
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms



fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var restart = true
    while (restart) {
        val answer = makeAnswer()
        while (true) {
            var guess : String?
            //입력 check
            try {
                print("숫자를 입력해주세요 : ")
                guess = Console.readLine()
                checkInput(guess)
            }
            catch (e: IllegalArgumentException) {
                return
            }

            val result = gameResult(answer,guess)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        try {
            val newgame = readLine()
            if (newgame != "1" && newgame != "2") {
                throw IllegalArgumentException("1,2 숫자 이외의 문자 입력.")
            }
            if(newgame == "1") restart = true
            else restart = false
        }
        catch (e: IllegalArgumentException) {
            return
        }
    }
}

fun makeAnswer(): MutableList<Int>{
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

fun checkInput(check: String) {
    if (check.length != 3 || !check.all { it.isDigit() }) {
        throw IllegalArgumentException("입력 오류.")
    }

    val uniqueNum = check.toSet()
    if (uniqueNum.size != 3) {
        throw IllegalArgumentException("서로 다른 수가 아닙니다.")
    }
}