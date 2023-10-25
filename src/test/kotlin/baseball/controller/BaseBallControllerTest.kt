package baseball.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseBallControllerTest {

    private val numbers = mutableListOf(1, 2, 3)

    private lateinit var baseballController: BaseballController

    @BeforeEach
    fun `setUp`() {
        baseballController = BaseballController(numbers)
    }

    @Test
    fun `판정이 정확한지 테스트`() {
        val usersNumbers = mutableListOf(
            mutableListOf(3, 1, 2),
            mutableListOf(4, 5, 6),
            mutableListOf(3, 2, 5),
            mutableListOf(1, 2, 3)
        )
        val expected = mutableListOf(
            "3볼 ",
            "낫싱",
            "1볼 1스트라이크",
            "3스트라이크"
        )
        for (index in usersNumbers.indices) {
            assertEquals(baseballController.judgment(usersNumbers[index]), expected[index])
        }
    }

}