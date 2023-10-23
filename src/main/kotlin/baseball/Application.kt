package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var restartGame = false
    do {
        print(Dialogues.startGameMessage)

        var computerNum = generateRandomNum()



    } while (restartGame)

}

fun solveBaseBallGame():Boolean{
    while(true) {
        print(Dialogues.requestEnterNumMessage)
        var enterUserNum = Console.readLine()
        print(enterUserNum)
        require(checkCorrectNum(enterUserNum)) {
            "서로 다른 세 자리 숫자를 입력해주세요."
        }
    }
    return true
}

fun changeToHashMap(num: String):HashMap<Int, Int>{
    var hashMap = HashMap<Int, Int>()
    num.forEachIndexed{ index, char ->
        hashMap[char.code] = index
    }
    return hashMap
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
    var computerNumHashMap = HashMap<Int, Int>()

    computerNum.forEachIndexed{ index, char ->
        computerNumHashMap[char] = index
    }

    return computerNumHashMap
}

fun compareNums(computerNum: HashMap<Int, Int>, userNum: HashMap<Int, Int>) {

}
