package baseball.Model

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var _numberList = mutableListOf<Int>()
    val numberList: List<Int>
        get() = _numberList


    fun setComputerNumber() {
        while (_numberList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!_numberList.contains(randomNumber)) {
                _numberList.add(randomNumber)
            }
        }
    }

    fun resetComputerNumber() = _numberList.clear()
}