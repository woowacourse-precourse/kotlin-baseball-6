package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private lateinit var baseballNumberList: MutableList<Int>

    fun startGame() {
        setBaseBallNumberList()
    }

    private fun setBaseBallNumberList() {
        baseballNumberList = mutableListOf()
        with(baseballNumberList) {
            while (size < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!contains(randomNumber)) add(randomNumber)
            }
        }
    }
}