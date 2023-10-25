package baseball

import camp.nextstep.edu.missionutils.Randoms

fun createGameAnswer() : Array<Char> {
    val gameAnswerArr = mutableListOf<Char>()
    while (gameAnswerArr.size < 3) {
        val randomNum = Character.forDigit(Randoms.pickNumberInRange(1,9), 10)
        if (!gameAnswerArr.contains(randomNum)) {
            gameAnswerArr.add(randomNum)
        }
    }
    return gameAnswerArr.toCharArray().toTypedArray()
}