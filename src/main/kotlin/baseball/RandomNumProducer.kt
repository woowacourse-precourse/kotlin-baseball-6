package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomNumProducer {

    private val numList : MutableList<Int> = mutableListOf()

    fun makeRandomNum() : List<Int> {

        while (numList.size < 3) {
            val randomNum = Randoms.pickNumberInRange(1,9)
            if(!numList.contains(randomNum)){
                numList.add(randomNum)
            }
        }

        return numList
    }

}