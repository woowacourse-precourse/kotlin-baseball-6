package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PlayerTest{

    @Test
    fun `플레이어는 문자열을 입력할 수 없다`(){
        //given
        val player = Player()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            player.setGuessNumber("가나다")
        }
    }

    @Test
    fun `플레이어는 2개의 값을 입력받을 수 없다`(){
        //given
        val player = Player()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            player.setGuessNumber("12")
        }
    }

    @Test
    fun `플레이어는 4개의 값을 입력받을 수 있다`(){
        //given
        val player = Player()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            player.setGuessNumber("1234")
        }
    }

    @Test
    fun `플레이어는 중복된 숫자를 입력할 수 없다`(){
        //given
        val player = Player()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            player.setGuessNumber("111")
        }
    }

    @Test
    fun `플레이어는 0이 포함된 숫자를 입력할 수 없다`(){
        //given
        val player = Player()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            player.setGuessNumber("102")
        }
    }


    @Test
    fun `플레이어는 3개의 0이 포함되지 않고 중복되지 않은 숫자만을 입력받을 수 있다`(){
        //given
        val player = Player()

        //when
        player.setGuessNumber("123")

        //then
        val actual = player.guessNumber
        val expected = listOf(1,2,3)
        assertThat(actual).isEqualTo(expected)
    }
}