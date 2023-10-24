package baseball

import camp.nextstep.edu.missionutils.Console

class Person {
    private val _inputList = mutableListOf<Int>()

    //사용자 입력
    fun inputNumber() {
        _inputList.clear()
        val input = Console.readLine()
        for(i: Int in 0..<input.length) {
            _inputList.add(input[i] - '0')
        }
    }

    //사용자 입력 값 전달
    fun getInputList() : MutableList<Int> {
        return _inputList
    }
}