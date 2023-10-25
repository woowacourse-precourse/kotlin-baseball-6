package baseball.domain

import baseball.util.NumberPicker
import java.util.*

class FixedNumberPicker(vararg numbers: Int) : NumberPicker {
    private val numbers: Queue<Int> = LinkedList(numbers.toList())

    override fun pick(): Int {
        return numbers.poll() ?: throw NoSuchElementException("더 이상 뽑을 숫자가 없습니다.")
    }

}