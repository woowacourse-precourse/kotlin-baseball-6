package baseball.view


import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    fun readNumbers(): Int {
        print(INPUT_NUMBERS_PROMPT)
        return readLine().toIntOrNull() ?: -1
    }

    fun readCommand(): Command {
        println(COMMAND_PROMPT)
        val command = readLine().toIntOrNull()
        require(command != null) {
            INVALID_COMMAND
        }
        return Command.entries.first { command == it.command }
    }


    companion object {
        private const val DELIMITER = " : "
        const val INPUT_NUMBERS_PROMPT = "숫자를 입력해주세요$DELIMITER"

        private val COMMAND_PROMPT =
            "게임을 ${Command.RESTART.commandName}하려면 ${Command.RESTART.command}, " +
                    "${Command.EXIT.commandName}하려면 ${Command.EXIT.command}를 입력하세요."
        private val INVALID_COMMAND = "잘못된 입력입니다.\n$COMMAND_PROMPT"
    }
}