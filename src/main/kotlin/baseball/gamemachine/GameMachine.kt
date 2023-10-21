package baseball.gamemachine

import baseball.io.Output

class GameMachine(printer: Output =Output()) {
    init {
        printer.printStartMessage()
    }

}