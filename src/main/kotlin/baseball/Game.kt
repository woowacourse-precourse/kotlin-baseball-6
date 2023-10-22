package baseball

import camp.nextstep.edu.missionutils.Console

object Game {
    fun start() {
        println("숫자 야구 게임을 시작합니다.")
        startBaseballGame()
    }

    fun startBaseballGame() {
        Computer.setNumber()
        val computerNumber = Computer.getNumber()

        while(true) {
            print("숫자를 입력해주세요 : ")
            Player.inputNumber()
            val playerNumber = Player.getNumber()
            val hint = Hint.compareNumber(playerNumber, computerNumber)

            when(hint) {
                false -> println("낫싱")
                else -> {
                    if(GameCount.getStrikeCount() == 3) {
                        println("3스트라이크")
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        break
                    }
                    // 3스트라이크가 아닐때만 실행됨
                    println(GameCount.getBallCount().toString() + "볼 " + GameCount.getStrikeCount()+ "스트라이크")
                    GameCount.resetCount()
                }
            }
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val inputRestartOrFinish = Console.readLine().toInt()
        ExceptionCheck.checkPlayerInputRestartOrFinish(inputRestartOrFinish)
        when(inputRestartOrFinish) {
            1 -> reStart()
            2 -> {}
        }
    }

    private fun reStart() {
        GameCount.resetCount()
        startBaseballGame()
    }


}