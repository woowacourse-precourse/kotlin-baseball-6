package baseball

class CheckException {

    fun checkInput(num : String) {
        if(num.length != 3 || !isNumber(num)){
            throw IllegalArgumentException(
                "잘못된 값 입력"
            )
        }
    }

    fun checkRestart(num : String) {
        if(num != "1" && num != "2"){
            throw IllegalArgumentException(
                "잘못된 값 입력"
            )
        }
    }

    fun isNumber(s: String?): Boolean {
        if (s == null || s.length == 0) {
            return false
        }
        for (c in s)
        {
            if (c < '0' || c > '9') {
                return false
            }
        }
        return true
    }
}