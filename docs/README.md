## 기능 목록
* 컴퓨터가 사용하는 랜덤 숫자 호출
  * 랜덤 합수 호출 시 missionutils.Randoms의 pickNumberInRange 사용
* 사용자에게 입력 받은 후 strike 와 ball 구분
  * 입력시 missionutils.Console의 readLine 사용
* strike == 3 일시 게임 종류
* 게임 종류 후 사용자 입력 받아 재시작 및 완전 종료
  * 1일 경우 재시작, 2일 경우 종료 -> 그외 숫자는 조건 없음
    * (임의로 그 외 숫자 입력시 재입력 추가) 
* 잘못된 값 구분 -> IllegalArgumentException 
  * 숫자가 아닌 경우
  * 입력된 값이 3자리 초과 또는 미만
  * 중복이 있는 경우(서로 다른 3개의 숫자 입)