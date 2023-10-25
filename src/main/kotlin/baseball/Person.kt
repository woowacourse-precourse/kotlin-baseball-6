package baseball

import java.lang.IllegalArgumentException
import camp.nextstep.edu.missionutils.Console

class Person {

    val person: MutableList<Int> = mutableListOf<Int>()

    fun getInput() {
        inputAndValidate()
    }

    private fun inputAndValidate(){
        person.clear()
        val input = Console.readLine()
        if(validate(input)) {
            addPerson(input)
        }
    }

    private fun validate(input: String): Boolean{
        if(input.length > 3) {
            throw IllegalArgumentException("3자리 이상을 입력하였습니다.")
        }

        for (number in input) {
            if (number !in ('1'..'9')) {
                throw IllegalArgumentException("수를 잘못 입력하였습니다.")
            }
            if(input.count {
                    it == number
                } > 1) {
                throw IllegalArgumentException("중복된 숫자를 입력하셨습니다.")
            }
        }

        return true
    }

    private fun addPerson(input: String) {
        for (i in input) {
            person.add(Character.getNumericValue(i))
        }
    }
}
