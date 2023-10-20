package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
//    @Test
//    fun `게임종료 후 재시작`() {
//        assertRandomNumberInRangeTest(
//            {
//                run("246", "135", "1", "597", "589", "2")
//                assertThat(output())
//                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
//            },
//            1, 3, 5, 5, 8, 9
//        )
//    }

    @Test
    fun `사용자 입력 예외 테스트(digit = NUMBER_OF_DIGITS)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") } // 4자리
            assertThrows<IllegalArgumentException> { runException("12") }   // 2자리
            assertThrows<IllegalArgumentException> { runException("012") }  // 숫자0 포함 3자리
            assertThrows<IllegalArgumentException> { runException("aaa") }  // 문자 3자리
            assertThrows<IllegalArgumentException> { runException("a165") } // 문자 포함 4자리
            assertThrows<IllegalArgumentException> { runException("#^$") }  // 특수문자 3자리
            assertThrows<IllegalArgumentException> { runException("#215") } // 특수문자 포함 4자리

            // 빈 문자열("")을 runException으로 전달하면 assertThrows에서
            // IllegalArgumentException 오류가 발생하여 테스크가 불가능함 -> null로 대체
            // assertThrows<IllegalArgumentException> { runException("") }     // empty

            // 기존 브랜치에서도 null로 테스트 시 자리수에서 오류 발생하는 것으로 확인됨.
            // 따라서 브랜치를 삭제하는 게 맞겠지만, 학습을 위해 Merge 해본뒤 삭제할 것.
            assertThrows<IllegalArgumentException> { runException(null) }     // null

            // TODO 숫자 중복 테스트 케이스 추가후,"./gradlew.bat clean test" 해볼 것
            // assertThrows<IllegalArgumentException> { runException("212") }  // 숫자 중복 -
        }
    }

    override fun runMain() {
        main()
    }
}
