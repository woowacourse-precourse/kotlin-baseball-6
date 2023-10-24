# 미션 - 숫자 야구

## 컴퓨터

- 1 ~ 9의 서로다른 임의의 3개의 수를 생성하여 갖고 있다
- 사용자로부터 입력받은 수가 정답인지 판단하여 출력한다
- 게임이 끝나면, 사용자로부터 받은 수를 통해 게임 재시작 여부를 결정한다

## 플레이어

- 입력창을 통해 맞출 수를 입력한다
-
    - 수는 1 ~ 9의 서로다른 3개의 수여야 한다
- 게임이 끝나면, 재시작 여부를 입력한다
-
    - 1은 재시작, 2는 종료이다

## 게임 결과 판단

- 같은 위치에 같은 숫자가 N개 있다 : N 스트라이크
- 다른 위치에 같은 숫자가 N개 있다 : N 볼
- 같은 숫자가 하나도 없다 : 낫싱

## Todo

- [x] 컴퓨터의 랜덤한 3자리 수 생성
- [x] 플레이어의 3자리 수 입력이 올바른지 처리
- [x] 컴퓨터와 플레이어 수를 비교하여 결과 판단
- [ ] 플레이어의 재시작 여부 입력이 올바른지 처리
- [ ] 게임 재시작 또는 종료

### 커밋 메세지

- feat : 기능 추가
- fix : 버그 수정
- docs : 문서 수정
- test : 테스트 코드 추가
- refactor : 코드 리팩토링
- style : 코드 의미에 영향을 주지 않는 변경사항
- chore : 빌드 부분 혹은 패키지 매니저 수정사항
- cicd : CI/CD 관련 설정