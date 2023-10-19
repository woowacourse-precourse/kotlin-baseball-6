package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private lateinit var computerNumber: MutableList<Int>
    private var isEnd : Boolean = false
    private val user = User()
    fun playGame(){
        println("숫자 야구 게임을 시작합니다.")
        setRandomNumber()
        while(!isEnd){
            print("숫자를 입력해주세요 :")
            val input =user.inputNumber()
            val strike = countStrike(input)
            val ball = countBall(input) - strike
            println(resultString(strike,ball))
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        isEnd = false
    }

    private fun setRandomNumber() {
        computerNumber = mutableListOf()
        while (computerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
    }
    private fun resultString(strike: Int, ball: Int) : String {
        if(strike == 0 && ball == 0)
            return "낫싱"
        else if(strike == 3){
            isEnd = true
            return "3스트라이크"
        }
        else if(strike == 0)
            return "${ball}볼"
        else if(ball == 0)
            return "${strike}스트라이크"
        return "${ball}볼 ${strike}스트라이크"
    }
}