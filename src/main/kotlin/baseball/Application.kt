package baseball

fun main() {
    print("숫자 야구 게임을 시작합니다.\n")
    print("서로 다른 3자리 숫자를 입력해주세요 : ")

    val userInput = readLine()
    val userInputList = mutableListOf<Int>()

    if (!userInput.isNullOrBlank()) {
        for (char in userInput) {
            val digit = Character.getNumericValue(char)
            if (digit in 0..9) {
                userInputList.add(digit)
            }
        }
    }

    if (userInputList.size != 3 || userInputList.distinct().size != 3) {
        throw IllegalArgumentException("서로 다른 3자리 숫자를 입력해야 합니다.")
    }

    println("입력한 숫자 리스트: $userInputList")
}
