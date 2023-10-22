package baseball

class View {

    fun printStartMessage() = println("숫자 야구 게임을 시작합니다.")

    fun inputUserNumber(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val input = readln()
        // todo 모두 숫자인지 여부 예외처리
        return input.map { it.toString().toInt() }
    }
}
