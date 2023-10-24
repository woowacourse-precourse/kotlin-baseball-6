# 기능 구현 정리

### 실행 결과 예시
___
```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
```

1. 게임 시작을 위한 세팅
    * 1~9 사이의 서로 다른 임의의 수 3개 선택 -> `Answer: IntArray`
    * 게임 시작 문구 출력 - `"숫자 야구 게임을 시작합니다."`<br><br>

2. 사용자 입력 (4번에서 메서드 재활용 가능하게 할 것!)
    * `"숫자를 입력해주세요 : "` -> 사용자 입력 받고, String 타입 변수에 저장
    * 잘못된 값일 경우, IllegalArgumentException 발생 시키고 종료

      ```kotlin
      inputValidator(digit: Int, range: CharRange): IntArray
      1. if) 입력된 문자의 길이가 digit 자리가 아닌 경우
      2. else if) `range` 범위의 숫자가 아닌 경우 (all로 검증)
      3. else if) 중복된 숫자가 들어온 경우 (set 으로 변환한 뒤 요소의 수 검증)
      ```
      <br>

3. Ball, Strike 검증 및 결과 출력
    * Ball, Strike 검증
      ```kotlin
      1. inputValidator에서 반환된 IntArray를 Answer과 인덱스 비교 => Strike
      2. inputValidator에서 반환된 IntArray를 Answer과 !인덱스 비교 => Ball
      ```
    * 입력한 수에 대한 검증 결과 출력<br><br>

4. 3S -> 게임 종료 및 재시작 or 종료 입력받기
    * `"3개의 숫자를 모두 맞히셨습니다! 게임 종료"` 출력
    * `"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."` 재시작 또는 종료 입력 받기
    * 잘못된 값일 경우, `IllegalArgumentException` 발생 시키고 종료

      ```kotlin
      inputValidator(digit: Int, range: CharRange): IntArray
      1. if) 입력된 문자의 길이가 digit 자리가 아닌 경우
      2. else if) `range` 범위의 숫자가 아닌 경우 (all로 검증)
      3. else if) 중복된 숫자가 들어온 경우 (set 으로 변환한 뒤 요소의 수 검증)<br><br>
      ``` 
    * 메뉴 입력 받기
        * 입력 받은 데이터가 1인 경우 -> 정답 재생성 <br>
        * 입력 받은 데이터가 2인 경우 -> 게임 종료 <br><br><br>

> 원래 습관대로 구현한 뒤, 목표에 맞게 수정하면서 바뀌는 부분을 보며 피드백하기<br>

|No|개선 목표|Done|느낀점|
|:--:|:--:|:--:|:--:|
|1차|N자리 숫자야구로 변환이 가능하게 구현 + Role|O||
|2차|레거시 코드 최소화 및 성능 최적화 + Role|O||
|3차|Kotlin Code convention에 맞게 수정 + Role|O||
|4차|MVC 패턴 학습 후 적용할 것 + Role|O||
|5차|클린 코드 13가지 규칙에 맞게 수정 + Role|진행중||
* Role : 테스트 코드 추가 작성 및 오류 체크, 디버깅
  <br><br><br>

### 4. MVC 패턴 학습후 적용을 위한 분석
___
>완벽히 이해는 못했지만, 이해한 내용을 바탕으로 구현한 뒤, 생각한 부분과 다른 점을 분석하며 학습할 것
1. 게임 시작을 위한 세팅
    1. 1~9 사이의 서로 다른 임의의 수 3개 선택 : Controller → **Model**
    2. 게임 시작 문구 출력 : View
2. 사용자 입력
    1. “숫자를 입력해주세요” : View
    2. 잘못된 값 검증 : Controller(~~View~~) → **Model**
3. Ball, Strike 검증
    1. ball-strike 계산 및 결과 출력 : Controller → **Model** → Controller → **View**
4. 3스트라이크 재시작 입력 받기
    1. 3스트라이크 판단? : Controller → **Model**
    2. 3스트라이크 결과 출력 : Controller → **Model** -> Controller → **View**
    3. “게임을 새로 ~ 1, 종료 ~ 2” 출력 : Controller → **View**
    4. 메뉴 입력 받기 : View
    5. 잘못된 값 검증 : Controller(~~View~~) → **Model**
       <br><br><br>

### 5. 클린 코드 13가지 규칙에 맞게 수정 (진행상황) - [체크리스크 읽기]([https://automation-slave.tistory.com/27])
___
```
- [X] 1. 한 함수(메서드)에 최소한의 들여쓰기(indent)만 허용했는가?최대 depth : 2 까지만 허용
- [X] 2. else 예약어를 쓰지 않았는가?
- [ ] 3. 모든 원시값과 문자열을 포장했는가? [Link: 원시 타입을 포장해야 하는 이유]([https://tecoble.techcourse.co.kr/post/2020-05-29-wrap-primitive-type/])
- [ ] 4. 콜렉션에 대해 일급 콜렉션을 적용했는가?
- [ ] 5. 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
- [ ] 6. getter/setter 없이 구현했는가?
- [ ] 7. 핵심 로직을 구현하는 도메인 객체에 getter/setter를 쓰지 않고 구현했는가? 단, DTO는 허용한다.
- [X] 8. 코드 한 줄에 점(.)을 하나만 허용했는가?
- [X] 9. 메소드의 인자 수를 제한했는가? 4개 이상의 인자는 허용하지 않는다. 3개도 가능하면 줄이기 위해 노력해 본다.
- [X] 10. 디미터(Demeter)의 법칙(“친구하고만 대화하라”)을 지켰는가?예를 들어 location.current.representation.substring(0, 1)와 같이 여러 개의 점(.)이 등장하면 리팩토링할 부분을 찾아본다.
- [X] 11. 메소드가 한가지 일만 담당하도록 구현했는가?
- [X] 12. 클래스를 작게 유지하기 위해 노력했는가?메서드당 line을 10까지만 허용길이가 길어지면 메서드로 분리
- [ ] 13. 매직 리터럴 / 매직 넘버 사용을 자제하고 상수 사용
```
<br>

# 1주차 학습 내용(2주차에 올릴 것!!!!!!!)