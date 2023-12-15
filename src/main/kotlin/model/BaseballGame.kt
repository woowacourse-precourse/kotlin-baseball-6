package model

import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {

    private val _baseballNum = mutableListOf<Int>()
    val baseballNum: List<Int> = _baseballNum

    init {
        setBaseballNum()
    }

    private fun setBaseballNum() {
        while (_baseballNum.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!_baseballNum.contains(randomNumber)) {
                _baseballNum.add(randomNumber)
            }
        }
    }

    fun getStrikeAmount(userNum: List<Int>): Int {
        var amount = 0
        repeat(_baseballNum.size) { idx ->
            if (_baseballNum[idx] == userNum[idx]) {
                amount++
            }
        }
        return amount
    }

    fun getBallAmount(userNum: List<Int>): Int = _baseballNum.intersect(userNum).size - getStrikeAmount(userNum)

}