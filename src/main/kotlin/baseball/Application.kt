package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var count = 0
    do {
        print(Dialogues.startGameMessage)

        var computerNum = generateRandomNum()
        try{
            solveBaseBallGame()
        } catch (e:java.lang.IllegalArgumentException){
            println(e.message)
            return throw IllegalArgumentException()
        }
        count +=1


    } while (count !=1)
}

fun solveBaseBallGame(){
    while(true) {
        print(Dialogues.requestEnterNumMessage)
        var enterUserNum = Console.readLine()
        println(enterUserNum)
        if (checkCorrectNum(enterUserNum)) {
            val userNumHashMap = changeToHashMap(enterUserNum.map { it.toString().toInt() }.toMutableList())
            println(userNumHashMap)
        } else {
            throw IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.")
        }
    }
}

fun changeToHashMap(num: MutableList<Int>):HashMap<Int, Int>{
    var hashMap = HashMap<Int, Int>()
    num.forEachIndexed{ index, char ->
        hashMap[char] = index
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

    return changeToHashMap(computerNum)
}

fun compareNums(computerNum: HashMap<Int, Int>, userNum: HashMap<Int, Int>) {

}
