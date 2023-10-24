package baseball

class InputValidator {

    //사용자 입력 판별
    fun isValidInput(inputList: MutableList<Int>) {
        if(!isCorrectLength(inputList) || isSameNumber(inputList) || !isAllNumeric(inputList)) {
            throw IllegalArgumentException()
        }
    }

    // 게임 재시작 여부 입력 판별
    fun isRestart(inputList: MutableList<Int>): Boolean {
        return inputList.size == 1 && inputList[0] == 1
    }

    private fun isCorrectLength(inputList: MutableList<Int>) : Boolean {
        return inputList.size == 3
    }

    private fun isSameNumber(inputList: MutableList<Int>) : Boolean {
        return inputList[0] == inputList[1] || inputList[0] == inputList[2] || inputList[1] == inputList[2]
    }

    private fun isAllNumeric(inputList: MutableList<Int>) : Boolean {
        for(n in inputList) {
            if(!isNumeric(n.toString())) {
                return false
            }
        }
        return true
    }

    private fun isNumeric(input: String): Boolean {
        return try {
            input.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

}