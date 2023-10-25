package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var ans : MutableList<Int> = createQuestion()
}

private fun createQuestion(): MutableList<Int> {
    val questionNums : MutableList<Int> = mutableListOf<Int>()
    while (questionNums.size < 3) {
        val curNum : Int = Randoms.pickNumberInRange(1, 9)
        if(!questionNums.contains(curNum)) {
            questionNums.add(curNum)
        }
    }
    return questionNums
}