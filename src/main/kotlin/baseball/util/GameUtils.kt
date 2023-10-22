package baseball.util

import baseball.presentation.model.GameModel
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/**
 * Utils
 * 게임에서 사용되는 유틸리티 함수들을 제공하는 객체
 */
object GameUtils {

    /**
     * getRandomList()
     * 게임에서 사용할 1에서 9까지 서로 다른 임의의 3개 숫자를 생성
     *
     * @return 1에서 9까지 서로 다른 3개의 숫자로 이루어진 리스트 반환
     */
    fun getRandomList(): List<Int> {
        val computerList = mutableListOf<Int>()

        while (computerList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)

            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber)
            }
        }
        return computerList
    }

    /**
     * inputNum()
     * 사용자가 입력한 연속된 3자리의 문자열을 받아 한 글자씩 분리하여 리스트 형태로 반환
     *
     * @return 사용자가 입력한 3자리 숫자를 나타내는 리스트
     * @throws IllegalArgumentException 입력이 유효하지 않을 경우 예외처리
     */
    fun inputNum(): List<Int> {
        val inputString = Console.readLine()
        while (inputString == null || !isValidInput(inputString)) {
            throw IllegalArgumentException("유효하지 않은 입력입니다. 시스템이 종료됩니다.")
        }

        return inputString.chunked(1).map { it.toInt() }
    }

    /**
     * isValidInput()
     * 유효한 입력(길이:3, 입력형태:Int)인지 확인 후 유효할 경우에만 true return
     *
     * @param inputList 확인할 입력 문자열
     * @return 입력이 3자리이고, 숫자로만 구성된 경우 true를 반환
     */
    private fun isValidInput(inputList: String): Boolean {
        return inputList.length == 3 && inputList.all { it.isDigit() }
    }


    /**
     * compareResult()
     * 사용자가 입력한 숫자와 컴퓨터가 선택한 숫자를 비교하여 결과를 계산
     *
     * @param userList 사용자가 입력한 숫자 리스트
     * @param computerList 컴퓨터가 선택한 숫자 리스트
     * @return 결과 문자열 (스트라이크, 볼, 낫싱)
     */
    fun compareResult(userList: List<Int>, computerList: List<Int>): GameModel {
        var strikes = 0
        var balls = 0

        for (i in userList.indices) {
            if (userList[i] == computerList[i]) {
                strikes++
            } else if (computerList.contains(userList[i])) {
                balls++
            }
        }

        return when {
            strikes == 0 && balls == 0 -> {
                GameModel(nothing = true)
            }
            else -> {
                if (strikes == 3) {
                    GameModel(
                        strike = 3
                    )
                } else {
                    GameModel(
                        strike = strikes, ball = balls
                    )
                }
            }
        }
    }

    /**
     * restartGame()
     * 사용자로부터 게임 재시작 또는 종료를 입력받는 함수
     *
     * @return 게임을 재시작하면 true, 게임을 종료하면 false를 반환
     */
    fun restartGame(): Boolean {
        var input = Console.readLine()
        while (input != "1" && input != "2") {
            println("유효하지 않은 입력입니다.")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            input = Console.readLine()
        }
        return when (input) {
            "1" -> true
            "2" -> false
            else -> false
        }
    }
}