package baseball

object Exception {

    fun validationInputLength(input: String){
        if(input.length > 3 || input.length < 1) {
            throw IllegalArgumentException("값은 3자리 수를 입력하셔야 합니다.")
        }
    }

    fun validationDigit(input: String){
        input.forEach {
            if(!it.isDigit()) {
                throw IllegalArgumentException("숫자를 입력해주세요.")
            }
        }
    }

    fun validationDigitRange(input: String){
        input.forEach {
            if(it > '9' || it < '1') {
                throw IllegalArgumentException("입력은 1-9까지의 숫자를 입력해주세요.")
            }
        }
    }
}