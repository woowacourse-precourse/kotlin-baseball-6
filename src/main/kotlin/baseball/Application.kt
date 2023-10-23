package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var restartGame = true
    do {
        var computerNum = generateRandomNum()



    } while (restartGame)
}

fun getUserGuessNum() {
    var userNum = Console.readLine()
    require(checkCorrectNum(userNum)){
        "서로 다른 세 자리 숫자를 입력해주세요."
    }


}

fun checkCorrectNum(num:String):Boolean{
    if (num.all { it.isDigit() } && num.length == 3 && num.toSet().size == 3) {
        return true
    }
    return false
}

fun generateRandomNum(): HashMap<Int, Int> {
    var computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    var computerHashMap = HashMap<Int, Int>()
    for (i in 0 until computer.size) {
        computerHashMap.put(computer[i], i)
    }
    return computerHashMap
}

fun compareNums() {

}