package baseball

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameManagerTest{

    @Test
    fun `GameManager는 게임이 시작되면 랜덤한 타겟 넘버를 가진다`(){
        //given
        val gameManager = GameManager()

        //when
        gameManager.gameStart()

        //then
        val actual = gameManager.targetNumber
        assertTrue(actual is List<Int> && actual.size == 3)
    }
}