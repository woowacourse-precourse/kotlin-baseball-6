package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class GameManager {
    private val computerNumberList = mutableListOf<Int>()
    private val userNumberList = mutableListOf<Int>()
    private var state = true
    private var result = true

    fun execute() {
        println("숫자 야구 게임을 시작합니다.")

        while(state) {
            initComputer()

            initUser()
            while (result) {
                print("숫자를 입력해주세요 : ")

                initUser()
                getResult()
            }
            finish()
        }
    }

    private fun initComputer() {
        val computer = Computer()
        if (computerNumberList.isNotEmpty()) computerNumberList.clear()
        computerNumberList.addAll(computer.getNumberList())
    }

    private fun initUser() {
        val user = User()
        if (userNumberList.isNotEmpty()) userNumberList.clear()
        userNumberList.addAll(user.getNumberList())
    }

    private fun getResult() {
        val referee = Referee()
        result = !(referee.getResult(computerNumberList, userNumberList))
    }

    private fun finish() {
        val user = User()
        val finishNumber = user.getFinishNumber()
        if (finishNumber == 1) restart()
        else exit()
    }

    private fun restart() {
        result = true
        state = true
    }

    private fun exit() {
        state = false
    }
}