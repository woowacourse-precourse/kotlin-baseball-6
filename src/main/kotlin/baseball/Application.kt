package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다")
    while (true)
    {
        baseballgame()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val tmp = Console.readLine()
        if (tmp == "2") break
        else if(tmp != "1") throw IllegalAccessException("입력값 오류!")
    }



}
fun baseballgame(){
    val computer = mutableListOf<Int>()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    var i = 0
    do {

        val input_user = input()
        var strikes = 0
        var balls = 0

        for (k in computer.indices) {
            if (computer[k] == input_user[k]) {
                strikes++
            } else if (input_user.contains(computer[k])) {
                balls++
            }
        }
        val result = when{
            strikes == 3 -> "3스트라이크"
            strikes > 0 && balls > 0 -> "${balls}볼 ${strikes}스트라이크"
            strikes > 0 ->"${strikes}스트라이크"
            balls > 0 -> "${balls}볼"
            else -> "낫싱"
        }
        println(result)

        i++

    } while (strikes != 3)

    println("$i 번 만에 정답을 맞히셨습니다! 게임 종료")


}
fun input() : List<Int>{
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()
    if (input.length != 3) throw IllegalAccessException("입력값 오류!")

    return input.map { it.toString().toInt()}
}
