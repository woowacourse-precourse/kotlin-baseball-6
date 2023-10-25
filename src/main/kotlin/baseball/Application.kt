package baseball

fun main() {
    println("숫자 야구 게임을 시작합니다")
    var restart = true

    while (restart) {
        val differentThreeNum = generateDifferentThreeNum()
        var trial = 1

        while (true) {
            val userInput = getUserInput(trial)
            val result = numberHint(userInput, differentThreeNum)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 맞히셨습니다! 게임 종료")
                break
            }
            trial ++
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        restart = readLine()?.trim() == "1"
    }
}



fun generateDifferentThreeNum(): String {
    val shuffledNumbers = (1..9).toList().shuffled().take(3)
    return shuffledNumbers.joinToString("")
}

fun getUserInput(trial: Int): String {
    while(true) {
        print("숫자를 입력해주세요: ")
        val input = readLine()?.trim()

        if(input != null && input.length == 3 && input.all{it.isDigit()}) {
            return input
        }
        println("잘못된 값입니다. 3자리 숫자를 입력하세요.")
    }
}

fun numberHint(userInput: String, differentThreeNum: String): String{
    var ball = 0
    var strike = 0

    for (i in userInput.indices) {
        if (userInput[i] == differentThreeNum[i]) {
            strike++
        } else if (userInput[i] in differentThreeNum) {
            ball++
        }
    }

    if(strike == 3) {
        return "3스트라이크"
    } else if( ball != 0 && strike != 0 ) {
        return "${ball}볼 ${strike}스크라이크"
    } else if( ball != 0 && strike == 0 ) {
        return "${ball}볼"
    } else if( ball == 0 && strike != 0 ) {
        return "${strike}스트라이크"
    } else {
        return "낫싱"
    }
}
