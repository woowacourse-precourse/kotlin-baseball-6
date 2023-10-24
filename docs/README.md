### 기능구현

```makeRandomNumber()```

컴퓨터가 생성한 랜덤 숫자 3개를 저장하는 함수이다.

```guessNumber()```

- 플레이어가 숫자를 입력하면 입력한 숫자의 조건을 따진다.
- 서로 다른 세자리 숫자가 아니라면 ```IllegalArgumentException``` 발생
- 세자리 숫자가 아니라면 ```IllegalArgumentException``` 발생
- 숫자가 아닌 값이라면 ```NumberFormatException```으로 판단하고 ```IllegalArgumentException``` 발생


```checkInput()```

guessNumber() 에서 입력받은 string 값이 3자리수인지, 숫자인지, 서로 다른 숫자인지 판단한다. 만약 모든 조건을 만족한다면 inputArray 라는 새로운 리스트에 숫자를 저장해준다. 

```printResult()```

컴퓨터가 랜덤으로 생성한 숫자와 플레이어가 입력한 숫자를 비교해 strike 값과 ball 값을 만들어준다. while문을 통해 strike 값이 3이 되기 전까지 플레이어에게 매번 새로운 숫자를 입력받는다. 

```gameOver()```

strike 값이 3이 되면 새로운 입력값을 받는다. 1은 게임을 새로 시작하는 조건이고, 2는 게임을 종료하는 조건이다. 정수 1또는 2값을 전달한다.
