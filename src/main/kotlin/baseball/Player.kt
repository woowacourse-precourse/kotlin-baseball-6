package baseball

class Player {
    //사용자에게 숫자를 입력받는 함수
    fun  getUserInput(): String {
        println("숫자를 입력해주세요 : ")
        return readLine() ?: ""
    }

    //사용자가 입력한 값이 유효한지 검사
    fun isInputValid(userInput: String): Boolean {
        val inputLength = 3
        //입력값의 길이 검사
        if (userInput.length != inputLength) {
            return false
        }
        //입력값에 공백이나 0이 포함되어 있는지 검사
        if (userInput.contains(" ") || userInput.contains("0")) {
            return false
        }
        //입력값의 중복 검사
        val distinctChars = userInput.toSet()
        return distinctChars.size == inputLength
    }
}