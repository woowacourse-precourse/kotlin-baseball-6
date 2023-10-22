## 🚀 기능 목록 

### 숫자 야구와 관련된 기능들
- run() 
  - 숫자 야구 게임을 진행하는 기능
  - 게임이 종료될 때까지 입력을 받고 결과를 출력한다.
- isBall() : 볼인지 판별하는 기능
- isStrike() : 스트라이크인지 판별하는 기능
- countBall() : 볼의 개수를 구하는 기능
- countStrike() : 스트라이크 개수를 구하는 기능
- isEndGame() : 게임이 종료되었는지 판별하는 기능
<br><br/>
### 입력과 관련된 기능들
- inputBaseBallNumber() : 서로 다른 3개의 숫자 입력받는 기능
- inputExitGame() : 게임을 새로 시작할 건지의 여부를 입력받는 기능
<br><br/>
### 출력과 관련된 기능들
- printBallAndStrike() : 볼과 스트라이크 개수를 형식에 맞게 출력하는 기능
<br><br/>
### 공통적으로 사용되는 기능들
- pickBaseBallNumber() : 서로 다른 3개의 숫자 선택하는 기능
- validateInputBaseBall() : 입력받은 3개의 숫자의 예외 처리 기능
  - validateInputBaseBallSize() : 3개보다 적거나 많은 숫자를 입력한 경우
  - validateInputBaseBallDuplication() : 중복된 숫자를 입력한 경우
  - validateInputBaseBallRange() : 1~9 외의 숫자나 문자를 입력한 경우
  - validateInputExit() : 1, 2 외 다른 숫자 문자를 입력한 경우
- validateInputExit() : 입력받은 게임 재시작 여부의 예외 처리 기능