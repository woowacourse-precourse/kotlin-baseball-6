package player

import org.junit.jupiter.api.BeforeEach

class PlayerTest {
    private lateinit var player: Player

    @BeforeEach
    fun setUp() {
        player = PlayerImpl()
    }
}