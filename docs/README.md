# 📮숫자 야구 프로그램 FLOW

```kotlin
fun main(){
    
    /* 야구 게임 시작 */
    
    do {
        
        TODO("1. computer 랜덤수 생성")
        
        do {

            TODO("2. 숫자 입력 받기 - 예외처리")
            TODO("3. 숫자 비교 하기")
            TODO("4. 결과 출력 하기")
            
        }while (strike < 3)
        
        TODO("5. 종료 여부 확인 - 예외처리")
        
    }while (isExit)
    
    
    
}
```

## 1️⃣ computer 랜덤수 생성 :: `generateRandomNumber()`

- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

---

## 2️⃣ 숫자 입력 받기 - 예외처리 :: `processInputWithException()`

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

```
- 숫자 이외의 값을 입력 받을 경우 예외 처리 ex) abc123, dog&cat, ...
- 서로 다른 숫자가 3개가 아닐 경우 예외 처리 ex) 131, 12345, 5675, 12 ...
```
---

## 3️⃣ 숫자 비교 하기 :: `baseballGame()`

```
- 스트라이크 : 같은 자리의 숫자가 동일할 경우
- 볼 : 컴퓨터와 동일한 숫자의 개수 - 스트라이크 개수
- 낫싱: 스트라이크의 개수 0 && 볼의 개수 0
```

---

## 4️⃣ 결과 출력 하기 :: `displayResult()`

```
- 낫싱일 경우 볼과 스트라이크의 개수 출력 x
- 출력순서, 볼 -> 스트라이크의 개수
```

---

## 5️⃣ 종료여부 확인 - 예외 처리 :: 