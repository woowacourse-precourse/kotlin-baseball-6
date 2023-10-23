package baseball.util

object CheckUtil {

    //플레이어의 input형태 체크
    fun checkInput(input:String){
        if(!isValidInput(input)) throw IllegalArgumentException("서로다른 1부터 9사이의 숫자 3자리를 입력해주세요.")
    }

    //player의 input 형태 boolean 체크
    private fun isValidInput(input : String) :Boolean {
        if(input.length != 3) return false

        val inputSet = input.toSet()
        return inputSet.size == 3 && input.all { it in '1'..'9' }
    }

    //replay input 형태 체크
    fun checkReplayInput(replay : String){
        when (replay){
            "1" -> {}
            "2" -> {}
            else -> throw IllegalArgumentException("1또는 2를 입력해주세요.")
        }
    }
}