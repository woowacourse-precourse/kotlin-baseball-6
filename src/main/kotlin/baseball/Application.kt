package baseball
import camp.nextstep.edu.missionutils.Randoms
// 랜덤숫자 추출을 위한 임포트
import camp.nextstep.edu.missionutils.Console

// 사용자로부터 값을 입력받기 위한 임포트


fun main() {
    var gameStop = false
    // 게임 계속진행할지 판단 변수
    var resetFlag = true
    // 게임 재시작여부 판단 변수
    var targetNumList = mutableListOf<Int>()
    // 타겟숫자를 담기위한 리스트 변수
    var inputNumList = mutableListOf<Int>()
    // 예측숫자를 담기위한 리스트 변수
    var result = ""
    // 결과출력 변수
    var resetNum = 0
    // 게임 재시작 선택 판단을 위한 숫자 변수

    while(gameStop == false){
        if (resetFlag == true) {
            gameStartMessage()
        }
        // 1. 게임시작 메시지 출력 함수 호출

        if(resetFlag == true){
            targetNumList.clear()
            // 새 게임이 시작되면, 새로운 타겟넘버를 추출 할 수 있도록, 비워줌
        }
        targetNumList = getRandomNumber(targetNumList)
        // 2. 타겟숫자 추출 함수 호출 후 리턴
        inputNumList = userInputNumber(inputNumList)
        // 3. 사용자 숫자입력 함수 호출 후 리턴

        if (inputNumList.isNotEmpty()) {
            result = twoNumberCheck(targetNumList, inputNumList)
            // 4. 예외가 아닌, 정상적인 숫자가 리스트에 있을때만,두 숫자리스트 비교 함수 호출
            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                try{
                    resetNum = Console.readLine().toInt()
                } catch (e: IllegalArgumentException) {
                    println("[게임종료] 숫자가 아닌 문자가 포함되어 있습니다.")
                    //gameStop = true
                    // 게임 종료를 위해 게임스탑으로 변경
                    break
                    System.out
                    // 예외 처리 후 애플리케이션 종료
                }

                if(resetNum == 1) {
                    println("[게임 재시작] 게임 재시작 선택하셨습니다.")
                    inputNumList.clear()
                    // 예측숫자 리스트 비움
                    resetFlag = true
                    // 게임 재시작을 위해 리셋플래그 변경
                    continue
                } else if (resetNum == 2){
                    print("[게임종료] 게임종료를 선택하셨습니다.")
                    gameStop = true
                    // 게임 종료를 위해 게임스탑으로 변경
                    break
                    System.out
                } else {
                    throw IllegalArgumentException()
                    try {
                    } catch (e:IllegalArgumentException){
                        print("[게임 종료] 1이나 2가 아닌 숫자를 입력하셨습니다.")
//                    gameStop = true
                        // 게임 종료를 위해 게임스탑으로 변경
                        break
                        System.out
                    }

                }
            } else {
                resetFlag = false
                // 게임 계속진행을 위해 리셋플래그 변경
            }
        } else {
            gameStop = true
        }
    }
}




fun gameStartMessage(){
    println("=====================================")
    println("[숫자 야구 게임]")
    println("-------------------------------------")
    println("숫자 야구 게임을 시작합니다.")
}
fun getRandomNumber(targetNumList: MutableList<Int>) : MutableList<Int> {
    var randomNum = 0
    // 랜덤숫자용 변수

    while (targetNumList.size < 3){
        randomNum = Randoms.pickNumberInRange(1, 9)
        // 1~9까지 숫자 추출

        if (randomNum !in targetNumList) {
            // 타겟넘버리스트에 랜덤숫자가 있는지 체크해서
            targetNumList.add(randomNum) // 없으면 리스트에 추가
        }
    }
    println("")
    //println("타겟넘버 리스트 : ${targetNumList}")
    return targetNumList
}
fun userInputNumber(inputNumList: MutableList<Int>) : MutableList<Int> {
    var inputNum = 0
    // 예측숫자용 변수
    var textNumList = listOf<Char>()
    // 추가 확인을 위한 리스트 변수(숫자→문자)
    var flag = true
    // 루프 진행 종료를 판단할 변수

    while(flag) {
        print("서로 다른 숫자만 3개 입력해주세요 :    ")

        try {
            inputNum = Console.readLine().toInt()
        } catch (e: IllegalArgumentException) {
            println("숫자가 아닌 문자가 포함되어 있습니다. 게임 종료")
            inputNumList.clear()
            // 예측숫자 리스트 비움
            flag = false
            //게임중단으로 변경
            break
            System.out
            // 예외 처리 후 애플리케이션 종료
        }


        textNumList = inputNum.toString().toList()
        // 추가 처리를 위해, 텍스트형 리스트로 임시 변환
        if (textNumList.count() != 3) {
            throw IllegalArgumentException()
            try {
            } catch (e: IllegalArgumentException){
                println("[게임 종료] 3개 숫자가 아니거나 앞자리에 0이 포함되어 있습니다")
                inputNumList.clear()
                // 예측숫자 리스트 비움
                flag = false
                //게임중단으로 변경
                continue
                System.out
                // 3개 숫자가 아니거나 앞자리에 0이 포함될 경우, 게임종료
            }
        } else if(textNumList.distinct().count() < 3 || '0' in textNumList){
            throw IllegalArgumentException()
            try {
            } catch (e: IllegalArgumentException) {
                println("[게임 종료] 숫자가 중복이거나 0이 포함되어 있습니다")
                println("1부터 9까지 숫자만 가능합니다.")
                inputNumList.clear()
                // 예측숫자 리스트 비움
                flag = false
                //게임중단으로 변경
                continue
                System.out
                // 중복 숫자가 있거나 0이 포함될 경우, 게임종료
            }
        }

        inputNumList.clear()
        // 무한 루프로, 3개 초과하여 있을수 있으므로, 리스트 비워줌
        for (textNum in textNumList) {
            inputNumList.add(textNum.digitToInt())
        }
        break// 여기까지 왔다면, while문 종료 필요
    }
    return inputNumList
}
fun twoNumberCheck(num1: MutableList<Int>, num2: MutableList<Int>): String{
    var strikeCount = 0
    // 스트라이크 갯수 카운팅 변수
    var ballCount = 0
    // 볼 갯수 카운팅 변수
    var resultText = ""

    for (i in 0..(num1.size-1)){
        for(k in 0..(num2.size-1)){
            if(num1.get(i) == num2.get(k) && i == k){
                strikeCount++
            } else if(num1.get(i) == num2.get(k) && i != k){
                ballCount++
            }
        }
    }

    if(ballCount == 0 && strikeCount != 0 ) {
        resultText = "${strikeCount}스트라이크"
    } else if(ballCount != 0 && strikeCount == 0){
        resultText = "${ballCount}볼"
    } else if(ballCount != 0 && strikeCount != 0){
        resultText = "${ballCount}볼 ${strikeCount}스트라이크"
    } else {
        resultText = "낫싱"
    }
    println(resultText)
    return resultText
}

