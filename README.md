구현해야할 목록
1. 플레이어가 예측하는 숫자를 반환하는 Player클래스
2. 컴퓨터가 생성하는 랜덤 숫자를 반환하는 Computer클래스
3. 게임을 진행하는 BaseballGame클래스
4. 플레이어가 예측한 숫자와 컴퓨터가 생성한 랜덤 숫자와의 비교
5. 비교 결과 출력
6. 사용자가  랜덤 숫자를 맞출떄까지 반복
7. 게임 종료 후 게임을 다시시작하거나 완전히 종료하는 기능
8. 사용자가 잘못된 값을 입력할경우 IllegalArgumentException을 발생시킨 후  애플리케이션 종료

클래스와 메서드
BaseballGame: startGame(), playRound(), playAgain()
Player: getUserInput(), isInputValid(userInput: String)
Computer: generateRandomNumbers(),  checkUserInput(userInput: String, randomNumber: List<Int>),  calculateStrikeAndBall(userInput: String, randomNumber: List<Int>)

