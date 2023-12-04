package baseball.domain.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.Exception

class PlayerTest {
    // 플레이어에 모델 규칙에 맞지않는 데이터가 들어가면 에러를 뱉는다.
    @ParameterizedTest
    @MethodSource("provideErrorData")
    fun `에러 뱉을 때`(errorData: List<Int>) {
        assertThatThrownBy { Player(errorData) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .isInstanceOf(Exception::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @ParameterizedTest
    @MethodSource("provideNormalData")
    fun `에러 뱉지않을 때`(normalData: List<Int>) {
        assertThatCode { Player(normalData) }
            .doesNotThrowAnyException()
    }

    companion object {
        @JvmStatic
        fun provideErrorData(): List<Arguments> = listOf(
            Arguments.of(listOf(1, 2, 0)), // 1~9 범위 벗어날 때
            Arguments.of(listOf(1, 2, 2)), // 중복 될 때
            Arguments.of(listOf(1, 2)), // 3개가 아닐 때
        )

        @JvmStatic
        fun provideNormalData(): List<Arguments> = listOf(
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(4, 5, 6)),
            Arguments.of(listOf(7, 8, 9)),
        )
    }
}