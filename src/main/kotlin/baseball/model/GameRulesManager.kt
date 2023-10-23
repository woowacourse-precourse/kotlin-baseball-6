package baseball.model

import camp.nextstep.edu.missionutils.Randoms

/*
김영현
GameRulesManager는 게임의 규칙을 관리합니다.
컴퓨터가 선택한 숫자를 생성하고, 사용자가 제시한 숫자와 비교하여 결과를 반환합니다.
결과에 따라 스트라이크, 볼, 낫싱을 알려주며, 3스트라이크일 때 게임의 종료 여부를 알려줍니다.
 */
class GameRulesManager {

    private var computerNumbers: List<Int> = emptyList()

    //컴퓨터 랜덤 숫자 선택
    fun generateComputerNumbers() {
        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        computerNumbers = computer
    }

    //사용자 숫자 예외 처리 및 결과 반환
    fun checkUserGuess(userNumbers: List<Int>): String {
        if (userNumbers.size != 3) {
            throw IllegalArgumentException("올바른 입력이 아닙니다.")
        }
        // 사용자 입력값이 중복된 숫자를 포함하고 있는지 확인
        if (userNumbers.toSet().size != userNumbers.size) {
            throw IllegalArgumentException("중복된 숫자가 포함되어 있습니다.")
        }

        var strikes = 0
        var balls = 0

        for (i in 0 until 3) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++
            } else if (computerNumbers.contains(userNumbers[i])) {
                balls++
            }
        }

        return when {
            strikes == 3 -> {
                "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
            }
            strikes == 0 && balls == 0 -> {
                "낫싱"
            }
            else -> {
                "${balls}볼 ${strikes}스트라이크"
            }
        }
    }
}