package view

import camp.nextstep.edu.missionutils.Console
import model.Validation

class InputView {

    fun readNumbers(): List<Int> {
        return try {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            Validation.checkBaseballNum(input)
            input.toList().map { it.toString().toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readNumbers()
        }
    }

    fun readIsRetry(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return try {
            val input = Console.readLine()
            Validation.checkRetry(input)
            isRetryIntToBoolean(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readIsRetry()
        }
    }

    private fun isRetryIntToBoolean(input: String): Boolean = input == "1"


}