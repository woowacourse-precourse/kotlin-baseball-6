package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val _numberList = mutableListOf<Int>()

    //컴퓨터 수 생성
    fun makeComputerNumber() {
        _numberList.clear()
        while (_numberList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!_numberList.contains(randomNumber)) {
                _numberList.add(randomNumber)
            }
        }
    }

    //컴퓨터 수 값 전달
    fun getNumberList() : MutableList<Int> {
        return _numberList
    }
}