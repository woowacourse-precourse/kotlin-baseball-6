package baseball
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

fun generateComNum():List<Int>{
    val comNumber = mutableListOf<Int>()
    while(comNumber.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if (!comNumber.contains(randomNumber)){
            comNumber.add(randomNumber)
        }
    }
    return comNumber
}

fun computeStrikeBall(comNumber: List<Int>, userNumber: List<Int>):Boolean{
    var strike = 0
    var ball = 0
    for(i in 0..2){
        if(userNumber[i] == comNumber[i]){
            strike++
        }
        else if(userNumber[i] in comNumber){
            ball++
        }
    }
    when{
        strike == 3 -> {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 죵료")
            return true
        }

        strike == 0 && ball == 0 -> println("낫싱!")
        ball == 0 -> println("${strike}스트라이크")
        strike == 0 -> println("${ball}볼")
        else -> println("${ball}볼 ${strike}스트라이크 ")
    }
    return false
}
fun baseball() {
    val comNumber = generateComNum()
    println(comNumber)
    var flag = false

    while (!flag) {
        try{
            print("숫자를 입력해주세요: ")
            val input = readLine() ?: ""
            val userNumber = input.map{it.toString().toInt() }
            print(userNumber)
            if (userNumber.size != 3 || userNumber.any {it < 1 || it > 9}){
                throw IllegalArgumentException("오류 발생")
            }
            if (computeStrikeBall(comNumber, userNumber)){
                flag = true
            }
        } catch (e: IllegalArgumentException){
            println(e.message)
            return
        }
    }
    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
    val select = readLine()?.toIntOrNull() ?:0
    when (select) {
        1 -> baseball()
        2 -> return
    }
}

fun main() {
    baseball()
}