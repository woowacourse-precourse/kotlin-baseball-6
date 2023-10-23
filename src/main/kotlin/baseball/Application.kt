package baseball
import baseball.model.Results
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun generateRandomNum() : MutableList<Int> {
    var randomList = mutableListOf<Int>();
    while (randomList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomList.contains(randomNumber)) {
            randomList.add(randomNumber)
        }
    }
    println(randomList)
    return randomList
}
fun inputGuessNum(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val inputNum = Console.readLine()
    if (inputNum != null && inputNum.length == 3) {
        val guessList = inputNum.map { it.toString().toInt() }
        if (guessList.distinct().size == 3) {
            println(guessList)
            return guessList
        }
    }
    throw IllegalArgumentException()
}

fun compareNumbers(target: List<Int>, compare: List<Int>): Results {
    var rslt = Results()
    for (i in target.indices) {
        if (target[i] == compare[i]) {
            rslt.strikes++
        } else if (target.contains(compare[i])) {
            rslt.balls++
        }
    }
    return rslt
}
fun main() {

    println("숫자 야구 게임을 시작합니다.")

    var playAgain = true

    while (playAgain) {
        val targetNumbers = generateRandomNum()
        var attempts = 0

        while (true) {
            try {
                val guessNumbers = inputGuessNum()
                val rslt = compareNumbers(targetNumbers, guessNumbers)
                println(rslt.getResultMessage())

                attempts++

                if (rslt.strikes == 3) {
                    println("${rslt.strikes}개의 숫자를 모두 맞히셨습니다! 게임 종료.")
                    break
                }
            } catch (e: IllegalArgumentException) {
                println("잘못된 값을 입력하셨습니다. 올바른 형식의 숫자를 입력해주세요. \n" +
                        "프로그램을 종료합니다. ${e.message}")
            }
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val playAgainInput = Console.readLine().toInt();
        playAgain = when (playAgainInput) {
            1 -> true
            2 -> false
            else -> throw IllegalArgumentException("잘못된 값을 입력하셨습니다. 올바른 형식의 숫자를 입력해주세요. \n 프로그램을 종료합니다.")
        }
    }
    println("게임을 종료합니다.")
}
