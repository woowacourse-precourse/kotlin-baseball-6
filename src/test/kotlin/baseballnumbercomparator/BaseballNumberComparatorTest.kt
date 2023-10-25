package baseballnumbercomparator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BaseballNumberComparatorTest {
    private lateinit var baseballNumberComparator: BaseballNumberComparator

    @BeforeEach
    fun setUp() {
        baseballNumberComparator = BaseballNumberComparatorImpl()
    }

    @Test
    fun `세 자리수 모두 자리, 숫자가 같을 떄 3스트라이크가 나오는지 확인`() {
        val result = baseballNumberComparator.compareAnswerWithPlayerBaseballNumber("123", "123")

        assertEquals(result, BaseballResult(strike = 3, ball = 0))
    }
}