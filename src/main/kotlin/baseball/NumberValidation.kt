package baseball

private const val MIN_NUM = 1
private const val MAX_MUM = 9
class NumberValidation() {
    fun validation (number : String) {
        if(!isNumber(number) || number.length != 3) {
            throw IllegalArgumentException()
        }
    }
    fun validation (numList : List<Int>) {
        if(numList.distinct().size != 3) {
            throw IllegalArgumentException()
        }
    }
    private fun isNumber (number : String) : Boolean {
        if(number.isBlank() || number.isEmpty()) {
            return false
        }
        for(num in number.indices) {
            if(!isInRange(num)) {
                return false
            }
        }
        return true
    }

    private fun isInRange (number : Int) : Boolean {
        return number in MIN_NUM..MAX_MUM
    }
}