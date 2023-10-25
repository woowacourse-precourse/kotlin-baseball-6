package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    private val validator = Validator()
    private val numberCount = 5
    private val minNumber = 3
    private val maxNumber = 8

    @Test
    fun `입력 숫자 개수 검증 테스트`() {
        val inputs = listOf("1", "12", "123", "1234")

        assertSimpleTest {
            for (input in inputs) {
                assertThrows<IllegalArgumentException> {
                    validator.validateNumbers(input, numberCount, minNumber, maxNumber)
                }
            }
        }
    }

    @Test
    fun `입력 숫자 타입 검증 테스트`() {
        val inputs = listOf("abcde", "a1234", "12a34")

        assertSimpleTest {
            for (input in inputs) {
                assertThrows<IllegalArgumentException> {
                    validator.validateNumbers(input, numberCount, minNumber, maxNumber)
                }
            }
        }
    }

    @Test
    fun `입력 숫자 범위 검증 테스트`() {
        val inputs = listOf("12345", "27845", "87659")

        assertSimpleTest {
            for (input in inputs) {
                assertThrows<IllegalArgumentException> {
                    validator.validateNumbers(input, numberCount, minNumber, maxNumber)
                }
            }
        }
    }

    @Test
    fun `입력 숫자 중복 검증 테스트`() {
        val inputs = listOf("34566", "33456", "55555")

        assertSimpleTest {
            for (input in inputs) {
                assertThrows<IllegalArgumentException> {
                    validator.validateNumbers(input, numberCount, minNumber, maxNumber)
                }
            }
        }
    }
}