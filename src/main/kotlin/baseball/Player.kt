package baseball

class Player {

    var guessNumber : List<Int>? = null
        private set

    fun setGuessNumber(userInput : String){
        validateUserInput(userInput)

        guessNumber = userInput.toList().map{
            it.toString().toInt()
        }
    }
    
    private fun validateUserInput(userInput : String){
        requireNotNull(userInput.toIntOrNull()){
            "숫자만 입력하실 수 있습니다."
        }
        require(userInput.length == 3){
            "세 자리 숫자만 입력하실 수 있습니다."
        }
        require(!userInput.contains("0")){
            "숫자에 0은 포함될 수 없습니다."
        }
        require(userInput.length == userInput.toSet().size){
            "중복되는 숫자는 입력될 수 없습니다."
        }
    }
}