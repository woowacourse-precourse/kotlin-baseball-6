package baseball

class GameManager {
    private val computerNumberList = mutableListOf<Int>()
    private val userNumberList = mutableListOf<Int>()
    private var state = INIT
    private var result = INIT

    // 프로그램 실행
    fun execute() {
        showExecuteMessage()
        while (state) {
            playGame()
            finish()
        }
    }

    private fun playGame() {
        initComputer()
        while (result) {
            initUser()
            getResult()
        }
    }

    // 컴퓨터 숫자 초기화
    private fun initComputer() {
        val computer = Computer()
        if (computerNumberList.isNotEmpty()) computerNumberList.clear()
        computerNumberList.addAll(computer.getNumberList())
    }

    // 유저 숫자 입력
    private fun initUser() {
        val user = User()
        if (userNumberList.isNotEmpty()) userNumberList.clear()
        showInputMessage()
        userNumberList.addAll(user.getNumberList())
    }

    // 채점 기능 - playGame() while문 탈출 기여
    private fun getResult() {
        val referee = Referee()
        result = !(referee.getResult(computerNumberList, userNumberList))
    }

    // 재실행 분기문 - execute() while문 탈출 기여
    private fun finish() {
        val user = User()
        showFinishMessage()
        val finishNumber = user.getFinishNumber()
        if (finishNumber == 1) restart()
        else exit()
    }

    // 게임 재실행 - const 변수 초기화
    private fun restart() {
        result = INIT
        state = RESTART
    }

    // 게임 종료 - false
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