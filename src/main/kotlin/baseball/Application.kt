package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {

}

val BASE_BALL_SIZE = 3
fun createBaseBallNumber(): List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < BASE_BALL_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun baseBallOutput(answer:List<Int>, question: List<Int>) : String{
    var strike = 0
    var ball = 0
    for(i in 0 until BASE_BALL_SIZE){
        if(answer[i] == question[i]){
            strike++
            continue
        }
        if(answer.contains(question[i])){
            ball++
        }
    }
    val output = if(ball == 0 && strike == 0){
        "낫싱"
    }else if(ball == 0){
        "${strike}스트라이크"
    }else if(strike == 0) {
        "${ball}볼"
    }else{
        "${ball}볼 ${strike}스트라이크"
    }
    return output
}
