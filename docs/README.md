# 구현할 기능 목록

1. 맞춰야 할 3자리 수를 생성하는 함수
   - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 사용
   - 중복 없는 3자리 숫자
2. 사용자 입력을 받는 합수
   - camp.nextstep.edu.missionutils.Console의 readLine() 사용
   - 잘못된 값 입력시 IllegalArgumentException발생 후 종료
3. 입력의 점수를 출력하는 함수
    - 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
    - 스트라이크 3개일때 현재 게임 종료
4. 전체 흐름 제어 함수
    - 게임 종료시 다음 게임을 시작할지 판단