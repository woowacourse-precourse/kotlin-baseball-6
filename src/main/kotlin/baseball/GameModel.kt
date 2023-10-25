package baseball

import camp.nextstep.edu.missionutils.Randoms

class GameModel {
    fun generateComputerNumbers(): List<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }

    fun checkGuess(userGuess: String, computerNumbers: List<Int>): String {
        // Validate user input
        if (userGuess.length != 3 || userGuess.toSet().size != 3 || !userGuess.all { it.isDigit() }) {
            throw IllegalArgumentException("잘못된 입력입니다!")
        }

        val userNumbers = userGuess.map { it.toString().toInt() }
        val strikes = computerNumbers.zip(userNumbers).count { (a, b) -> a == b }
        val intersectionSize = userNumbers.intersect(computerNumbers).size
        val balls = intersectionSize - strikes

        if (strikes == 3) {  return "3스트라이크"  }
        else if (strikes > 0 || balls > 0) {
            val result = mutableListOf<String>()
            if (balls > 0) {
                result.add("${balls}볼")
            }
            if (strikes > 0) {
                result.add("${strikes}스트라이크")
            }
            return result.joinToString(" ")
        } else {
            return "낫싱"
        }
    }
}
