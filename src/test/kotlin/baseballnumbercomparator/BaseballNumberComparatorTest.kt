package baseballnumbercomparator

import org.junit.jupiter.api.BeforeEach

class BaseballNumberComparatorTest {
    private lateinit var baseballNumberComparator: BaseballNumberComparator

    @BeforeEach
    fun setUp() {
        baseballNumberComparator = BaseballNumberComparatorImpl()
    }
}