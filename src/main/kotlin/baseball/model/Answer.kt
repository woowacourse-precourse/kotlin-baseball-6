package baseball.model

import baseball.model.validation.checkValidation
import baseball.util.toIntList

class Answer(private val numbers: List<Int>): List<Int> by numbers {

    constructor(input: String) : this(input.run {
        checkValidation()
        toIntList()
    })
}