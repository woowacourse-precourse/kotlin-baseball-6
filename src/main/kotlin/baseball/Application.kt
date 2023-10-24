package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun get_key():MutableList<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun game(key: MutableList<Int>): Boolean {
//    println("정답은 ${key}")
    var input = readLine()!!
    var mut_input = mutableListOf<Int>()

    if (input.length != 3){
        throw IllegalArgumentException()
    }

    for (i in input) {
        var check = i.toInt()
        if (check in 48..57) { mut_input.add((check - 48)) }
        else{ throw IllegalArgumentException() }
    }
    var st_ba = arrayOf(0, 0)
    for (i in 0..2){
        if (mut_input[i] == key[i]){ st_ba[0] ++ }
        else if (mut_input[i] in key){ st_ba[1] ++ }
    }
    if (st_ba[0] == 0 && st_ba[1] == 0){ println("낫싱") }
    else if (st_ba[0] == 0 && st_ba[1] > 0){ println("${st_ba[1]}볼") }
    else if (st_ba[0] > 0 && st_ba[1] == 0){ println("${st_ba[0]}스트라이크") }
    else if (st_ba[0] > 0 && st_ba[1] > 0){ println("${st_ba[1]}볼 ${st_ba[0]}스트라이크") }

    if (st_ba[0] == 3){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    else{
        game(key)
    }
    return true
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    game(get_key())
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    when (readLine()){
        "1" -> main()
        "2" -> return
        else -> throw IllegalArgumentException()
    }
}
