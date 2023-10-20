package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStart()
    baseball()
}

data class Round(val strike: Int = 0, val ball: Int = 0)

fun printStart(){
    println("숫자 야구 게임을 시작합니다.")
}
fun baseball(){
    while(true){
        val computer = getComputerNumber()
        /*
        while(true){

            val player = getPlayerNumber()
            val roundResult: Round = compareNumber(computer, player)
            printHint(roundResult)
            if(roundResult.strike==3) break
        }
        if(!(askRetry())) break
        */
    }
}
fun getComputerNumber(): List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber)
        }
    }
    return computer
}
/*
fun getPlayerNumber(): List<Int>{
    val player = mutableListOf<Int>()
    return player
}
fun compareNumber(computer: List<Int>, player: List<Int>): Round{

}

fun printHint(roundResult: Round){

}
fun askRetry(): Boolean{

}
 */






