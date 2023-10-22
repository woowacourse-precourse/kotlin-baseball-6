package baseball.util

/**
 * 작성자 : 추민수
 * 설명 : 숫자 랜덤 생성, 사용자 입력 등
 */
object Utils {

    /**
     * inputNum()
     * 사용자가 입력한 연속된 3자리의 문자열을 받아 한글자씩 나눠 리스트의 형태로 return
     */
    fun inputNum(): List<Int> {
        println("연속된 3자리의 숫자를 입력하세요:")

        var inputString = readLine()
        while (inputString == null || !isValidInput(inputString)) {
            println("유효하지 않은 입력입니다. 연속된 3자리의 숫자를 입력하세요:")
            inputString = readLine()
        }
        // 문자열을 한글자씩 나눠 리스트에 나눠 전송
        return inputString.chunked(1).map { it.toInt() }
    }

    /**
     * isValidInput()
     * 유효한 입력(길이:3, 입력형태:Int)인지 확인 후 Boolean return
     */
    fun isValidInput(input: String): Boolean {
        return input.length == 3 && input.all { it.isDigit() }
    }
}