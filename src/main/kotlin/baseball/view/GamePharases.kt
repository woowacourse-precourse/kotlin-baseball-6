package baseball.view

import camp.nextstep.edu.missionutils.Console

class GamePharases {

    fun startGame(){
        println("숫자 야구 게임을 시작합니다.")
    }

    fun inputNum() : String{

        print("숫자를 입력해주세요 : ")
        val num = Console.readLine()

        return num
    }

    fun correctAns(){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

}