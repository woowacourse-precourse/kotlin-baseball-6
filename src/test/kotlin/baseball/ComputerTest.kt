package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ComputerTest {
    private lateinit var computer: Computer

    @BeforeEach
    fun setUp() {
        computer = Computer()
    }

    @Test
    fun `컴퓨터가 생성한 수에 대해 예외가 발생하지 않아야 함`() {
        val computer = Computer()
        Assertions.assertSimpleTest {
            assertDoesNotThrow { computer.generateNumbers() }
        }
    }
}