package baseball

class BaseBall(computerList: List<Int>) {
    private val regex = Regex("^([1-9])([1-9])([1-9])\$")
    private lateinit var userList: List<Int>
    fun startGame(computerList: List<Int>) {
        while (true) {
            val input = readln()
            checkInput(input)
            insertUserList(input)
        }
    }


    private fun insertUserList(input: String) {
        regex.matchEntire(input)?.let { result ->
            setUserList(result.groupValues)
        }?.run {
            throw IllegalArgumentException("입력이 잘못되었습니다.")
        }
    }

    private fun setUserList(groupValues: List<String>) {
        userList = listOf(groupValues[0].toInt(), groupValues[1].toInt(), groupValues[2].toInt())
    }

    private fun checkInput(input: String) {
        if (!regex.matches(input)) {
            throw IllegalArgumentException("입력이 잘못되었습니다.")
        }
    }


}