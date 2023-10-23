package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    fun createRandomNum(): String {
        val computer: MutableList<Int> = mutableListOf()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.joinToString("")
    }

    println("숫자 야구 게임을 시작합니다.")
   // print("숫자를 입력해주세요 : ")
    fun enterNum(): String {
        val InputNum = Console.readLine()
        return InputNum
    }

    //val InputNum = enterNum()
    val comNum = createRandomNum()
    //println(InputNum + "내가 입력")
    //println(comNum+"컴퓨터 입력")
  //  println("123" + "컴퓨터 입력")
    fun printResult(result : Pair<Int, Int>){


    }

    fun compareNum(comNum: String, playerNum: String): Pair<Int, Int> {
        var strike = 0
        var ball = 0
        var comNum = "123"
        for (index in playerNum.indices) {
            if (playerNum[index] == comNum[index]) {
                strike++
                continue
            }
            if (comNum.contains(playerNum[index])) {
                ball++
            }
        }
        return Pair(strike, ball)
    }

   // var result = compareNum(comNum, InputNum)
    //println("stike : ${result.first} ball : ${result.second}")
    var result = compareNum(comNum, "0")
    while (result.first != 3 ) {

        print("숫자를 입력해주세요 : ")
        result = compareNum(comNum, enterNum())
        println("stike : ${result.first} ball : ${result.second}")


    }

    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

class Computer {
    //숫자 생성
//    fun createRandomNum():MutableList<Int>{
//        val computer : MutableList<Int> = mutableListOf()
//        while (computer.size < 3) {
//            val randomNumber = Randoms.pickNumberInRange(1, 9)
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber)
//            }
//        }
//        return computer
//    }
    //숫자비교 및 출력


}

class Player {
//    //숫자입력 - 예외처리
//    fun enterNum()= Console.readLine()
//
//    //게임 종료 , 재시작여부

}