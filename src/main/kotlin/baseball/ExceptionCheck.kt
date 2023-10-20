package baseball

object ExceptionCheck {

    fun checkPlayerInput(number : String) {
        checkPlayerInputIsNumber(number)
        checkPlayerInputIsThree(number)
        checkPlayerInputIsDifferent(number)
    }

    private fun checkPlayerInputIsNumber(number : String) {
        number.forEach {
            if(!it.isDigit()) {
                throw IllegalArgumentException("숫자가 아닙니다!")
            }
        }
    }

    private fun checkPlayerInputIsThree(number : String) {
        if(number.length != 3) {
            throw IllegalArgumentException("세자리 수가 아닙니다!")
        }
    }

    private fun checkPlayerInputIsDifferent(number : String) {
        val numberList = arrayListOf<Int>()

        number.forEach {
            numberList.add(Character.getNumericValue(it))
        }

        for(i in 0 until numberList.size-1) {
            for(j in i+1 until numberList.size) {
                if(numberList[i] == numberList[j]) {
                    throw IllegalArgumentException("서로 다른 수가 아닙니다!")
                }
            }
        }
    }
}