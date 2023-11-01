package baseball.model

import baseball.util.C.RANDOM_SIZE
import camp.nextstep.edu.missionutils.Randoms

data class Computer(
    var randomNums: MutableList<String> = mutableListOf()
) {
    fun makeRandomNums() {
        var temp = ""
        randomNums = mutableListOf<String>()
        while (randomNums.size < RANDOM_SIZE) {
            temp = Randoms.pickNumberInRange(1, 9).toString()
            if (!randomNums.contains(temp)) {
                randomNums.add(temp)
            }
        }
    }

    //게임 결과를 도출하는 함수
    fun getGameResult(userInputList: List<String>): Pair<Int, Int> {
        var (strike, ball) = Pair(0, 0)
        for (i in userInputList.indices) {
            if (userInputList[i] == randomNums[i]) strike++
            else if ((userInputList[i] != randomNums[i]) && randomNums.contains(userInputList[i])) ball++
        }
        return Pair(strike, ball)
    }

}