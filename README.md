# 미션 - 숫자 야구

## 🔍 문제 흐름

1. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
2. 사용자는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력한다.
3. 사용자 입력에 대한 결과를 출력한다.
    * 사용자가 입력한 수와 컴퓨터가 선택한 수의 자리와 수가 같으면 스트라이크가 된다.
    * 사용자가 입력한 수와 컴퓨터가 선택한 수의 자리는 다르고 수가 같으면 볼이 된다.
    * 스트라이크와 볼이 모두 0개인 경우 낫싱이 된다.
4. 스트라이크가 3개가 되면 게임 종료가 된다.
5. 사용자에게 게임을 다시 시작할지 완전히 종료할지 입력 받는다.
    * 사용자가 1을 입력하면 1번으로 돌아가 새로운 게임을 시작한다.
    * 사용자가 2를 입력하면 프로그램을 종료한다.

* * *

## 🚨예외 처리

### 세자리 수 입력

* 입력받은 수가 세자리가 아닌 경우 `IllegalArgumentException`을 발생시킨다.
* 숫자가 아닌 문자가 입력에 포함된 경우 `IllegalArgumentException`을 발생시킨다.
* 중복된 숫자가 있는 경우 `IllegalArgumentException`을 발생시킨다.
### 재시작 결정 수 입력

* 1,2가 아닌 입력에 대해 `IllegalArgumentException`을 발생시킨다.

* * *

## 🚀사용 클래스

* baseballgame/Game: baseball게임을 진행하는 클래스
* constant/StringError: Exception에서 사용될 에러 메시지를 관리하는 클래스
* constant/Constant: Game에서 사용되는 상수를 관리하는 클래스

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

* * *

## 🎯 프로그래밍 요구 사항

- Kotlin 1.9.0에서 실행 가능해야 한다. **Kotlin 1.9.0에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.


