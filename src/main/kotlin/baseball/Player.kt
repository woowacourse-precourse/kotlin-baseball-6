package baseball

class Player {
    companion object{
        private const val REQUIRED_INPUT_LENGTH = 3
    }

    lateinit var guessNumber : List<Int>
        private set

    fun setGuessNumber(playerInput : String){
        validatePlayerInput(playerInput)

        guessNumber = playerInput.toList().map{
            it.toString().toInt()
        }
    }

    private fun validatePlayerInput(playerInput : String){
        requireNotNull(playerInput.toIntOrNull()){
            "숫자만 입력하실 수 있습니다."
        }
        require(playerInput.length == REQUIRED_INPUT_LENGTH){
            "세 자리 숫자만 입력하실 수 있습니다."
        }
        require(!playerInput.contains("0")){
            "숫자에 0은 포함될 수 없습니다."
        }
        require(playerInput.length == playerInput.toSet().size){
            "중복되는 숫자는 입력될 수 없습니다."
        }
    }
}