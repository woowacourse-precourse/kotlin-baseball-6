package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")
    var numString:String
    var nums:MutableList<Int>
    var strike:Int = 0
    var ball:Int = 0

    numString = Console.readLine()
    nums = numString.map{it.toString().toInt()}.toMutableList()
    print("$nums")




}
