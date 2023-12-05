package baseball.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ScoreTest {

    @Nested
    inner class Constructor {

        @Test
        fun success() {
            assertThatCode { Score(2, 1) }
                    .doesNotThrowAnyException()
        }

        @Test
        fun fail() {
            assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
                Score(2, 2)
            }.withMessageContaining("스트라이크와 볼의 합계는 0와 3 사이에 위치해야합니다.")

        }

    }

    @Test
    fun isStrike() {
        // given
        // when
        val score = Score(3, 0)

        // then
        assertThat(score.isEnd()).isTrue()
    }

    @Test
    fun isNothing() {
        // given
        // when
        val score = Score(0, 0)

        // then
        assertThat(score.isNothing()).isTrue()
    }
}
