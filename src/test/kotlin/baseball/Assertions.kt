package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows

/**
 * [executable]을 실행 후 발생한 Exception의 타입을 비교하고,
 * Exception의 메세지와 전달받은 [errorMessage]와 동일한 지 확인함
 * */
internal inline fun <reified T : Throwable> assertEqualsThrowsMessage(
    errorMessage: String,
    executable: () -> Unit
): T = assertThrows<T>(executable).also { throwable ->
    Assertions.assertEquals(throwable.message, errorMessage)
}