package baseball
import camp.nextstep.edu.missionutils.*

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    game()

    //(게임) 컴퓨터가 선택한 3개의 숫자를 맞히면 게임이 종료
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

    //(게임) 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
    val continueGame = readLine()
    if (continueGame != null) {
        if (continueGame.toInt() == 1) {
            game()
        } else if (continueGame.toInt() != 2){
                throw IllegalArgumentException("올바른 값을 입력해주세요.")
            }
    }
}

fun isInteger(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}
fun game() {
    // (컴퓨터) 1~9까지 서로 다른 임의의 수 3개를 선택한다.
    val computer: MutableList<Int> = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    //(게임) 정답을 맞추기 전까진 게임 반복
    do{
        var strike: Int = 0
        var ball: Int = 0

        //(게임 플레이어) 서로 다른 3개의 숫자를 입력한다.
        print("숫자를 입력해주세요 : ")
        val input = readLine()
        var player: List<String> = emptyList<String>()

        // 입력 받은 값이 null인지, 자연수인지 확인한다.
        if (!input.isNullOrEmpty() && isInteger(input) && input.toInt() > 0){
            player = input.split("")
        }
        else {
            throw IllegalArgumentException("null이거나 자연수가 아닙니다.")
        }

        // 입력 받은 값이 서로 다른 세 자리 수인지 확인한다.
        if (player.size == 5){
            if (player[1] == player[2] || player[1] == player[3] || player[2] == player[3]){
                throw IllegalArgumentException("서로 다른 숫자가 아닙니다.")
            }
        } else {
            throw IllegalArgumentException("세 자리 숫자가 아닙니다.")
        }

        //(컴퓨터) 플레이어가 입력한 숫자와 자신의 숫자를 비교한다.
        for(i: Int in 0..2)
            if (computer[i] == player[i+1].toInt()){
                strike++
            }
            else {
                if (computer.contains(player[i+1].toInt()) && computer[i] != player[i+1].toInt()){
                    ball++
                }
            }

        //(컴퓨터) 비교 후, 힌트를 결과로 출력한다. (스트라이크, 볼, 낫싱)
        if(strike > 0 && ball > 0){
            println("${ball}볼 ${strike}스트라이크")
        } else if (strike > 0 && ball == 0){
            println("${strike}스트라이크")
        } else if (strike == 0 && ball > 0){
            println("${ball}볼")
        } else {
            println("낫싱")
        }
    } while (strike != 3)
}