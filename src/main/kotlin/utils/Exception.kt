package utils

import utils.Constant.GAME_OVER_MESSAGE

object Exception {

    fun String.userWrongTypeAnswer() = require(this.toIntOrNull() != null) { GAME_OVER_MESSAGE }

    fun String.userWrongSizeAnswer() = require(this.length == 3) { GAME_OVER_MESSAGE }

    fun String.userWrongDuplicationAnswer() = require(this.toSet().size == this.length) { GAME_OVER_MESSAGE }

}
