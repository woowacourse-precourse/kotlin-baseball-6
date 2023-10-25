## 📝 기능 목록
### Application
- [x] 게임 로직 시작

### InputManager
- [x] `Console.ReadLine()`을 이용해 값을 입력 받는 함수 구현
- [x] 입력받은 값의 자리수에 따라 유효한 값인지 판별 (유효한 값이 아니라면 `IllegalArgumentException` 발생)

### GameManager
- [x] `User`, `Refree`, `Computer`를 생성해 게임을 시작
- [x] 게임 종료 여부를 `RestartListener`로부터 수신받아 게임이 끝난 경우에 값을 입력받고 종료할지 재시작할지 결정

### RestartListener
- [x] 게임이 종료되면 `GameManager`에게 event 발생

### User
- [x] 숫자 입력

### Computer
- [x] `Randoms.pickNumberInRange()`를 이용해 랜덤한 3자리 숫자 생성
- [x] 생성된 값이 유효한 값인지 판별 (유효한 값이 아니라면 재생성)

### Refree
- [x] `User`와 `Computer`에게 전달받은 값을 비교해 볼, 스트라이크, 낫싱 여부 판단 후 출력
- [x] 게임이 끝난경우 `RestartListener`에게 event 전달