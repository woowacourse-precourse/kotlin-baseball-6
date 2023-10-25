package baseball
import camp.nextstep.edu.missionutils.Randoms
class Model {
    var answerNumber: String = ""
    var userNumber: String = ""
    var isGameOver = false
    var isGameRunning = false

    fun generateNumber(): String {
        val answer = mutableListOf<Int>()
        while(answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (randomNumber !in answer) {
                answer.add(randomNumber)
            }
        }
        return answer.joinToString("")
    }
    fun modelInit() {
        answerNumber = generateNumber()
        userNumber = ""
        isGameOver = false
        isGameRunning = true
    }
}