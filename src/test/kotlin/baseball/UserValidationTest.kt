package baseball

import baseball.User.userNumberValidation
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UserValidationTest : NsTest() {

    @Test
    fun `사용자가 2자리 숫자 입력`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            "12".userNumberValidation()
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

    override fun runMain() {
        main()
    }
}