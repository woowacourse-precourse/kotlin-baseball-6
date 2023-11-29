package baseball.domain.model

import baseball.domain.util.allInRange
import baseball.domain.util.doesNotHaveDuplicates
import baseball.domain.util.hasSize

data class Computer(
    val number: List<Int>,
) {
    init {
        require(number.hasSize(3)) { "[ERROR] 3개가 아님" }
        require(number.allInRange(1..9)) { "[ERROR] 1~9 사이가 아님" }
        require(number.doesNotHaveDuplicates()) { "[ERROR] 중복 있음" }
    }
}