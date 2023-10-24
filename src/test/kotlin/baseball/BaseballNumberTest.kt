package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class BaseballNumberTest {

    @Test
    fun `성공 케이스`() {
        val testCases = listOf(
            "123",
            "629",
            "427",
        )
        testCases.forEach { case ->
            assertDoesNotThrow {
                BaseballNumber.createOrThrow(case)
            }
        }
    }

    @Test
    fun `3자리가 아니면 예외를 던진다`() {
        val testCases = listOf(
            "",
            "13",
            "1523",
        )
        testCases.assertThrows<String, IllegalArgumentException> { case ->
            BaseballNumber.createOrThrow(case)
        }
    }

    @Test
    fun `숫자가 아닌 문자가 있으면 예외를 던진다`() {
        val testCases = listOf(
            "1 3",
            "h25",
            "34.",
            "2.2"
        )
        testCases.assertThrows<String, IllegalArgumentException> { case ->
            BaseballNumber.createOrThrow(case)
        }
    }

    @Test
    fun `중복되는 숫자가 있으면 예외를 던진다`() {
        val testCases = listOf(
            "131",
            "559",
            "888"
        )
        testCases.assertThrows<String, IllegalArgumentException> { case ->
            BaseballNumber.createOrThrow(case)
        }
    }

    @Test
    fun `0을 포함하면 예외를 던진다`() {
        val testCases = listOf(
            "103",
            "092",
            "540"
        )
        testCases.assertThrows<String, IllegalArgumentException> { case ->
            BaseballNumber.createOrThrow(case)
        }
    }

    @Test
    fun `판정 함수 테스트`() {
        val computerNumber = BaseballNumber.createOrThrow("713")
        val inputs = listOf(
            BaseballNumber.createOrThrow("123"),
            BaseballNumber.createOrThrow("145"),
            BaseballNumber.createOrThrow("671"),
            BaseballNumber.createOrThrow("216"),
            BaseballNumber.createOrThrow("713")
        )
        val outputs = listOf(
            JudgeResult(balls = 1, strikes = 1),
            JudgeResult(balls = 1),
            JudgeResult(balls = 2),
            JudgeResult(strikes = 1),
            JudgeResult(strikes = 3)
        )
        inputs.forEachIndexed { index, input ->
            val result = computerNumber.judge(input)
            val output = outputs[index]
            assert(result == output) {
                "Failed at $index index. Expected ${output}, Actual: $result"
            }
        }
    }

    private inline fun <T, reified E : Throwable> List<T>.assertThrows(executable: (T) -> Unit) {
        this.forEach { element ->
            assertThrows<E> {
                executable(element)
            }
        }
    }
}