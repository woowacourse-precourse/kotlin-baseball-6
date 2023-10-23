package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computerNum = getRandomNum()
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine().toInt()
    val inputNum = setUserNum(input)
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

fun setUserNum(inputNum: Int): List<Int> {
    val numList: MutableList<Int> = mutableListOf()
    var num = inputNum
    while (num > 0) {
        numList.add(num % 10)
        num /= 10
    }
    return numList.reversed().toList()
}