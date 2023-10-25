# 🚀 기능 목록 

---
## 숫자 야구 진행 방식
- **정답(컴퓨터의 랜덤 값)을 생성** 합니다.
- 사용자로부터 **입력**을 받습니다.
- **정답과 사용자의 입력값을 비교**합니다.
- 결과를 반환 합니다. **(볼, 스트레이크, 낫싱)**
- 결과에 맞는 아래 조건을 진행 합니다.
  - 정답을 못 맞춘 경우
    - **게임을 계속 진행** 합니다.
  - 정답을 맞춘 경우 
    - 게임을 **재시작** 합니다.
    - 게임을 **종료** 합니다.

# 🧑‍💻 기능 구체화

---
## Console

---
### [GameConsole.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fbaseball%2Fconsole%2FGameConsole.kt)
- 숫자 야구를 진행하기 위한 오브젝트 입니다.
#### Method
- `initUserAnswer()` : 사용자로부터 입력을 받습니다.
- `initComputerNumber()` : 컴퓨터의 값을 초기화 합니다.
- `chooseComputerNumber()` : 컴퓨터의 랜덤 값을 생성합니다.
- `addComputerNumber()` : 새로 뽑은 숫자의 중복 여부를 확인합니다.

## Manager

---
### [MessageManager.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fbaseball%2Fmanager%2FMessageManager.kt)
- 메시지 출력을 위한 클래스입니다.
#### Method
- `printStartGame()` : 게임 시작 문구를 출력합니다.
- `printEnterNumber()` : 숫자 입력 문구를 출력합니다.
- `printEndGame()` : 게임 종료 문구를 출력합니다.
- `printScore()` : 입력한 수에 대한 결과를 볼, 스트라이크 개수를 출력합니다.
### [ScoreManager.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fbaseball%2Fmanager%2FScoreManager.kt)
- 점수를 구하기 위한 클래스입니다. 
#### Method
- `scoreFromAnswer()` : 스코어를 계산하는 함수로 Pair<Int, Int>를 반환합니다.
- `strikeCounter()` : 스트라이크인지 체크합니다.
- `ballCounter()` : 볼인지 체크합니다.
## Validation

---
### [CheckNumberValidation.kt](..%2Fsrc%2Fmain%2Fkotlin%2Fbaseball%2Fvalidation%2FCheckNumberValidation.kt)
- 올바른 값이 입력되었는지 검증하기 위한 클래스 입니다.
#### Method
- `checkUserAnswer()` : 유저의 숫자 입력 값의 유효성을 확인합니다.
- `checkNextStep()` : 유저의 게임 재시작 여부 입력 값의 유효성을 확인합니다.
- `checkValidationAnswer()` : 유저 입력 값을 인덱스별로 확인합니다.
- `checkIsNumber()` : 인덱스에 해당하는 값이 숫자인지 확인합니다.
- `checkDuplicate()` : 인덱스에 해당하는 값이 중복 값인지 확인합니다.
- `checkLength()` : 입력 값의 길이를 확인합니다.