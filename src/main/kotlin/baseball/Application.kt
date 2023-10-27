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
        if(!checkRestartGame()) break
    }
}

fun checkRestartGame() : Boolean {
    println(GAME_ENDING_MENTION)
    println(GAME_RESTART_MENTION)
    val reGame = Console.readLine()
    if(reGame != "1" && reGame != "2") throw IllegalArgumentException()
    if(reGame == "2") return false
    return true
}

fun getRandomList() : MutableList<Int> {
    val res = mutableListOf<Int>()
    while (res.size < NUMBER_SIZE) {
        addRandomNumber(res)
    }
    return res
}

fun addRandomNumber(list : MutableList<Int>){
    val randomNumber = Randoms.pickNumberInRange(1, 9)
    if (!list.contains(randomNumber)) {
        list.add(randomNumber)
    }
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
        printScoreResult(score)
        if(score == 3*10) break
    }
}

fun printScoreResult(score : Int) {
    if(score == 0) print(NOTHING)
    if(score % 10 != 0) print("${score%10}" + BALL)
    if(score / 10 != 0) print("${score/10}" + STRIKE)
    print('\n')
}

fun checkValidInput(input : String) {
    if(input.length != NUMBER_SIZE) throw IllegalArgumentException()
    for(i in input.indices){
        checkDigit(input[i])
        checkRedundantInput(input, i, input[i])
    }
}

fun checkDigit(ch : Char) {
    if(ch !in '1' .. '9') throw IllegalArgumentException()
}

fun checkRedundantInput(input : String, index : Int, ch : Char) {
    if(input.indexOf(ch) != index) throw IllegalArgumentException()
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
        strikes += isStrike(random[i], input[i])
    }
    return strikes
}

fun isStrike(ch1 : Char, ch2 : Char) : Int {
    if(ch1 == ch2) return 1
    else return 0
}

fun checkBalls(random: String, input: String) : Int {
    var balls = 0
    for(i in 0 until NUMBER_SIZE) {
        if(input[i] == random[(i+1)%3] || input[i] == random[(i+2)%3]) balls++
    }
    return balls
}
