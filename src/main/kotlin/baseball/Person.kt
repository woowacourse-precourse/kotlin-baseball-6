package baseball

import camp.nextstep.edu.missionutils.Console

class Person {
    private val _inputList = mutableListOf<Int>()

    fun inputNumber() {
        _inputList.clear()
        val input = Console.readLine()
        for(i: Int in 0..<input.length) {
            _inputList.add(input[i] - '0')
        }
    }

    fun getInputList() : MutableList<Int> {
        return _inputList
    }
}