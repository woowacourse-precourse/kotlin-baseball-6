package baseball.ui

import baseball.data.repository.BaseBallGameRepositoryImpl
/**
 * BaseBallGame
 * 숫자 야구 게임의 플로우를 제어하는 클래스
 */
class BaseBallGame {
    init {
        var reStartGame = true
        val repository: BaseBallGameRepository = BaseBallGameRepositoryImpl()
        val viewModel = BaseBallGameViewModel(repository)


        while (reStartGame) {
            println("숫자 야구게임을 시작합니다.")
            viewModel.setComputerList()

            while (true) {
                println("연속된 3자리의 숫자를 입력해주세요:")
                viewModel.setUserList()
                val model = viewModel.compareList()

                if (model.nothing) {
                    println("낫싱")
                } else {
                    if (model.strike == 3) {
                        println("3스트라이크")
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        break
                    } else {
                        println("${model.ball}" + "볼 " + "${model.strike}" + "스트라이크")
                    }
                }
            }

            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            reStartGame = viewModel.exitOrRestartGame()
        }
    }
}