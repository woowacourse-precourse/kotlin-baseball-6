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

|No|개선 목표|Done|
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
> 이해한 내용을 바탕으로 구현한 뒤, 생각한 부분과 다른 점을 분석하며 학습할 것
1. 게임 시작을 위한 세팅
   1. 1~9 사이의 서로 다른 임의의 수 3개 선택 : Controller → **Model**
   2. 게임 시작 문구 출력 : Controller -> **View**
      <br><br>
2. baseball / 입력, 검증
   1. 입력 문구 출력, 사용자 입력 : Controller -> **View** , **Controller**
   2. 잘못된 값 검증 : Controller -> **Model**
      <br><br>
3. baseball / 계산, 결과 출력, 3S 판단
   1. Ball, Strike 계산 : Controller -> `**Model**`
   2. Ball, Strike 계산 결과 출력 : `**Model**` -> Controller → **View**
   3. 3S 판단 : **Controller**
      <br><br>
4. menu / 입력, 검증 및 처리
   1. 입력 문구 출력, 사용자 입력 : Controller -> **View** , **Controller**
   2. 잘못된 값 검증 : Controller -> **Model**
   3. menu 처리 : **Controller**
      <br><br><br>

### 5. 나만의 클린 코드 11가지 규칙에 맞게 수정 (진행상황)
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

- [ ] 10. 모든 원시값을 포장했는가? -> 좀 더 공부해서 이해해보자!
- [ ] 11. 콜렉션에 대해 일급 콜렉션을 적용했는가? -> 2주차에 도전!
          <br><br><br>

### 1주차 학습 내용
___
> 혼자하고 있지만 협업으로 생각해서 어떻게 대응하는지 학습하고 적용할 것 -> Github 학습을 위함<br><br>1) [Git Branch 종류 5가지](https://gmlwjd9405.github.io/2018/05/11/types-of-git-branch.html)를 처음에 적용해서 개발해보기 -> Branch 학습을 위함<br>
-> 1주차 미션을 빨리 끝내고 적용해본 뒤, 2주차 미션 시작부터 적용해서 끝내보기!


```
1. 현재 개발중인 * Feature(rlaxodud214)에서 Develop로 Merge한 커밋에서 버그 발견 
   어떻게 대응할 것인가?, 어떻게 대응하는 게 좋은가(정석인가)?
   1) Merge 이후 작업이 많이 됐다면, 별도의 Feature를 만들어서 Fix후 Merge가 좋을 것 같다.
      -> [GPT 답변] Merge이후 작업량과 관계없이 대부분의 상황에서 권장된다.<br>
         이때 사용하는 브랜치의 이름 : bugfix/bug-description
         
   2) 그게 아니라면 Merge를 취소하고?,, 이전 Feature에서 Fix후 다시 Merge?!!
      -> [GPT 답변] Merge 직후 버그 발견시(추가된 작업이 없는 경우)에만 권장되는 방법이다.
         그리고 혼란을 막기 위해 반드시 팀원과의 협의를 거쳐야 한다! 
         이 방법의 단점 : History를 재작성한다는 것(?)

       * History가 뭐고, 재작성은 어떤 과정일까?
         - Git에서의 History는 프로젝트의 변경 내영 전체를 의미
         - 재작성은 이미 만들어진 커밋들을 수정, 삭제, 재정렬하는 등의 작업을 의미
           ex) [최근 커밋 수정] git commit --amend,
               [최근 커밋 삭제] git reset HEAD~1,
               [여러 커밋을 수정하거나 재정렬] git rebase,
         
   실제 적용 과정
   1. empty 입력 시, failed 발생하는 테스트 케이스 발견
   2. bugfix 브랜치 생성(A) 및 Test 커밋(B)
      (A) `git checkout -b bugfix/empty-input-handling`
      (B) `git commit -am "Test: Add failed - empty input case"`
   3. Merge 학습을 위해 기존 브랜치로 이동 후, 추가 작업(C)
      (C) `git commit -am "Feat: 사용자에게 입력 받은 수 중복 검증 후 오류 발생시키기"`
   4. bugfix 브랜치에서 오류 Fix한 뒤, 커밋(D)하고 병합(E)하면서 충돌 해결
      (D) `git commit -am "Fix: 사용자가 empty 입력 시 오류처리 되도록 수정함"`
      (E) branch rlaxodud214 이동 후, `git merge bugfix/empty-input-handling`
   
   * Test Code에서 Failed떠서 위 과정을 따라 했지만, 실제 오류는 runException()에 빈 문자열을 넣어서 난 오류였다. 기존 브랜치에서 runException(null)로 했을 때, 오류 없었음
   
   * 배운점 : 앞으로는 오류가 나면 디버깅 찍어서 확인 하고, Fix 작업(브랜치 생성 등)을 하자.
```
2. markdown 기본 문법 
<br>

### 1주차 회고
___

요구 사항과 커뮤니티를 보며 아래와 같은 내용들을 새롭게 인지할 수 있었고 최대한 많은 것들을 학습하기 위해 노력했습니다.
```
1. Kotlin 코드 컨벤션 가이드 : 조금이라도 더 가독성 좋고, 통일성 있는 코드를 만들기 위해 일정 부분 따라야 할 규칙이라고 생각합니다. return if(조건) a else b 같은 새로운 코드 스타일이 인상 깊었습니다.

2. MVC 패턴 : MVC 패턴을 탐구하면서 각 함수가 어느 섹션에 속하는지 분석하고 고민하는 시간을 가졌습니다. 또한, MVC 패턴을 통해 단위 테스트의 중요성을 깨달았습니다. 처음 적용하는 MVC 패턴이라 여러 번 수정했지만, 아직 완벽하게 구현했다고 확신할 수 없어 계속 관찰 중입니다.

3. 클린 코드 규칙: 1주차 적용하지 못한 "원시값 포장"과 "일급 콜렉션 적용" 까지 2주차에 적용할 수 있기를 기대하며 학습하고 있습니다.

4. 테스트 코드 작성법 : 지금까지 개발하면서 모든 테스트는 직접 수동으로 실행하느라 디버깅에 시간을 많이 썼는데, 예전부터 알았다면 정말 유용하게 사용했을 것 같습니다. 효율적인 테스트를 할 수 있는 좋은 도구를 배울 수 있어서 좋았습니다. 테스트 코드에 대해서는 좀 더 학습하며, 적용해 나갈 예정입니다.

5. Git Branch 종류와 사용법 : 혼자서의 개발도 중요하지만, 팀원과의 협업을 통해 더 좋은 제품을 만들 수 있다고 생각합니다. 이를 위해 Git Branch를 활용하는 연습을 했습니다. 아쉬운 점이 있다면, Git Branch에 대한 지식이 없어서 처음부터 브랜치 작업을 하지 못한 것입니다.
```
더 공부 하고싶은 부분 : SoC, SOLID 원칙, 다른 아키텍처 패턴들, 커밋 컨벤션, 테스트 코드 JUnit5 활용법, 객체 지향적 설계(Readme.md), 클린코드 - "10. 모든 원시값을 포장했는가?".

다음 미션에서는 처음부터 MVC로 설계하고, Git Branch를 활용하는 등 1주차에 배운 내용을 고려하며 구현할 계획입니다!