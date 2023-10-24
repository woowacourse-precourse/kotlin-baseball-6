# 📝 기능 목록 (시나리오)
___
1. 게임 시작 메세지를 출력한다.
2. 컴퓨터(상대방)가 랜덤한 3자리 수를 입력한다.
   1. 이때, 입력받은 숫자는 중복되지 않도록 한다.
3. 사용자가 숫자를 입력한다.
   1. 이때, 입력 받은 숫자는 중복되지 않도록 한다.
   2. 이때, 숫자 입력 시 발생할 수 있는 모든 예외를 처리해준다.
      1. (예외) 숫자가 아닌 값이 입력
      2. (예외) 1~9 사이외의 숫자 값이 입력
      3. (예외) 3자리수 입력이 아님
      4. (예외) 서로 다른 3자리 수가 아님
4. 루프문을 통해 정답을 맞힐 때까지 자리수 맞히기를 반복한다.
   + 볼 판별
   + 스트라이크 판별
   + 낫싱 판별
   + 정답 여부 판별
5. 정답 메세지를 출력해준다.
6. 사용자가 게임 종료 여부를 결정해준다.
   1. 이떄, 숫자 입력 시 발생할 수 있는 모든 예외를 처리해준다.
      1. (예외) 숫자가 아닌 값이 입력
      2. (예외) 1과 2 이외의 숫자 값이 입력
      3. (예외) 1자리수 입력이 아님
7. 사용자가 재시작을 원하면 다시 1번으로 돌아가 같은 과정을 반복한다.

# ⚾ 기능 목록 (역할과 구조)

---
### ✅ Computer(상대방)

---
#### createComputerBallNumbers: 상대방 입력 번호 생성
#### generateRandomBallNumbers: 랜덤 숫자 번호 생성

### ✅ Player(나)

---
#### createPlayerBallNumbers: 플레이어 입력 번호 생성
#### getGameEndDecision: 게임 종료 여부 입력값 반환

### ✅ BaseballGame(야구게임)

---
#### startGame: 게임 시작
#### runGameLoopUntilCorrectAnswer: 정답일 때까지 게임 루프 실행
#### checkAnswer: 정답 여부 판별
#### printMatchedBallInfo: 스트라이크, 볼, 낫싱 판별후 결과값 출력
#### checkHasGameEnded: 게임 종료 여부 판별

### ☑️ Validation(플레이어 입력 오류 처리)

---
#### checkBallNumbersValidity: 플레이어 볼 입력 유효성 체크
#### checkPlayerDecisionValidity: 게임 종료 여부 입력 유효성 체크

###### checkIsNumberCountOne: 1자리수 체크
###### checkIsNumberCountThree: 3자리수 체크
###### checkIsUniqueThreeNumber: 숫자 중복입력 체크
###### checkIsNumber: 숫자 입력 체크(문자가 아님)
###### checkHasCorrectNumRange: 숫자 범위 체크
###### checkIsCorrectNumber: 입력된 숫자가 1 또는 2가 맞는지 체크

### ☑️ Constant(상수 정의 클래스)

---
#### RESTART, END
#### MIN_BALL_NUMBER, MAX_BALL_NUMBER


