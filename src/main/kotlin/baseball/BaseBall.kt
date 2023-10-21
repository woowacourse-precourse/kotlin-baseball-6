package baseball

import camp.nextstep.edu.missionutils.Console

enum class GameStatus {
    ONGOING,
    STOP
}

class BaseBall(computerList: List<Int>) {
    private val regex = Regex("^([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])\$")
    private lateinit var userList: List<Int>
    private var gameStatus = GameStatus.ONGOING
    fun startGame(computerList: List<Int>) {
        println("숫자 야구 게임을 시작합니다.")
        while (gameStatus == GameStatus.ONGOING) {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            checkInput(input)
            insertUserList(input)
            gameStatus = printScore(computerList)
        }
    }

    private fun printScore(computerList: List<Int>): GameStatus {
        val countScore = countScore(computerList)
        val strike = countScore.first
        val ball = countScore.second

        return if (strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            GameStatus.STOP
        } else if (strike == 0 && ball == 0) {
            println("낫싱")
            GameStatus.ONGOING
        } else {
            println("${ball}볼 ${strike}스트라이크")
            GameStatus.ONGOING
        }
    }

    private fun countScore(computerList: List<Int>): Pair<Int,Int> {
        var strike =0
        var ball = 0
        computerList.forEachIndexed { index, item ->
            if (item == userList[index]) {
                strike += 1
            }else if( item in userList){
                ball +=1
            }
        }
        return Pair(strike,ball)
    }

    private fun insertUserList(input: String) {
        regex.matchEntire(input)?.let { result ->
            setUserList(result.groupValues)
        }?:run {
            throw IllegalArgumentException("입력이 잘못되었습니다.")
        }
    }

    private fun setUserList(groupValues: List<String>) {
        userList = listOf(groupValues[1].toInt(), groupValues[2].toInt(), groupValues[3].toInt())
    }

    private fun checkInput(input: String) {
        if (!regex.matches(input)) {
            throw IllegalArgumentException("입력이 잘못되었습니다.")
        }
    }


}