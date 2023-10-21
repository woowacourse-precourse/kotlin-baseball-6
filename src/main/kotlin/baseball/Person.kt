package baseball

import camp.nextstep.edu.missionutils.Console

class Person {
    private val _inputList = mutableListOf<Int>()
    val inputList : MutableList<Int>
        get() = _inputList

    fun inputNumber() {
        _inputList.clear()
        val input = Console.readLine()
        for(i: Int in 0..<input.length) {
            _inputList.add(input[i] - '0')
        }
    }
}