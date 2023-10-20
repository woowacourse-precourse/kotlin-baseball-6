package utils

object Exception {

    fun String.userWrongTypeAnswer() = require(this.toIntOrNull() != null) { "게임 종료" }
}
