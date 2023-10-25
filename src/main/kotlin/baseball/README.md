숫자 야구 (kotlin)

1. generateTargetNumber():pickNumverInRange 함수를 사용해 1~9까지의 숫자 중 3개를 선정해, 숫자야구 게임에서의 정답이 되는 3자리 숫자를 만듭니다.
2. InputNumber(): 해당 함수는 Console.readLine()을 사용하여 사용자의 입력을 받습니다. 그 후, 입력값의 길이를 확인하고 입력값이 숫자로만 구성되어 있는지 검사합니다. 입력값이 3자리 숫자가 아니거나, 숫자로만 구성되지 않은 경우 "잘못된 값을 입력했습니다. 다시 입력하세요."라는 메시지를 출력하고 사용자로부터 올바른 입력을 다시 요청합니다. 만약 올바른 입력이 들어온 경우, 해당 숫자들을 정수 리스트로 변환하고 반환합니다.
3. calculateResult(): 이 함수는 generateTargetNumber()과 InputNumber()에서 찾은 2개의 값 targetNumber와 inputNumber를 비교하여 strike와 ball의 갯수를 counting하는 함수입니다. 반복문에서 targetNumber와 inputNumber의 같은 인덱스 값을 비교하며 같을 경우 strike 추가, 다를 경우 ball 추가를 진행하고 결과에 따라 3스트라이크, ?볼 ?스트라이크, 낫싱의 결과를 출력합니다.
4. restartGame(): 이 함수는 3스트라이크가 나와 게임이 종료되었을 때, 한번 더 게임을 시작할 지, 이대로 게임을 종료할 지, 1 또는 2의 값을 받아 결정하는 함수입니다.