package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.InvocationTargetException

class BaseballConsoleTest {

    private val console = BaseballConsole()

    @Test
    fun 빈_값_입력() {
        // given
        val method = BaseballConsole::class.java.getDeclaredMethod("validateUserInput", String::class.java)
        method.isAccessible = true

        // when
        val input = ""

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 공백_입력() {
        // given
        val method = BaseballConsole::class.java.getDeclaredMethod("validateUserInput", String::class.java)
        method.isAccessible = true

        // when
        val input = "   "

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 공백_포함_숫자_세자리() {
        // given
        val method = BaseballConsole::class.java.getDeclaredMethod("validateUserInput", String::class.java)
        method.isAccessible = true

        // when
        val input = " 123 "
        val result = method.invoke(console, input) as String

        // then
        Assertions.assertEquals("123", result)
    }

    @Test
    fun 숫자_외_입력() {
        // given
        val method = BaseballConsole::class.java.getDeclaredMethod("validateUserInput", String::class.java)
        method.isAccessible = true

        // when
        val input = "q12"

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 영_포함_입력() {
        // given
        val method = BaseballConsole::class.java.getDeclaredMethod("validateUserInput", String::class.java)
        method.isAccessible = true

        // when
        val input = "012"

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 세자리_이상_입력() {
        // given
        val method = BaseballConsole::class.java.getDeclaredMethod("validateUserInput", String::class.java)
        method.isAccessible = true

        // when
        val input = "1234"

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 숫자_중복_입력() {
        // given
        val method = BaseballConsole::class.java.getDeclaredMethod("validateUserInput", String::class.java)
        method.isAccessible = true

        // when
        val input = "144"

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 재시작_플래그() {
        // given
        val console = BaseballConsole()
        val method = BaseballConsole::class.java.getDeclaredMethod("validateEndFlag", String::class.java)
        method.isAccessible = true

        // when
        val input = "1"
        val result = method.invoke(console, input) as EndFlag

        // then
        Assertions.assertEquals(EndFlag.RESTART, result)

    }

    @Test
    fun 종료_플래그() {
        // given
        val console = BaseballConsole()
        val method = BaseballConsole::class.java.getDeclaredMethod("validateEndFlag", String::class.java)
        method.isAccessible = true

        // when
        val input = "2"
        val result = method.invoke(console, input) as EndFlag

        // then
        Assertions.assertEquals(EndFlag.FINISH, result)
    }

    @Test
    fun 종료_플래그_공백포함() {
        // given
        val console = BaseballConsole()
        val method = BaseballConsole::class.java.getDeclaredMethod("validateEndFlag", String::class.java)
        method.isAccessible = true

        // when
        val input = "2  "
        val result = method.invoke(console, input) as EndFlag

        // then
        Assertions.assertEquals(EndFlag.FINISH, result)
    }


    @Test
    fun 종료_플래그_문자입력() {
        // given
        val console = BaseballConsole()
        val method = BaseballConsole::class.java.getDeclaredMethod("validateEndFlag", String::class.java)
        method.isAccessible = true

        // when
        val input = "a"

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 종료_플래그_빈값() {
        // given
        val console = BaseballConsole()
        val method = BaseballConsole::class.java.getDeclaredMethod("validateEndFlag", String::class.java)
        method.isAccessible = true

        // when
        val input = ""

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }

    @Test
    fun 종료_플래그_공백만() {
        // given
        val console = BaseballConsole()
        val method = BaseballConsole::class.java.getDeclaredMethod("validateEndFlag", String::class.java)
        method.isAccessible = true

        // when
        val input = "    "

        // then
        try {
            method.invoke(console, input)
        } catch (e: InvocationTargetException) {
            Assertions.assertEquals(IllegalArgumentException::class.java, e.targetException.javaClass)
        }
        assertThrows<InvocationTargetException> {
            method.invoke(console, input)
        }
    }
}