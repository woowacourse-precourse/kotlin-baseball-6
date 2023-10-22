package baseball

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    val randomTargetGenerator = RandomTargetGenerator()
    val player = Player()

    print("숫자를 입력해주세요 : ")
    val userInput = readLine()
    player.setGuessNumber(userInput!!)
}