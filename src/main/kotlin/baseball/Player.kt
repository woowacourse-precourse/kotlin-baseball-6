package baseball

class Player(private val inputManager: InputManager) {
    fun inputNum(): Int = inputManager.input("숫자를 입력해주세요 : ", Digit.THREE)
}