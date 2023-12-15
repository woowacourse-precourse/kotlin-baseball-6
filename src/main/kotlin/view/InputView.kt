package view

import camp.nextstep.edu.missionutils.Console
import model.Validation

class InputView {

    fun readNumbers(): List<Int> {
        return try {
            val input = Console.readLine()
            Validation.checkBaseballNum(input)
            input.toList().map { it.toString().toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readNumbers()
        }
    }

}