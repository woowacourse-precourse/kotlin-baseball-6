package baseball

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
}