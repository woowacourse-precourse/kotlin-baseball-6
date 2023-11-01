package baseball.Model

import baseball.Util.Constants.END_INDEX
import baseball.Util.Constants.GAME_NUMBER_LENGTH
import baseball.Util.Constants.START_INDEX
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var _numberList = mutableListOf<Int>()
    val numberList: List<Int>
        get() = _numberList


    fun setComputerNumber() {
        while (_numberList.size < GAME_NUMBER_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(START_INDEX, END_INDEX)
            if (!_numberList.contains(randomNumber)) {
                _numberList.add(randomNumber)
            }
        }
    }

    fun resetComputerNumber() = _numberList.clear()
}