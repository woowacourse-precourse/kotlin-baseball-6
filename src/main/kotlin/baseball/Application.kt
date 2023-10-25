package baseball

import baseball.console.GameConsole
import baseball.manager.MessageManager
import baseball.manager.ScoreManager
import baseball.validation.CheckNumberValidation

fun main() {
    val scoreManager = ScoreManager()
    val messenger = MessageManager()
    val discriminator = CheckNumberValidation()

    messenger.printStartGame()
    while (GameConsole.answer != "2") {
        GameConsole.initComputerNumber()
        while (true) {
            messenger.printEnterNumber() // 시작 멘트
            GameConsole.initUserAnswer() // 응답 받기
            discriminator.checkUserAnswer() // 유효성 검사
            // 스코어 확인
            val (ball, strike) = scoreManager.scoreFromAnswer()
            messenger.printScore(ball, strike) // 스코어 출력
            if (strike == 3) break // 정답 확인
        }
        messenger.printEndGame() // 종료 멘트
        GameConsole.initUserAnswer() // 재시작 입력 값 받기
        discriminator.checkNextStep() // 유효성 검사
    }
}