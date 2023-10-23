
## 💡 구현할 기능 목록

1. 게임 시작을 알리는 문구 출력
2. 서로 다른 3자리의 수를 랜덤으로 선택해 컴퓨터 List에 할당
3. 사용자에게 서로 다른 3자리의 수 입력받기
4. 사용자가 입력한 List와 컴퓨터가 할당받은 List를 비교 후 결과 리턴
    - 일치여부, 포함여부에 따라 스트라이크, 볼, 낫싱 판단
      - 스트라이크 : 같은 수가 같은자리
      - 볼 : 같은 수가 다른자리
      - 낫싱 : 같은 수가 전혀 없음
5. 결과 출력
   - 위에서 받은 리턴값으로 결과 출력
     - 3스트라이크 : 모두 맞히셨습니다 출력과 함께 게임 종료
     - 갯수로 출력 : (예 : 1볼 1스트라이크, 낫싱)
6. 게임 종료 여부확인
   - 게임이 종료된 이후 사용자에게 재시작 여부를 묻고
     - 재시작 : 1입력 (return true)
     - 종료 : 2입력 (return false)
7. 예외처리
   - 유효하지 않은 값 입력등 예외처리

## ⚙️ Architecture

### MVVM
#### 유지보수성과 확장성을 위해 View와 비즈니스 로직을 분리하는 MVVM 구조 채택

- **dataLayer/repository**
  - BaseBallGameRepositoryImpl : 숫자 야구 게임 데이터를 관리하는 리포지토리 구현 클래스
- **uiLayer**
  - model
    - GameModel : strike, ball, nothing에 대한 정보를 쉽게 관리하고 넘겨주기 위한 data class
  - BaseBallGame : 사용자와 상호작용하며 숫자야구 게임의 플로우를 제어하는 클래스
  - BaseBallGameRepository : 숫자 야구 게임 데이터를 관리하는 리포지토리 인터페이스 (Facade 패턴을 사용해 ViewModel에게 단순한 인터페이스를 제공)
  - BaseBallGameViewModel : 숫자 야구 게임과 관련된 비즈니스 로직을 처리하는 ViewModel 클래스/ 게임 로직과 UI를 분리하여 유지보수성, 확장성, 테스트 용이성 등을 높임
- **util**
  - GameUtils : 게임에서 사용되는 유틸리티 함수들을 제공하는 객체



## 📌 Convention
### Commit Message Convention
| Tag             | Description                   |
|-----------------|-------------------------------|
| [Feat] :        | 새로운 기능을 추가                    |
| [Fix] :         | 버그 수정                         |
| [Comment] :     | 문서 수정, 필요한 주석 추가 및 변경         |
| [Test] :        | 테스트 코드, 리팩토링 테스트 코드 추가        |
| [Refactoring] : | 코드 구조 변경 등 리팩토링               |
| [Rename] :      | 파일 또는 폴더 명을 수정하거나 옮기는 작업만인 경우 |
| [Remove] :      | 파일을 삭제하는 작업만 수행한 경우           |

### Coding Convention 


**❝**  **문자열을 처리할 때는 쌍따옴표를 사용하도록 합니다.**

🐫 **함수명, 변수명은 카멜케이스로 작성합니다. (camelCase)**

☝ **가독성을 위해 한 줄에 하나의 문장만 작성합니다.**

🤙 **코드 구현 완료 후 정렬을 해줍니다. (`ctrl` + `Alt` + `L`), (`command` + `option` + `L`)**

🐈 **기능 코드 구현 후 주석을 달아줍니다.**

```kotlin
/*
 * MyPageViewModel()
 * MyPage 데이터 관리를 위한 ViewModel
 * 비즈니스 로직 캡슐화
 * UI에 사용될 상태를 처리, UI Layer에 상채를 알림
 */

주석은 설명하려는 구문에 맞춰 들여쓰기 합니다.
```

☝ **연산자 사이에는 공백을 추가하여 가독성을 높입니다.**

```kotlin
a+b+c+d // bad
a + b + c + d // good
```

☝ **콤마 다음에 값이 올 경우 공백을 추가하여 가독성을 높입니다.**

```jsx
var arr = [1,2,3,4] //bad
var arr = [1, 2, 3, 4] //good
```

🔠 **생성자 함수명의 맨 앞글자는 대문자로 합니다.**

```jsx
function Person(){}
```



