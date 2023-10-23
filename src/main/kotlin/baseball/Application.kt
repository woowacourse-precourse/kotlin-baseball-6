package baseball
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computerNum = getRandomNum()
}

fun getRandomNum(): List<Int> {
    val numList: MutableList<Int> = mutableListOf()
    while (numList.size < 3) {
        val randomNum = Randoms.pickNumberInRange(1,9)
        if (!numList.contains(randomNum)) {
            numList.add(randomNum)
        }
    }
    return numList.toList()
}