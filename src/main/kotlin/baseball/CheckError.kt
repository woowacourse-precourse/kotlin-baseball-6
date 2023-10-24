package baseball

class CheckError {
    fun check(number:String){
        checkOverthree(number)
        checkNumber(number)
        checkDuplication(number)
    }
    private fun checkOverthree(number: String){
        if (number.length != 3) { //숫자가 3이 넘어가면 에러
            throw IllegalArgumentException("숫자가 3이 넘어갑니다.")
        }
    }
    private fun checkNumber(number: String){
        for (i in 0..number.length-1) { // 숫자가 아니면 에러
            if (number[i] < '1' || number[i] > '9') {
                throw IllegalArgumentException("숫자가 아닙니다.")
            }
        }
    }
    private fun checkDuplication(number: String){
        for (i in 0..number.length-1) { //숫자가 중복되면 에러
            val curNum = number[i]-'0'
            if (!myNumber.contains(curNum)) {
                myNumber.add(curNum)
            } else {
                throw IllegalArgumentException("숫자가 중복됩니다.")
            }
        }
    }
}