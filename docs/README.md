### ⚾️  게임 프로세스
1. 게임 시작 문구 출력
   - 숫자 야구 게임을 시작합니다.
2. 숫자 입력 받기
   - 서로 다른 3자리의 숫자
   - 잘못된 값 입력 시 IllegalArgumentException 후 애플리케이션 종료
3. 결과 띄우기
   - 볼, 스트라이크, 낫싱
4. 3스트라이크까지 2,3 반복
5. 게임 종류 문구 출력
   - 3스트라이크     
     3개의 숫자를 모두 맞히셨습니다! 게임 종료
6. 게임 시작, 종료 선택 문구 출력
   - 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
7. 시작,종료 문구 입력 받기
   - 1,2 
   - 잘못된 값 입력 시 IllegalArgumentException 후 애플리케이션 종료
8. 시작이면 반복,종료면 종료

- 주의할점
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  - 종료 시 System.exit()을 호출하지 않는다. 

### 🚀 구현할 기능 목록
- 랜덤 값 생성 
- 숫자 입력 
- 스트라이크 판단 
- 볼 판단 
- 반복
- 다시 시작 or 종료 입력 
- 다시 시작 기능
- 종료 기능