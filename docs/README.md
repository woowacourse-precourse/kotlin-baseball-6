# 미션 - 숫자 야구

## 🚀 기능 목록

### 1. 입력 예외 처리 : `processInputWithException()`
**요구사항** : 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.   
- 숫자 이외의 값을 입력 받을 경우 ex) abc123, dog&cat, ...
- 서로 다른 숫자가 3개가 아닐 경우 ex) 131, 12345, 5675, 12 ...