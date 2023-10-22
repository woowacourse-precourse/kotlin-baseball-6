package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    println(GAME_START_MENTION)
    while(true) {
        val computer = getRandomList()
        val number = listToString(computer)
        gameOneSet(number)
        println(GAME_ENDING_MENTION)
        println(GAME_RESTART_MENTION)
        val reGame = Console.readLine()
        if(reGame != "1" && reGame != "2") throw IllegalArgumentException()
        if(reGame == "2") break
    }
}

fun getRandomList() : MutableList<Int> {
    val res = mutableListOf<Int>()
    while (res.size < NUMBER_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!res.contains(randomNumber)) {
            res.add(randomNumber)
        }
    }
    return res
}

fun listToString(list : MutableList<Int>) : String {
    var res = ""
    for(i in 0 until list.size){
        res += list[i].toString()
    }
    return res
}

fun gameOneSet(number : String) {
    while(true) {
        print(INPUT_NUMBER_MENTION)
        val input = Console.readLine().trim()
        checkValidInput(input)
        val score = getScores(number, input)
        if(score == 0) print(NOTHING)
        if(score % 10 != 0) print("${score%10}" + BALL)
        if(score / 10 != 0) print("${score/10}" + STRIKE)
        print('\n')
        if(score == 3*10) break
    }
}

fun checkValidInput(input : String) {
    if(input.length != NUMBER_SIZE) throw IllegalArgumentException()
    for(i in input.indices){
        if(input[i] !in '1' .. '9') throw IllegalArgumentException()
        if(input[i] == input[(i+1)%3] || input[i] == input[(i+2)%3]) throw IllegalArgumentException()
    }
}

fun getScores(random: String, input: String) : Int {
    var score = 0
    score += checkStrikes(random, input) * 10
    score += checkBalls(random, input)
    return score
}

fun checkStrikes(random: String, input: String) : Int {
    var strikes = 0
    for(i in 0 until NUMBER_SIZE) {
        if(random[i] == input[i]) strikes++
    }
    return strikes
}

fun checkBalls(random: String, input: String) : Int {
    var balls = 0
    for(i in 0 until NUMBER_SIZE) {
        if(input[i] == random[(i+1)%3] || input[i] == random[(i+2)%3]) balls++
    }
    return balls
}