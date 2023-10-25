<img src="https://github.com/Sheep1sik/Dicee/assets/88019314/bf567b0d-417a-46b6-b290-6a415a80f602" width="800" height="150"/>

# 미션 - 숫자 야구 게임
![GIFMaker_me](https://github.com/Sheep1sik/Dicee/assets/88019314/15c8d2d3-db36-4e45-ab74-adf1e45a3d69)

# ✅ 구현할 기능 목록
## 게임 진행
- 숫자 야구 게임의 전반적인 진행을 담당
## 랜덤값 생성 기능
- computer의 무작위 수 생성 후 String으로 변환 후 리턴
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용
  
## 유저 값 입력받는 기능
- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 입력
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
## 컴퓨터와 유저의 값 비교 및 판정 기능
- computer와 user의 값 비교 및 판정
  - computer와 user의 수가 같으면 스트라이크
  - computer와 user의 수가 같지만 다른 자리에 있으면 볼
  - computer와 user의 수가 어느 자리에도 같지 않을때 낫싱

## 재시작 여부 체크 기능
- 재시작 여부 체크
  - user가 1을 입력하면 재시작, 2를 입력하면 종료
## 유효성 체크 기능
- 유효성 검증
  - 사용자가 입력한 수가 3자리인가?
  - user가 입력한 3자리의 수가 1 - 9 까지의 수로 이루어져 있는가?
  - 중복된 수가 없는가? 
- `IllegalArgumentException`를 발생시킨 후 애플리케이션이 종료

# 플로우 차트
<img src="https://github.com/Sheep1sik/Dicee/assets/88019314/824eb5b0-dfa1-43fb-920a-8bd070c346d4" width="400" height="600"/>


## 🚀 기능 요구 사항
|-|요구 사항|
|------|---|
|1| 컴퓨터가 1 - 9 까지 서로 다른 수를 생성하는가?|
|2| 사용자의 입력 값을 정상적으로 받아오는가?|
|3| 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료시키는가?|
|4| 컴퓨터의 랜덤값과 사용자의 입력값을 비교하여 정확하게 스트라이크와 볼을 계산하는가?|
|5| 사용자가 정답을 맞출경우 재시작 여부를 물어보는가?|
|6| 재시작을 했을때 컴퓨터의 랜덤값이 달라지는가?|
|7| 힌트(낫싱)이 정상적으로 출력 되는가?|

## 🎯 프로그래밍 요구 사항

- Kotlin 1.9.0에서 실행 가능해야 한다. **Kotlin 1.9.0에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

