package baseball.model

private const val MIN_NUM = 0
private const val MAX_MUM = 9
class Numbers {
    var number : MutableList<Int>
    constructor(_number: MutableList<Int>) {
        this.number = _number
    }

    fun isNumber (number : String) : Boolean {
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

    fun isInRange (number : Int) : Boolean {
        return number in MIN_NUM..MAX_MUM
    }
}