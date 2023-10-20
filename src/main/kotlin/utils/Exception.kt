package utils

object Exception {

    fun String.userWrongTypeAnswer() = require(this.toIntOrNull() != null) { "게임 종료" }

    fun String.userWrongSizeAnswer() = require(this.length == 3) { "게임 종료" }

    fun String.userWrongDuplicationAnswer() = require(this.toSet().size == this.length) { "게임 종료" }

}
