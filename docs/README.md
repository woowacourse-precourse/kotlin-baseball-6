### 기능 구현 목록
1. 임의의 세 숫자 입력받기
   1. 에러 처리
      1. 숫자 외의 다른 문자를 입력 받으면 에러
      2. 3개의 숫자가 아니면 에러
      3. 서로 다른 숫자가 아니면 에러
   2. computer 서로 다른 임의의 세개 숫자 랜덤 뽑기
2. ball과 strike 갯수 구하기
   1. computer에 사용자가 입력한 숫자가 있는지 확인
      2. 있다면 위치까지 같은지 확인 (리스트의 indexOf)
   
3. replay
   while(play)인 동안 게임 계속 진행
   1. strike == 3 일 때,
      replay 여부 질문, 
      1. play == 1이면 
         다시 반복,
      2. play == 2라면 
         play = false로 하고 break로 while문 종료

4. refactoring
   1. makeRandomNumber
      computer 랜덤 숫자 생성
   2. printResult
      ball과 strike 갯수 출력

5. Exception
   추가 예외 처리
   