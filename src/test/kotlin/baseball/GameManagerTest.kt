package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class GameManagerTest {

    @Test
    fun `GameManager는 게임이 시작되면 랜덤한 타겟 넘버를 가진다`() {
        //given
        val gameManager = GameManager()

        //when
        gameManager.startGame()

        //then
        val actual = gameManager.targetNumber
        assertTrue(actual is List<Int> && actual.toSet().size == 3)
    }

    @Test
    fun `타겟 넘버와 사용자의 입력 값을 비교하였을 때, 겹치는 숫자가 있고, 그 숫자의 위치까지 일치할 경우 스트라이크가 1 올라간다`() {
        //given
        val gameManager = GameManager()
        gameManager.startGame()
        val targetNumber = gameManager.targetNumber

        //when
        //1 스트라이크
        val playerInput = mutableListOf<Int>(targetNumber[0])
        for (num in 1..9) {
            if (playerInput.size < 3 && num !in gameManager.targetNumber) {
                playerInput.add(num)
            }
        }
        gameManager.calculateStrikeBall(playerInput.toList())

        //then
        val actual = gameManager.getScoreBoard()
        val expected = hashMapOf(Pair("strike", 1), Pair("ball", 0))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `타겟 넘버와 사용자의 입력 값을 비교하였을 때, 겹치는 숫자가 있지만 숫자의 위치가 다를 경우 볼이 1 올라간다`() {
        //given
        val gameManager = GameManager()
        gameManager.startGame()
        val targetNumber = gameManager.targetNumber

        //when
        //1 볼
        val playerInput = mutableListOf<Int>(targetNumber[1])
        for (num in 1..9) {
            if (playerInput.size < 3 && num !in gameManager.targetNumber) {
                playerInput.add(num)
            }
        }
        gameManager.calculateStrikeBall(playerInput.toList())

        //then
        val actual = gameManager.getScoreBoard()
        val expected = hashMapOf(Pair("strike", 0), Pair("ball", 1))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `타겟 넘버와 사용자의 입력 값을 비교하였을 때, 스트라이크가 3개일 경우 게임을 종료한다`() {
        //given
        val gameManager = GameManager()
        gameManager.startGame()

        //when
        //3 스트라이크
        val playerInput = gameManager.targetNumber
        gameManager.calculateStrikeBall(playerInput.toList())

        //then
        val actual = gameManager.gameState
        val expected = GameManager.GameState.ENDED
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `타겟 넘버와 사용자의 입력 값을 비교하였을 때, 숫자가 하나도 겹치지 않을 경우 낫싱을 출력한다`() {
        //given
        val gameManager = GameManager()
        gameManager.startGame()
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        //when
        //낫싱
        val playerInput = mutableListOf<Int>()
        for (num in 1..9) {
            if (playerInput.size < 3 && num !in gameManager.targetNumber) {
                playerInput.add(num)
            }
        }

        gameManager.calculateStrikeBall(playerInput.toList())
        System.setOut(System.out)

        //then
        val actual = outputStream.toString().trim()
        val expected = "낫싱"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `타겟 넘버와 사용자의 입력 값을 비교하였을 때, 낫싱이 아닌 경우에는 볼과 스트라이크 수를 출력한다`() {
        //given
        val gameManager = GameManager()
        gameManager.startGame()
        val targetNumber = gameManager.targetNumber

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        //when
        //1스트라이크 1볼
        val playerInput = mutableListOf<Int>(targetNumber[0],targetNumber[2])
        for (num in 1..9) {
            if (playerInput.size < 3 && num !in gameManager.targetNumber) {
                playerInput.add(num)
            }
        }

        gameManager.calculateStrikeBall(playerInput.toList())
        System.setOut(System.out)

        //then
        val actual = outputStream.toString().trim()
        val expected = "1볼 1스트라이크"
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `게임이 종료된 뒤, 사용자가 1을 입력했을 경우, 게임을 계속 진행한다`(){
        //given
        val gameManager = GameManager()
        gameManager.gameState = GameManager.GameState.ENDED

        //when
        gameManager.handlePlayerChoiceAfterGame("1")

        //then
        val actual = gameManager.gameState
        val expected = GameManager.GameState.INPROGRESS
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `게임이 종료된 뒤, 사용자가 2를 입력했을 경우, 게임을 종료한다`(){
        //given
        val gameManager = GameManager()
        gameManager.gameState = GameManager.GameState.ENDED

        //when
        gameManager.handlePlayerChoiceAfterGame("2")

        //then
        val actual = gameManager.gameState
        val expected = GameManager.GameState.ENDED
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `재시작 여부 입력에 문자열을 입력할 수 없다`(){
        //given
        val gameManager = GameManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            gameManager.handlePlayerChoiceAfterGame("가나다")
        }
    }

    @Test
    fun `재시작 여부 입력에 2개의 값을 입력받을 수 없다`(){
        //given
        val gameManager = GameManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
            gameManager.handlePlayerChoiceAfterGame("12")
        }
    }

    @Test
    fun `재시작 여부 입력에 1과 2 이외의 숫자는 입력받을 수 없다`(){
        //given
        val gameManager = GameManager()

        //when

        //then
        assertThrows<IllegalArgumentException> {
           gameManager.handlePlayerChoiceAfterGame("3")
        }
    }
}