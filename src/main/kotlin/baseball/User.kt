package baseball

import camp.nextstep.edu.missionutils.Console

class User {
    private var userNumber = mutableListOf<Int>()
    fun inputNumber(): MutableList<Int> {
        val inputNumber = Console.readLine()
        if (inputNumber.length != 3)
            throw IllegalArgumentException()
        userNumber.clear()
        for (char in inputNumber) {
            val digit = char.toString().toIntOrNull()
            if (digit != null) {
                userNumber.add(digit)
            }
        }
        if(userNumber.size!=3)
            throw IllegalArgumentException()
        return userNumber
    }

    fun playAgain() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val inputNumber = Console.readLine().toIntOrNull()
        if (inputNumber == 1){
            val computer = Computer()
            computer.playGame()
        }

        else if(inputNumber != 2)
            playAgain()
    }
}