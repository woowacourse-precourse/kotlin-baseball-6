package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val  _numbers : ArrayList<Int> = arrayListOf()
    val numbers : List<Int> get() = _numbers
    fun makeRandomNumbers() {
        _numbers.clear()
        while (_numbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if(!_numbers.contains(randomNumber)) {
                _numbers.add(randomNumber)
            }
        }
    }
}