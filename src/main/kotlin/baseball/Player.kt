package baseball

class Player {
    //사용자에게 숫자를 입력받는 함수
    fun  getUserInput(): String {
        println("숫자를 입력해주세요 : ")
        return readLine() ?: ""
    }
}