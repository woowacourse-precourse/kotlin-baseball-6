package baseball

import baseball.model.BaseballModel
import baseball.view.BaseballView
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class BaseballHintTest {

    private lateinit var outputStreamCaptor: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        this.outputStreamCaptor = ByteArrayOutputStream()
    }

    @DisplayName("낫싱")
    @Test
    fun `isContainNumberTest`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "196")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("낫싱")
    }

    @DisplayName("1스트라이크")
    @Test
    fun `1스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "416")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1스트라이크")
    }

    @DisplayName("2스트라이크")
    @Test
    fun `2스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "426")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2스트라이크")
    }

    @DisplayName("1볼")
    @Test
    fun `1볼 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "267")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼")
    }

    @DisplayName("2볼")
    @Test
    fun `2볼 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "257")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼")
    }

    @DisplayName("3볼")
    @Test
    fun `3볼 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "542")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("3볼")
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    fun `1볼 1스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "456")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼 1스트라이크")
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    fun `2볼 1스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val hint = BaseballModel().calculateHint("425", "524")
        BaseballView().printHintMessage(hint)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼 1스트라이크")
    }
}