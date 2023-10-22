package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyInt

class GameManagerTest{

    @Test
    fun `GameManager는 게임이 시작되면 랜덤한 타겟 넘버를 가진다`(){
        //given
        val gameManager = GameManager()

        //when
        gameManager.gameStart()

        //then
        val actual = gameManager.targetNumber()
        val expected = listOf(anyInt(),anyInt(),anyInt())
        assertThat(actual).isEqualTo(expected)
    }
}