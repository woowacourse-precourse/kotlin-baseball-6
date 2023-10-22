package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var randomNumList: MutableList<String> = mutableListOf()

    //난수를 생성하는 함수
    fun makeRandomNumList() {
        var temp = ""
        randomNumList = mutableListOf<String>()
        while (randomNumList.size < 3) {
            temp = Randoms.pickNumberInRange(1, 9).toString()
            if (!randomNumList.contains(temp)) {
                randomNumList.add(temp)
            }
        }
    }

    //게임 결과를 도출하는 함수
    fun getGameResult(userInputList: List<String>): Pair<Int, Int> {
        var (strike,ball) = Pair(0,0)
        for (i in userInputList.indices) {
            if (userInputList[i] == randomNumList[i]) strike++
            else if ((userInputList[i] != randomNumList[i]) && randomNumList.contains(userInputList[i])) ball++
        }
        return Pair(strike, ball)
    }

}