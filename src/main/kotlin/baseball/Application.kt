package baseball

import camp.nextstep.edu.missionutils.Console
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

fun getInput(): Int {
    val str: String = Console.readLine()
    try {
        val num: Int = str.toInt()
        if ((num > 999) or (num < 100))
            throw IllegalArgumentException("illegal length was input")
        val list = mutableListOf<Int>(num / 100, num % 100 / 10, num % 10)
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j)
                    continue
                else if (list[i] == list[j])
                    throw IllegalArgumentException("duplicate-digit was input")
            }
        }
        return num
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException(e)
    } catch (e: Exception) {
        throw IllegalArgumentException("non-digit was input")
    }
}

fun main() {

}
