package model

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

object Validation {

    fun checkBaseballNum(input:String){
        checkIsDigit(input)
        checkNumSize(input)
        checkDuplicateNum(input)
    }

    fun checkRetry(input: String){
        checkIsDigit(input)
        checkValidForm(input)
    }

    private fun checkIsDigit(input: String){
        try {
            input.toInt()
        } catch (e: NumberFormatException){
            throw IllegalArgumentException("[ERROR] 숫자를 입력해주세요")
        }
    }

    private fun checkNumSize(input:String){
        require(input.toList().size==3){
            "[ERROR] 세자리 숫자를 입력해야 합니다."
        }
    }

    private fun checkValidForm(input: String){
        require(input=="1"||input=="2"){
            "[ERROR] 1 혹은 2 만 입력 가능합니다."
        }

    }

    private fun checkDuplicateNum(input: String){
        val nums = input.toList()
        require(nums.toSet().size == nums.size){
            "[ERROR] 서로 다른 3자리 수를 입력해야 합니다."
        }
    }



}