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
            throw IllegalArgumentException(ErrorMessage.LENGTH_OVER_THREE.eMessage)
        }

        for (number in input) {
            if (number !in ('1'..'9')) {
                throw IllegalArgumentException(ErrorMessage.WRONG_NUMBER.eMessage)
            }
            if(input.count {
                    it == number
                } > 1) {
                throw IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.eMessage)
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
