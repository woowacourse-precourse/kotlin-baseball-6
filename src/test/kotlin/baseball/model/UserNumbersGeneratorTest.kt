package baseball.model

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserNumbersGeneratorTest {

    private lateinit var userNumbersGenerator:UserNumbersGenerator

    @Test
    fun `입력받은 텍스트가 3자리인지 테스트`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {  userNumbersGenerator = UserNumbersGenerator("1234") }
        }
    }

    @Test
    fun `입력받은 텍스트가 모두 숫자인지 테스트`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {  userNumbersGenerator = UserNumbersGenerator("12q") }
        }
    }

    @Test
    fun `입력받은 텍스트의 중복되는 숫자가 없는지 테스트`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {  userNumbersGenerator = UserNumbersGenerator("122") }
        }
    }
}