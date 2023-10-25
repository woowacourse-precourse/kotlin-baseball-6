package baseball

import baseball.domain.userChoiceValidation
import baseball.domain.userNumberValidation
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UserValidationTest {

    @Test
    fun `사용자가 2자리 숫자 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "12".userNumberValidation()
        }
    }

    @Test
    fun `사용자가 3자리 이상 숫자 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "1221312432".userNumberValidation()
        }
    }

    @Test
    fun `사용자가 1 ~ 9 이외 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "1c3".userNumberValidation()
        }
    }

    @Test
    fun `사용자가 중복된 숫자 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "113".userNumberValidation()
        }
    }

    @Test
    fun `사용자가 1, 2가 아닌 숫자 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "3".userChoiceValidation()
        }
    }

    @Test
    fun `사용자가 1, 2가 아닌 문자 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "가".userChoiceValidation()
        }
    }

    @Test
    fun `사용자가 공백 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "".userChoiceValidation()
        }
    }
}