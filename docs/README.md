# 미션 - 숫자 야구

## 🚨 기능 목록

- 게임 시작 기능
  - 시작 문구 출력
- 컴퓨터 1부터 9까지의 서로 다른 수로 이루어진 3자리 수 생성 기능 (랜덤)
- 플레이어로부터 숫자 입력 받는 기능
  - 입력 기능
    - 서로 다른 3자리 수 입력한 경우
    - 게임이 끝난 경우 재시작/종료 구분하는 1과 2 중 하나의 수 입력한 경우
    - 잘못된 값 입력한 경우
- 성공 실패 판단 기능
  - 컴퓨터의 값과 플레이어의 값 비교
  - 비교 결과 다르면 실패 -> 힌트 제공
  - 비교 결과 같으면 성공 -> 게임 종료
- 힌트 기능
  - 같은 수 같은 자리 -> 스트라이크
  - 같은 수 다른 자리 -> 볼
  - 같은 수 전혀 없음 -> 낫싱
- 게임 종료 여부 판단 기능
- 게임 재시작 기능
- 게임 종료 기능


---


## ✏️ 프로그래밍 요구 사항

- Kotlin 1.9.0에서 실행 가능해야 한다. **Kotlin 1.9.0에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- 라이브러리 사용
  - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


---


## ✏️ 과제 진행 요구 사항

- 미션은 [kotlin-baseball](https://github.com/woowacourse-precourse/kotlin-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.
