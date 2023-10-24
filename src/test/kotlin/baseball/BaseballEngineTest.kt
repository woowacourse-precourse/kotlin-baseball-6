package baseball

import baseball.BaseballResult.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.InvocationTargetException

class BaseballEngineTest {

    val engine = BaseballEngine(LinearComparator())

    @Test
    fun 유저_입력_오류() {
        // given
        val computer = "123"
        val user = "4562"

        // when
        // then
        assertThrows<IllegalArgumentException> {
            engine.compare(computer, user)
        }
    }

    @Test
    fun 컴퓨터_입력_오류() {
        // given
        val computer = "1234"
        val user = "456"

        // when
        // then
        assertThrows<IllegalArgumentException> {
            engine.compare(computer, user)
        }
    }

    @Test
    fun 컴퓨터_유저_입력_오류() {
        // given
        val computer = "1234"
        val user = "4562"

        // when
        // then
        assertThrows<IllegalArgumentException> {
            engine.compare(computer, user)
        }
    }

    @Test
    fun nothing() {
        // given
        val computer = "123"
        val user = "456"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Nothing, result)
    }

    @Test
    fun oneStrike1() {
        // given
        val computer = "123"
        val user = "156"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Strike(1), result)
    }

    @Test
    fun oneStrike2() {
        // given
        val computer = "123"
        val user = "826"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Strike(1), result)
    }

    @Test
    fun oneStrike3() {
        // given
        val computer = "123"
        val user = "863"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Strike(1), result)
    }

    @Test
    fun twoStrike1() {
        // given
        val computer = "123"
        val user = "163"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Strike(2), result)
    }

    @Test
    fun twoStrike2() {
        // given
        val computer = "123"
        val user = "623"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Strike(2), result)
    }

    @Test
    fun twoStrike3() {
        // given
        val computer = "123"
        val user = "126"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Strike(2), result)
    }

    @Test
    fun success() {
        // given
        val computer = "123"
        val user = "123"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Success(Strike(3)), result)
    }

    @Test
    fun oneBall() {
        // given
        val computer = "123"
        val user = "516"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Ball(1), result)
    }

    @Test
    fun twoBall() {
        // given
        val computer = "123"
        val user = "235"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Ball(2), result)
    }

    @Test
    fun threeBall() {
        // given
        val computer = "123"
        val user = "231"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(Ball(3), result)
    }


    @Test
    fun oneStrikeOneBall() {
        // given
        val computer = "123"
        val user = "135"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(BallAndStrike(Ball(1), Strike(1)), result)
    }

    @Test
    fun oneStrikeTwoBall() {
        // given
        val computer = "123"
        val user = "321"

        // when
        val result = engine.compare(computer, user)

        // then
        Assertions.assertEquals(BallAndStrike(Ball(2), Strike(1)), result)
    }
}