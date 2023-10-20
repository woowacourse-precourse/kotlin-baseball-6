package baseball

import camp.nextstep.edu.missionutils.Randoms

fun isInstanceOfList(list: MutableList<Int>, rand: Int): Boolean {
    for (i in list) {
        if (i == rand)
            return true
    }
    return false
}

fun newGame(): Int {
    val list = mutableListOf<Int>(0, 0, 0)
    var target: String = ""
    var index = 0
    while (index < 3) {
        val rand = Randoms.pickNumberInRange(1, 9)
        if (isInstanceOfList(list, rand)) {
            continue
        }
        list[index] = rand
        target += rand.toString()
        index++
    }
    return target.toInt()
}

fun main() {

}
