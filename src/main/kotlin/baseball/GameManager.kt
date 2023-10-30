package baseball

class GameManager {
    private val computerNumberList = mutableListOf<Int>()
    private val userNumberList = mutableListOf<Int>()
    private var state = INIT
    private var result = INIT

    fun execute() {
        showExecuteMessage()

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
        showInputMessage()
        userNumberList.addAll(user.getNumberList())
    }

    private fun getResult() {
        val referee = Referee()
        result = !(referee.getResult(computerNumberList, userNumberList))
    }

    private fun finish() {
        val user = User()
        showFinishMessage()
        val finishNumber = user.getFinishNumber()
        if (finishNumber == 1) restart()
        else exit()
    }

    private fun restart() {
        state = RESTART
        result = INIT
    }

    private fun exit() {
        state = EXIT
    }

    private fun showExecuteMessage() {
        println("숫자 야구를 시작합니다.")
    }

    private fun showInputMessage() {
        print("숫자를 입력해주세요 : ")
    }

    private fun showFinishMessage() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}