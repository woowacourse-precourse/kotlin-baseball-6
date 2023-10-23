package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `야구게임의 모든 출력 검증, 게임 종료후 재시작 검증`() {
        assertRandomNumberInRangeTest(
            {
                run("456", "231", "132", "123", "1", "123", "498", "489", "2")
                assertThat(output())
                    .contains(
                        "낫싱", "3볼", "2볼 1스트라이크", "3스트라이크",
                        "낫싱", "2볼 1스트라이크", "3스트라이크", "게임 종료"
                    )
            },
            1, 2, 3, 4, 8, 9
        )

        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `사용자 Baseball 입력 예외 테스트`() {
        assertSimpleTest {
            // 자리수 테스트
            assertThrows<IllegalArgumentException> { runException("1234") } // 4자리
            assertThrows<IllegalArgumentException> { runException("12") }   // 2자리
            // 빈 문자열("")을 runException으로 전달하면 assertThrows에서
            // IllegalArgumentException 오류가 발생하여 테스트가 불가능함 "" -> null로 대체
            // assertThrows<IllegalArgumentException> { runException("") }  // ""
            assertThrows<IllegalArgumentException> { runException(null) }   // 0자리

            // 숫자0, 문자, 특수문자 테스트
            assertThrows<IllegalArgumentException> { runException("012") }  // 숫자0 포함 3자리
            assertThrows<IllegalArgumentException> { runException("aaa") }  // 문자 3자리
            assertThrows<IllegalArgumentException> { runException("a165") } // 문자 포함 4자리
            assertThrows<IllegalArgumentException> { runException("#^$") }  // 특수문자 3자리
            assertThrows<IllegalArgumentException> { runException("#215") } // 특수문자 포함 4자리

            // 중복 테스트
            assertThrows<IllegalArgumentException> { runException("112") }  // 숫자1 중복
            assertThrows<IllegalArgumentException> { runException("565") }  // 숫자5 중복
            assertThrows<IllegalArgumentException> { runException("988") }  // 숫자8 중복
            assertThrows<IllegalArgumentException> { runException("999") }  // 숫자9 중복

            // 오류 없는지 검증
            assertDoesNotThrow { runException("123") }
            assertDoesNotThrow { runException("456") }
            assertDoesNotThrow { runException("789") }
        }
    }

//    @Test
//    fun `사용자 Menu 입력 예외 테스트`() { - How?
//        // 자리수 테스트
//        assertThrows<IllegalArgumentException> { runException("1234") } // 4자리
//        assertThrows<IllegalArgumentException> { runException("12") }   // 2자리
//
//        // 숫자0, 문자, 특수문자 테스트
//        assertThrows<IllegalArgumentException> { runException("012") }  // 숫자0 포함 3자리
//        assertThrows<IllegalArgumentException> { runException("aaa") }  // 문자 3자리
//        assertThrows<IllegalArgumentException> { runException("a165") } // 문자 포함 4자리
//        assertThrows<IllegalArgumentException> { runException("#^$") }  // 특수문자 3자리
//        assertThrows<IllegalArgumentException> { runException("#215") } // 특수문자 포함 4자리
//
//        // 중복 테스트
//        assertThrows<IllegalArgumentException> { runException("212") }  // 숫자2 중복
//        assertThrows<IllegalArgumentException> { runException("551") }  // 숫자5 중복
//        assertThrows<IllegalArgumentException> { runException("555") }  // 숫자5 중복
//
//        // 빈 문자열("")을 runException으로 전달하면 assertThrows에서
//        // IllegalArgumentException 오류가 발생하여 테스트가 불가능함 "" -> null로 대체
//        // assertThrows<IllegalArgumentException> { runException("") }  // ""
//        assertThrows<IllegalArgumentException> { runException(null) }   // null
//    }


    override fun runMain() {
        main()
    }
}
