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


BaseballGame

startGame() : 게임 시작

playRound() : 게임 진행

playAgain() : 게임 재시작 또는 종료


Player

getUserInput() : 사용자에게 숫자를 입력받기

isInputValid(userInput: String) : 사용자가 입력한 값이 유효한지 검사


Computer

generateRandomNumbers() :  컴퓨터가 랜덤으로 숫자를 생성

checkUserInput(userInput: String, randomNumber: List<Int>) : 사용자가 입력한 값과 컴퓨터가 생성한 값을 비교

calculateStrikeAndBall(userInput: String, randomNumber: List<Int>) : 스트라이크와 볼을 계산




