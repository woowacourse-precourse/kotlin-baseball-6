package baseball.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("두 수를 비교하는 class에서")
class NumberComparatorTest {

    @Test
    @DisplayName("사용자 123을 입력하고, randomnumber가 132이면 비교 결과로 1볼 1스트라이크의 결과를 얻는다")
    fun compareEachNumbers() {
        //given
        val numberComparator = NumberComparator(UserExpect("123"))
        val randomNumber = RandomNumber(132)
        //when
        val compareResult = numberComparator.compareEachNumbers(randomNumber)
        //then
        Assertions.assertThat(compareResult.countStrike()).isEqualTo(1)
        Assertions.assertThat(compareResult.countBall()).isEqualTo(2)
    }

    @Test
    @DisplayName("사용자 123을 입력하고, randomnumber가 123이면 비교 결과로 3스트라이크의 결과를 얻는다")
    fun compareSameNumber() {
        //given
        val numberComparator = NumberComparator(UserExpect("123"))
        val randomNumber = RandomNumber(123)
        //when
        val compareResult = numberComparator.compareEachNumbers(randomNumber)
        //then
        Assertions.assertThat(compareResult.countStrike()).isEqualTo(3)
        Assertions.assertThat(compareResult.countBall()).isEqualTo(0)
    }

    @Test
    @DisplayName("사용자가 456을 입력하고, randomnumber가 123이면 비교 결과로 낫싱의 결과를 얻는다")
    fun compareNothingNumber() {
        //given
        val numberComparator = NumberComparator(UserExpect("456"))
        val randomNumber = RandomNumber(123)
        //when
        val compareResult = numberComparator.compareEachNumbers(randomNumber)
        //then
        Assertions.assertThat(compareResult.countStrike()).isEqualTo(0)
        Assertions.assertThat(compareResult.countBall()).isEqualTo(0)
    }

    @Test
    @DisplayName("사용자가 406을 입력하면 0을 포함하기 때문에 IllegalArgumentException이 발생한다")
    fun compareContainZero() {
        //given
        val numberComparator = NumberComparator(UserExpect("406"))
        val randomNumber = RandomNumber(123)
        //when
        //then
        Assertions.assertThatThrownBy { numberComparator.compareEachNumbers(randomNumber) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("사용자가 446을 입력하면 4의 중복이 있기 때문에 IllegalArgumentException이 발생한다")
    fun duplicatedNumber() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { NumberComparator(UserExpect("446")) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}