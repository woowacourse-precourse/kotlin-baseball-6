# 미션 - 숫자 야구

## 📚 프로젝트 목표
- 주어진 요구 사항을 만족시키는 코드를 작성한다.
- 확장 및 유지 보수의 편의성을 고려하여 리팩토링이 가능한 코드를 작성한다.
- 가독성을 고려한 코드를 작성한다.
- 협업을 가정하여 커밋 및 코드 컨벤션을 지킨다.

## ✨ 기능 목록
- 컴퓨터의 3자리 수
- 사용자의 입력
- 옳지 않은 입력에 대한 예외 처리
- 채점
- 힌트
- 정답시 게임 종료
- 메세지 출력

## 🎨 설계
<img width="1631" alt="숫자 야구 게임 설계" src="https://github.com/kio1214/RisingCamp_1st_Week_Project_YouTubeMusic/assets/85236336/e9462887-7eb7-4730-9564-1020ce284f00">

### 역할에 따라 클래스 분리
- GameManager: 게임의 전체 화면 관리
- InputManager: 사용자 Input 관리
- Computer Class: 컴퓨터 객체
- User Class: 사용자 객체
- Referee Class: 판정 관리

### 입력 관리
- 컴퓨터 숫자
  - mutableList<Int> 타입
  - Randoms.pickNumberInRange() 사용
  - getNumberList()로 반환
- 사용자 숫자
  - mutableList<Int> 타입
  - Console.readLine() 사용
  - validateUserNums() - 유효성 검사
  - getNumberList()로 반환
- 재실행 숫자
  - Int
  - validateFinishNums() - 유효성 검사
  - getFinishNumber()로 반환

### 예외 처리
- IllegalArgumentException 발생
- 사용자 숫자 입력
  - 공백 검사
  - 중복 검사
  - 0 미포함
  - 3자리
  - Int 변환 가능
- 재실행 숫자 입력
  - 공백 검사
  - 1 혹은 2 외의 값인지
