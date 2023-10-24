# 기능명세

## 클래스

전체 구조는 크게 computer, user, system로 구성이 되어있다.

- computer는 랜덤값 생성과 정답 확인 등의 기능을 담당
- user는 값 입력과 입력값 보관 등의 기능을 담당
- system은 게임 진행과 재시작 기능을 담당
- util은 그 외의 기능들을 담당

<br>

## computer

### 필드
#### answer : MutableList<Int>
3자리 수를 저장하는 리스트

<br>

### 메소드
#### makeNewAnswer()
##### 개요
`answer`을 초기화 하고 `Randoms.pickNumberInRange()` 메소드로 무작위 값 3개를 채운다.

##### 반환
없음.

<br>

#### checkStrikeCount(userInput: MutableList<Int>) : Int
`answer`과 `userInput`을 비교하여 몇 개의 스트라이크가 있는지 계산한다.

##### 반환
Int로 스트라이크 수를 반환한다. 

<br>

#### checkballCount(userInput: MutableList<Int>) : Int
##### 개요
`answer`과 `userInput`을 비교하여 몇 개의 볼이 있는지 계산한다.

##### 반환
Int로 볼 수를 반환한다.
 
 <br>
 
#### printCheck(strikeCount: Int, ballCount: Int)
##### 개요
인자로 들어온 `strikeCount`와 `ballCount`수를 확인하고 결과를 출력해준다.
`strikeCount`와 `ballCount`이 모두 0이 아니라면, `n볼 n스트라이크`의 형식으로 출력한다.
만약 둘 중 하나가 0이라면 `n볼` 혹은 `n스트라이크`의 형식으로 출력한다.
둘 다 0이라면 `낫싱`을 출력한다.

##### 반환
없음.

<br>

#### checkAnswer(userInput: MutableList<Int>) : Boolean
##### 개요
`checkStrikeCount`와 `checkballCount` 메소드를 이용해 스트라이크와 볼의 개수를 세고,
해당 스트라이크와 볼의 개수를 `printCheck` 메소드로 출력해준다.
이후 결과를 Boolean으로 반환한다.

##### 반환
만약 3스트라이크라면 true를 반환, 그 외에는 false를 반환한다.

<br>

## User

### 필드 
#### userNumber : MutableList<Int>
유저가 입력하는 값을 담아두는 필드

<br>

#### restartCode : String
유저가 입력하는 코드를 담아두는 필드

<br>

### 메소드
#### checkInputNumber(inputString: String)
##### 개요
입력으로 들어온 값의 형식이 제대로 되었는지 확인한다.

##### 반환
입력 형식이 잘못됐다면, `IllegalArgumentException()`을 반환한다.

<br>

#### inputNumber() : MutableList<Int>
##### 개요
정답으로 사용할 값을 입력받는다.
userNumber에 저장한 후, 저장한 값을 반환한다.

##### 반환
MutableList<Int>의 형태로 입력받은 값을 반환

<br>

#### inputRestartNumber()
##### 개요
재시작 코드로 사용할 값을 입력받고 `restartCode`에 저장한다.

##### 반환
없음.

<br>

#### checkRestart() : Boolean
##### 개요
입력받은 `restartCode` 를 확인한다.
확인한 결과를 Boolean으로 반환한다.

##### 반환
1이면 true, 2면 false를 반환한다.
만약 그 외의 값이 들어오면 `IllegalArgumentException`을 반환한다.

<br>

## System

### 필드 

#### computer
Computer 클래스의 인스턴스

<br>

#### user
User 클래스의 인스턴스

<br>

#### winFlag
승리 조건

<br>

### 메소드

#### game()
##### 개요
게임 전체 루프를 관리한다.

##### 반환
없음.

<br>

#### askRestart()
##### 개요
사용자에게 재시작 여부를 물어보고, 여부에 따라 재시작한다.

##### 반환
없음.

<br>

#### restartGame()
##### 개요
게임을 재시작한다.

##### 반환
없음.
