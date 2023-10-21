package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var numString:String
    var nums:MutableList<Int>
    var strike:Int = 0
    var ball:Int = 0

    var answers:MutableList<Int> = mutableListOf()
    while (answers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answers.contains(randomNumber)) {
            answers.add(randomNumber)
        }
    }
    print("숫자를 입력해주세요 : ")
    numString = Console.readLine()
    nums = numString.map{it.toString().toInt()}.toMutableList()


    print(answers)


}
