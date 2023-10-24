# 구현할 기능 목록   

## Function

### gameStart: Int
- 게임의 한 회차를 담당하는 기능
- generate_cnt 함수를 호출하여 컴퓨터의 숫자 목록을 생성
- 이후 플레이어의 입력을 받아 정수형으로 저장
- divide_num 함수를 호출하여 자리 수 별로 분할
- ball, strike 함수를 각각 호출하여 카운트 반환
- 결과 메세지를 띄운 후 3스트라이크까지 반복
- 0 ~ 9 범위 외의 숫자가 입력되거나 종료 후 재시작 시 1, 2 외의 숫자 입력 시 IllegalArgumentException 발생 후 종료
- 회차 종료 시 재시작 여부 반환

### divide_num: MutableList<Int>
- 입력 받은 숫자를 하나씩 끊어 mutableList에 저장 후 반환하는 기능
- 숫자가 3개가 아니거나 중복된 숫자가 있는 경우 IllegalArgumentException 호출 후 빈 리스트 반환

### generate_cnt: MutableList<Int>
- 컴퓨터의 숫자 목록을 생성 후 mutableList 형태로 반환하는 기능
- import한 라이브러리의 Randoms.pickNumberInRange()를 활용하여 숫자를 추출

### ball: Int
- ball 카운트를 계산하여 반환
- ball 카운트는 컴퓨터의 숫자 목록에 포함되지만 자리가 맞지 않는 경우 1 증가

### strike: Int
- strike 카운트를 계산하여 반환
- strike 카운트는 컴퓨터의 숫자 목록에 포함되며 자리가 일치하는 경우 1 증가

