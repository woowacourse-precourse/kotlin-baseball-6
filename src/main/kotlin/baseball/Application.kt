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

fun getInput(len: Int): Int {
    val str: String = Console.readLine()
//    println(str)
    if (str.length != len)
        throw IllegalArgumentException("illegal length was input")
    if (str[0] == '0')
        throw IllegalArgumentException("do not start 0")
    try {
        val num: Int = str.toInt()
        for (i in 0 until len) {
            for (j in 0 until len) {
                if (i == j)
                    continue
                else if (str[i] == str[j])
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

// return True when game isn't continue, return false when 3-strike
fun getScore(target: Int, input: Int): Boolean {
    if (target == input) {
        println("3스트라이크")
        return false
    }
    val targetToStr: String = target.toString()
    val inputToStr: String = input.toString()
    var ball: Int = 0
    var strike: Int = 0
    for (i in 0..2) {
        for (j in 0..2) {
            if (targetToStr[i] == inputToStr[j]) {
                if (i == j)
                    strike++
                else
                    ball++
            }
        }
    }
    if (ball + strike == 0)
        println("낫싱")
    else {
        if (ball > 0) {
            print(String.format("%d볼", ball))
            if (strike > 0)
                println(String.format(" %d스트라이크", strike))
            else
                println()
        } else
            println(String.format("%d스트라이크", strike))
    }
    return true
}

fun endGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val input: Int = getInput(1)
    when (input) {
        1 -> return false
        2 -> return true
        else -> throw IllegalArgumentException("input 1 or 2")
    }
}

fun baseballGame() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        val target: Int = newGame()
        while (true) {
            print("숫자를 입력해주세요 : ")
            if (!getScore(target, getInput(3)))
                break
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        if (endGame())
            break
    }
}

fun main() {
    baseballGame()
}