package baseball.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseBallNumbersGeneratorTest {
    private lateinit var baseBallNumbersGenerator: BaseBallNumbersGenerator

    @BeforeEach
    fun `setUp`() {
        baseBallNumbersGenerator = BaseBallNumbersGenerator()
    }

    @Test
    fun `개수가 3개인지 테스트`() {
        assertEquals(baseBallNumbersGenerator.generate().size, 3)
    }

    @Test
    fun `중복되는 숫자가 없는지 테스트`() {
        assertEquals(baseBallNumbersGenerator.generate().distinct().size, baseBallNumbersGenerator.generate().size)
    }

    @Test
    fun `1에서 9의 숫자로 이루어지는지 테스트`() {
        val oneToNine = (1..9)
        baseBallNumbersGenerator.generate().map { baseballNumber ->
            assert(oneToNine.contains(baseballNumber))
        }
    }

}