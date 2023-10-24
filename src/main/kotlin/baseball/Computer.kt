import camp.nextstep.edu.missionutils.Randoms

class Computer {
    var answer : MutableList<Int> = mutableListOf()

    fun makeNewAnswer() {
        answer = mutableListOf()
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
    }

    private fun checkStrikeCount(userInput: MutableList<Int>): Int {
        var strikeCount : Int = 0

        for (i in 0..2) {
            if (userInput[i] == answer[i]) {
                strikeCount += 1
            }
        }
        return strikeCount
    }

    private fun checkBallCount(userInput: MutableList<Int>): Int {
        var ballCount : Int = 0

        for (i in 0..2) {
            for (j in 0..2) {
                if (userInput[i] == answer[j] && i != j) {
                    ballCount += 1
                }
            }
        }
        return ballCount
    }

    private fun printCheck(strikeCount: Int, ballCount: Int) {
        if (strikeCount != 0 && ballCount != 0) {
            println("$ballCount$STR_BALL $strikeCount$STR_STRIKE")
        } else if (strikeCount != 0) {
            println("$strikeCount$STR_STRIKE")
        } else if (ballCount != 0) {
            println("$ballCount$STR_BALL")
        } else {
            println(STR_NOTHING)
        }
    }
}