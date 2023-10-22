package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    while(true) {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        var number = ""
        for(i in 0 until computer.size){
            number += computer[i].toString()
        }

        println("숫자 야구 게임을 시작합니다.")

        while(true) {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine().trim()
            checkValidInput(input)
            val score = getScores(number, input)
            if(score == 0) print("낫싱")
            if(score % 10 != 0) print("${score%10}볼 ")
            if(score / 10 != 0) print("${score/10}스트라이크")
            print('\n')
            if(score == 3*10) break
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val reGame = Console.readLine()
        if(reGame != "1" && reGame != "2") throw IllegalArgumentException()
        if(reGame == "2") break
    }
}

fun checkValidInput(input : String) {
    if(input.length != 3) throw IllegalArgumentException()
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
    for(i in 0 until 3) {
        if(random[i] == input[i]) strikes++
    }
    return strikes
}

fun checkBalls(random: String, input: String) : Int {
    var balls = 0
    for(i in 0 until 3) {
        if(input[i] == random[(i+1)%3] || input[i] == random[(i+2)%3]) balls++
    }
    return balls
}