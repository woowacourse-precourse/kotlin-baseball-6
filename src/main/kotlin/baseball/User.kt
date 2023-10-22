package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class User {
    fun inputUserNumber(): MutableList<Int> {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine()
        checkValidNumber(userNumber)

        return userNumber.map { it.digitToInt() }.toMutableList()
    }

    private fun checkValidNumber(number: String) {
        //사용자의 입력이 3자리인지 확인
        if (number.length != 3) {
            throw IllegalArgumentException("3자리의 입력이 아닙니다.")
        }

        //사용자의 입력이 숫자인지 확인
        for (i in 0..<number.length) {
            val asciiCode = number[i].code

            if (asciiCode !in 48..57) {
                throw IllegalArgumentException("사용자의 입력이 숫자가 아닙니다.")
            }
        }

        //사용자의 입력된 숫자에 중복된 숫자가 있는지 확인
        if (number.toList().distinct().size != 3) {
            throw IllegalArgumentException("사용자의 입력 중 중복된 숫자가 존재합니다.")
        }

        //사용자의 입력 숫자의 각 자리수가 1부터 9까지인지 확인
        number.forEach { num ->
            val iNum = num.digitToInt()

            if (iNum !in 1..9) {
                throw IllegalArgumentException("사용자의 입력이 1부터 9까지의 숫자가 아닙니다.")
            }
        }
    }
}