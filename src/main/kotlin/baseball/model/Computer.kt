package baseball.model

import baseball.util.Constants.END_INDEX
import baseball.util.Constants.GAME_NUMBER_LENGTH
import baseball.util.Constants.START_INDEX
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