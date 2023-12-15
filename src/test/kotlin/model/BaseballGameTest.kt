package model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class BaseballGameTest {

    @ParameterizedTest
    @MethodSource("provideUserInputExample")
    fun `볼 스트라이크 로직 테스트`(input:List<Int>,ball:Int,strike: Int) {
        assertRandomNumberInRangeTest({

            val baseballGame = BaseballGame()
            assertEquals(baseballGame.getBallAmount(input),ball)
            assertEquals(baseballGame.getStrikeAmount(input),strike)

        }, 3, 7, 2)
    }

    companion object {

        @JvmStatic
        fun provideUserInputExample() = listOf(
            Arguments.of(listOf(1,2,3),2,0),
            Arguments.of(listOf(4,5,6),0,0),
            Arguments.of(listOf(7,8,9),1,0),
            Arguments.of(listOf(3,7,1),0,2),
            Arguments.of(listOf(3,7,2),0,3)
        )
    }

}