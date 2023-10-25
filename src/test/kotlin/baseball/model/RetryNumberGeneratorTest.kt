package baseball.model

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RetryNumberGeneratorTest {

    private lateinit var retryNumberGenerator: RetryNumberGenerator

    @Test
    fun `입력받은 텍스트가 1자리인지 테스트`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {  retryNumberGenerator = RetryNumberGenerator("111") }
        }
    }

    @Test
    fun `입력받은 텍스트가 모두 1또는 2인지 테스트`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {  retryNumberGenerator = RetryNumberGenerator("5") }
        }
    }

}