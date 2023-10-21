package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {

    //난수를 생성하는 함수
    fun makeRandomNumList(): MutableList<String> {
        var temp = ""
        val randomNumList = mutableListOf<String>()
        while (randomNumList.size < 3) {
            temp = Randoms.pickNumberInRange(1, 9).toString()
            if (!randomNumList.contains(temp)) {
                randomNumList.add(temp)
            }
        }
        return randomNumList
    }

    //게임 결과를 도출하는 함수
    fun getGameResult(userInputList: List<String>, randomNumList: MutableList<String>): Triple<Int, Int, Int> {
        var strike = 0
        var ball = 0
        var nothing = 0
        for (i in userInputList.indices) {
            if (userInputList[i] == randomNumList[i]) strike++
            else if ((userInputList[i] != randomNumList[i]) && randomNumList.contains(userInputList[i])) ball++
        }
        if (ball + strike == 0) nothing = 1
        return Triple(strike, ball, nothing)
    }


}