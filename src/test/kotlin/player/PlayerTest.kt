package player

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayerTest {
    private lateinit var player: Player

    @BeforeEach
    fun setUp() {
        player = PlayerImpl()
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["123", "791", "234"]
    )
    fun `설정한 번호가 저장되는지 확인`(inputNumber: String) {
        player.setBaseballNumber(inputNumber)
        val result = player.baseballNumber

        assertEquals(result, inputNumber)
    }
}