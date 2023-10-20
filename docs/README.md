## 기능 목록

- [x] 야구 게임 시작 - run()#BaseballController
- [x] 게임 시작 문구 출력 기능 - printGameStartMessage()#OutputView
- [ ] 야구 게임 진행 - processGameInProgress()#BaseballController
- [x] 랜덤 야구 숫자 생성 기능 - generateRandomNumber()#BaseballGame
- [x] 숫자를 입력해주세요 출력 기능 - printNumberInputMessage()#OutputView
- [x] 숫자를 입력하는 기능 - getInputNumber()#InputView
- [x] 스트라이크, 볼 확인 기능 - calculateScore()#BaseballGame
- [ ] 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시하는 기능 - printScoreMessage()#OutputView
- [ ] 정답인지 확인하는 기능 - isCorrectAnswer()#BaseballGame
- [ ] 게임 종료/재시작 입력 기능 - getInputBaseballRestart()#InputView
- [ ] 게임 종료/재시작 기능 - gameRestart()#BaseballController
- [x] 예외 처리 함수 #Exception
  - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료하는 기능
  - [x] 입력한 값이 숫자가 아닌 경우 예외 처리
  - [x] 입력한 값이 3개의 숫자가 아닌 경우 예외 처리
- [x] 상수 값 #Constant