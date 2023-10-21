package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

data class Score(
    val answer : String
) {
    fun isCorrect(input : String): Boolean {
        val inputSet = input.toSet()
        return if (answer == input) {
                true
            }
            else {
                var strikeCount = 0
                var ballCount = 0
                answer.forEachIndexed { index, it ->
                    if (inputSet.contains(it)){
                        if (index == input.indexOf(it)){
                            strikeCount++
                        } else {
                            ballCount++
                        }
                    }
                }
            if (ballCount + strikeCount > 0){
                if (ballCount != 0){
                    print(ballCount.toString() + "볼 ")
                }
                if (strikeCount != 0){
                    print(strikeCount.toString() + "스트라이크")
                }
            } else {
                print("낫싱")
            }
            println()

            false
            }
    }
}
fun startGame(){
    val correctScore = Score(getAnswerScore())
    do {
        print("숫자를 입력해주세요 : ")
        val inputData = Console.readLine()

        try {
            inputData.toInt()
        } catch (e : NumberFormatException){
            throw IllegalArgumentException("")
        }
        if (inputData.length != 3 ){
            throw IllegalArgumentException("")
        }
    }
    while (!correctScore.isCorrect(inputData))


    println("3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun getAnswerScore() : String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    startGame()

    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    when (Console.readLine()){
        "1" -> startGame()
        "2" -> return
        else -> throw IllegalArgumentException("")
    }

}



