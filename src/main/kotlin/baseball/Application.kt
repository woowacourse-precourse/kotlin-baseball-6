package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
class Game {
    private var computer: String = ""
    private var user: String = ""
    private var check: String = ""
    fun play(){
        computer = randomNum()
        while (true){
            user = getUserNum()
            validateUser(user)
            try {
                val result = checkNum(computer,user)
                println(result)
                if (result == "3스트라이크"){
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                    check= reStart()
                    if (check == "2"){break} else {computer = randomNum()}
                }
            } catch (e:IllegalArgumentException){
                break
            }
        }
    }
    private fun randomNum(): String {
        val number = mutableListOf<Int>()
        while (number.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!number.contains(randomNumber)) {
                number.add(randomNumber)
            }
        }
        val computer = number.joinToString("")
        return computer
    }
    private fun getUserNum(): String {
        print("숫자를 입력해주세요 : ")
        return Console.readLine()
    }
    private fun reStart(): String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine()
    }
    private fun checkNum(computerNumber: String, userNumber: String): String {
        var strikes = 0
        var balls = 0

        for (i in computerNumber.indices) {
            if (computerNumber[i] == userNumber[i]) { //computerNumber[i]의 값이랑 userNumber[i]의 값이 같을때
                strikes++ // strikes up
            } else if (computerNumber.contains(userNumber[i])) { //computerNumber 리스트 안에 userNumber[i]가 포함되면
                balls++ //balls up
            }
        }

        return when {
            strikes == 3 -> "3스트라이크"
            strikes > 0 || balls > 0 -> "$balls" + "볼 " + "$strikes" + "스트라이크"
            else -> "낫싱"
        }
    }
    private fun validateUser(user: String) {
        if (user.length != 3 || user.toSet().size != 3 || user.any { it !in '1'..'9' }) {
            throw IllegalArgumentException()
        }
    }

}
fun main() {
    val baseballGame = Game()
    println("숫자 야구 게임을 시작합니다.")
    baseballGame.play()
}
