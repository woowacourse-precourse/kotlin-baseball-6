-컴퓨터 랜덤수 정하기 #ComputerNumber      
-숫자 맞추기 3개(이상한 값 입력시 -IllegalArgumentException 발생시킨후 앱종료) #GuessNumber()        
-입력 값에 대한 결과출력(1스,1볼 /다 맞히면 종료)	 #Result()  
-게임 끝난후 재시작, 종료를 구분하는 1,2 		#GameRestart()  

- 컴퓨터 랜덤 수 정하기 pickNumberInRange() 사용, 함수 #randomNumber
- 입력받기 readline()사용, 1~9숫자 and 중복x and 3자리, 아니면 IllegalArgumentException 발생, 클래스 #InputNumber
- 비교하기 같은자리 스트라이크,  다른자리볼, 없으면 낫싱, 3스트라이크시 축하말 #CompareNumber  
- 다맞추면 재시작 or 종료 #reOrStop