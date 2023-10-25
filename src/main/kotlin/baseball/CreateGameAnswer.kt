package baseball

import camp.nextstep.edu.missionutils.Randoms

fun createGameAnswer(): Array<Char> {
    val gameAnswer = mutableListOf<Char>()
    while (gameAnswer.size < 3) {
        val randomNum = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10)
        if (!gameAnswer.contains(randomNum)) {
            gameAnswer.add(randomNum)
        }
    }
    return gameAnswer.toCharArray().toTypedArray()
}