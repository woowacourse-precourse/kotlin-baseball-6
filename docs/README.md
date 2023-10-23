# 기능 구현 목록

```
∙ 게임 시작
  ◦ 게임시작 문구를 출력한다.
	◦ 컴퓨터의 규칙에 맞는 고유의 숫자를 정한다(2).

∙ 게임 진행
	◦ 사용자는 3자리의 숫자를 입력한다.(3)
		▫︎ 사용자의 입력이 3자리가 아니면 예외처리한다(1).
		▫︎ 사용자의 입력이 숫자가 아니면 예외처리한다(1).
		▫︎ 사용자의 각 자리의 숫자가 1부터 9까지의 숫자가 아닐 시 예외처리한다(1).
		▫︎ 사용자의 입력 중 중복된 숫자가 존재하면 예외처리한다(1).
	◦ 사용자의 입력과 컴퓨터의 입력을 비교한다.
		▫︎ 이 과정에서 같은 수가 같은 자리에 있으면 그 개수만큼 스트라이크를 출력한다.
		▫︎ 이 과정에서 같은 수가 다른 자리에 있으면 그 개수만큼 볼을 출력한다.
		▫︎ 이 과정에서 같은 수가 전혀 없다면 낫싱을 출력한다.
	◦ 게임 종료 여부를 확인한다.
		▫︎ 사용자의 숫자와 컴퓨터의 숫자가 정확히 일치하여 3스트라이크라는 문구가 출력되었다면 게임 종료로 넘어간다.
		▫︎ 만약 정확하게 일치하지 않았다면 사용자의 입력으로 다시 넘어간다.

∙ 게임 종료
	◦ 게임 종료 문구를 출력한다.
	◦ 사용자는 1 또는 2의 숫자를 입력한다(3).
		▫︎ 1을 입력하였을 시 게임을 재시작한다.
		▫︎ 2를 입력하였을 시 게임을 종료한다(4).
		▫︎ 1 또는 2의 입력이 아닐 시 예외처리한다(1).

(1) 예외 처리는 IllegalArgumentException을 발생시키며 어플리케이션을 종료한다.
(2) 컴퓨터의 숫자를 정하기 위해서는 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
(3) 사용자의 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
(4) 프로그램 종료 시 System.exit()를 호출하지 않는다.
```


<br><br>

# 구조
```
Application.kt, User.class, Computer.class, Game.class 총 4개로 구성되어있음.

∙ Application.kt : Game.class를 호출하여 게임시작

∙ User.class
	◦ inputUserNumber() : 사용자의 입력을 받고, 유효성 검사를 하는 함수
	◦ decideGame() : 사용자의 입력을 받고, 유효성을 검사한 뒤, 재시작/종료 여부를 반환하는 함수.
	◦ checkValidUserNumber() : 사용자의 입력의 유효성을 검사하는 함수(3자리인지, 숫자인지, 중복된 수가 없는지)
	◦ validateLength() : 사용자의 입력이 3자리수인지 확인하는 함수
	◦ validateNumber() : 사용자의 입력 중 각 자리의 숫자가 1부터 9까지의 숫자인지 확인하는 함수
	◦ validateUnique() : 사용자의 입력 중 중복된 숫자가 없는지 확인하는 함수
	◦ checkValidRestartNumber : 사용자의 입력의 유효성을 검사하는 함수(1 또는 2의 숫자인지)

∙ Computer.class
	◦ setComputerNumber() : 컴퓨터의 숫자를 랜덤하게 정하는 함수
	◦ countStrikeAndBall() : 스트라이크와 볼의 수를 확인하는 함수
	◦ checkGameState() : 스트라이크가 3인지 확인하여 게임종료 여부를 확인하는 함수

∙ Game.class
	◦ printGameStartMessage() : 게임시작 문구를 출력하는 함수
	◦ gameStart() : 숫자야구 게임 로직을 수행하는 함수
	◦ printHint() : 힌트(볼, 스트라이크의 수)를 출력하는 함수
	◦ printGameEndMessage() : 게임종료 문구를 출력하는 함수
```