# 기능 구현 정리

[1]. 게임 시작을 위한 세팅
1. 1~9 사이의 서로 다른 임의의 수 3개 선택 -> `Answer: IntArray`
2. 게임 시작 문구 출력
<br>

[2]. baseball / 입력, 검증
1. 입력 문구 출력, 사용자 입력
2. 잘못된 값일 경우, `IllegalArgumentException` 발생 시키고 종료
   ```
   BaseballInput.setDataWithValidation()
   A. 입력된 문자의 길이가 digit 자리가 아닌 경우
   B. range 범위의 숫자가 아닌 경우 (all로 검증)
   C. 중복된 숫자가 들어온 경우 (set으로 요소의 수 검증)
   ```
<br>

[3]. baseball / 계산, 결과 출력
1. Ball, Strike 계산
   ```
   A. Strike -> IntArray와 Answer 인덱스 비교
   B. Ball   -> IntArray와 Answer !인덱스 비교
   ```
2. Ball, Strike 계산 결과 출력
<br>

[4]. menu / 입력, 검증 및 처리
1. 입력 문구 출력, 사용자 입력
2. 잘못된 값일 경우, `IllegalArgumentException` 발생 시키고 종료
   ```
   MenuInput.setDataWithValidation()
   A. 입력된 문자의 길이가 digit 자리가 아닌 경우
   B. `range` 범위의 숫자가 아닌 경우 (all로 검증)
   ``` 
3. menu 처리
   ```
   A. menu가 1인 경우 -> 정답 재생성
   B. menu가 2인 경우 -> 게임 종료
   ``` 
<br><br>

> 원래 습관대로 구현한 뒤, 목표에 맞게 수정하면서 바뀌는 부분을 보며 피드백하기<br>

|No|개선 목표|Done
|:--:|:--:|:--:|
|1차|N자리 숫자야구로 변환이 가능하게 구현 + Role|O|
|2차|레거시 코드 최소화 및 성능 최적화 + Role|O|
|3차|Kotlin Code convention에 맞게 수정 + Role|O|
|4차|MVC 패턴 학습 후 적용할 것 + Role|O|
|5차|클린 코드 11가지 규칙에 맞게 수정 + Role|10, 11 X|
* Role : 테스트 코드 추가 작성 및 오류 체크, 디버깅
<br><br><br>

### 4. MVC 패턴 학습후 적용을 위한 분석 [Notion](https://humorous-ptarmigan-c7f.notion.site/MVC-ef8901ce47104f18a883abb3422ff8b3?pvs=4)
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

### 5. 클린 코드 11가지 규칙에 맞게 수정 (진행상황)
___
- [X] 1. 메서드에 최소한의 들여쓰기(indent)만 허용했는가? 최대 depth는 2까지만 허용
- [X] 2. 메소드가 한가지 일만 담당하도록 구현했는가?
- [X] 3. 메소드의 인자 수를 3개 이하로 제한했는가?

- [X] 4. 클래스를 작게 유지하기 위해 노력했는가? 메서드당 line을 10까지만 허용길이가 길어지면 메서드로 분리
- [X] 5. 클래스가 3개 이상의 인스턴스 변수를 가지고 있지는 않은가?
- [X] 6. 핵심 로직을 구현하는 도메인 객체에 제거할 수 있는 프로퍼티가 있지는 않은가?

- [X] 7. 코드 한 줄에 점(.)을 하나만 허용했는가?
- [X] 8. else 예약어를 쓰지 않았는가?
- [X] 9. 매직 리터럴 / 매직 넘버를 쓰지 않았는가?

- [ ] 10. 모든 원시값을 포장했는가? -> 좀 더 공부하자.
- [ ] 11. 콜렉션에 대해 일급 콜렉션을 적용했는가? -> 적용할 만한 규모의 미션이 아님. 2주차에 도전!
  
<br>

# 1주차 학습 내용(2주차에 올릴 것!!!!!!!)