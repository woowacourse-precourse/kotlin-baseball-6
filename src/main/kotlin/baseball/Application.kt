package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

fun getUserGuessNum(){

}


fun generateRandomNum():HashMap<Int, Int>{
    var computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    var computerHashMap = HashMap<Int, Int>()
    for (i in 0 until computer.size){
        computerHashMap.put(computer[i], i)
    }
    return computerHashMap
}

fun compareNums(){

}