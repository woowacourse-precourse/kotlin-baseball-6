package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

open class Game {

    private var strike = 0
    private var ball = 0
    private fun computerNum(): MutableList<Int> {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9) //랜덤으로 1~9까지 중 숫자 뽑음
            if (!computer.contains(randomNumber)) { //기존 리스트에 숫자가 포함되는지 체크해서
                computer.add(randomNumber) // 겹치는 숫자 없이 추가한다.
            }
        }
        return computer
    }

    private fun playerNum(): MutableList<Int> {
        val player = mutableListOf<Int>()
        print("숫자를 입력해주세요 : ")
        val counter = Console.readLine() // 문자열로 받음
        if (counter == null || counter.length != 3) {
            throw IllegalArgumentException("게임 종료")
        }
        for (char in counter) { // 각 문자별로 뽑아서
            val number = Character.digit(char, 10)
            if (number <= 0 || number in player) {
                throw IllegalArgumentException("게임 종료")
            }
            player.add(number) // 숫자로 변환해 리스트에 추가
        }
        return player
    }

    private fun compare(computer: MutableList<Int>, player: MutableList<Int>) {
        strike = 0
        ball = 0
        for (i in 0 until player.size) {
            if (computer.contains(player[i])) { //컴퓨터에 값이 포함되었는지
                val index = computer.indexOf(player[i]) //포함되면 인덱스 가져와서
                if (i == index) { //위치가 같으면 스트라이크
                    strike++
                } else { //예외테스트 1: 예외 테스트
                    ball++ //위치가 같지 않으면 볼
                }
            }
        }
    }

    private fun resultMessage() {
        when {
            strike == 0 && ball == 0 -> println("낫싱")
            strike == 3 -> {
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            }

            strike == 0 -> println(ball.toString() + "볼")
            ball == 0 -> println(strike.toString() + "스트라이크")
            else -> println(ball.toString() + "볼 " + strike.toString() + "스트라이크")

        }

    }
    fun handleEnd(){
        while(true) {
            val cNumber = computerNum() // 컴퓨터의 랜덤 숫자
            var playing = true
            while (playing) {
                val pNumber = playerNum() // 플레이어의 숫자
                compare(cNumber, pNumber) //스트라이크, 볼 비교
                resultMessage()
                if (strike == 3) {
                    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                    val answer = Console.readLine()
                    when (answer) {
                        "1" -> {
                            playing = false
                        }
                        "2" -> {
                            println("게임 종료")
                            return
                        }
                        else -> throw IllegalArgumentException()
                    }
                }
            }
        }
    }
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val game = Game()
    game.handleEnd()
}
