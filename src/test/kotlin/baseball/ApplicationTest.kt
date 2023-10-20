package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class ApplicationTest {

    @Nested
    inner class Exceptions {

        @Test
        fun `숫자 이외의 값을 입력 받을 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { processInputWithException("cat") }
                assertThrows<IllegalArgumentException> { processInputWithException("") }
                assertThrows<IllegalArgumentException> { processInputWithException("dog&cat") }
                assertThrows<IllegalArgumentException> { processInputWithException("abc123") }
            }
        }

        @Test
        fun `서로 다른 3개의 숫자가 아닐 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { processInputWithException("131") }
                assertThrows<IllegalArgumentException> { processInputWithException("12345") }
                assertThrows<IllegalArgumentException> { processInputWithException("5675") }
                assertThrows<IllegalArgumentException> { processInputWithException("12") }
            }

        }


    }


}
//
//class ApplicationTest : NsTest() {
//
//    inner class
//
//    @Test
//    fun`예외테스트-숫자 이외의 값을 입력 받을 경우`() {
//        assertSimpleTest {
//            assertThrows<IllegalArgumentException> { processInputWithException("hello") }
//        }
//    }
//
//    @Test
//    fun`예외테스트-숫자 이외의 값을 입력 받을 경우`() {
//        assertSimpleTest {
//            assertThrows<IllegalArgumentException> { processInputWithException("hello") }
//        }
//    }
//
//
////    @Test
////    fun `게임종료 후 재시작`() {
////        assertRandomNumberInRangeTest(
////            {
////                run("246", "135", "1", "597", "589", "2")
////                assertThat(output())
////                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
////            },
////            1, 3, 5, 5, 8, 9
////        )
////    }
//
////
////
////    override fun runMain() {
////        main()
////    }
//}
