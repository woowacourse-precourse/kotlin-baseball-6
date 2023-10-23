package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var restartGame = true
    do {
        var computerNum = generateRandomNum()



    } while (restartGame)
}

fun getUserGuessNum():HashMap<Int, Int> {
    var userNum = Console.readLine()
    var userNumHashMap = HashMap<Int, Int>()
    require(checkCorrectNum(userNum)){
        "서로 다른 세 자리 숫자를 입력해주세요."
    }
    userNum.forEachIndexed{ index, char ->
        userNumHashMap[char.code] = index
    }

    return userNumHashMap
}

fun checkCorrectNum(num:String):Boolean{
    if (num.all { it.isDigit() } && num.length == 3 && num.toSet().size == 3) {
        return true
    }
    return false
}

fun generateRandomNum(): HashMap<Int, Int> {
    var computerNum: MutableList<Int> = mutableListOf()
    while (computerNum.size < 3) {
        val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    var computerHashMap = HashMap<Int, Int>()

    computerNum.forEachIndexed{ index, char ->
        computerHashMap[char] = index
    }

    return computerHashMap
}

fun compareNums() {


}