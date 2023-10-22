package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")

}

class Computer{
    //숫자 생성
    fun createRandomNum(){
        val computer : MutableList<Int> = mutableListOf()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }
    //숫자비교 및 출력
    

}
class Player{
    //숫자입력 - 예외처리
    fun enterNum()= Console.readLine()

    //게임 종료 , 재시작여부

}