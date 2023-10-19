package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computerNumber = RandomNumber()

}
class RandomNumber(){       // 랜덤으로 1~9까지중 3개 뽑기
    val computer = mutableListOf<Int>()
    init {
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }
}
class GuessNumber(){
    fun choice(){
        print("숫자를 입력해주세요 :")
        val choiceNumber = readLine()
    }
}

class Result(){

}

class GameRestart(){

}
