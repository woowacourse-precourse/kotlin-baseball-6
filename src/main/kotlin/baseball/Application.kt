package baseball

import camp.nextstep.edu.missionutils.*;
import kotlin.arrayOf

fun main() {
    //TODO("프로그램 구현";

    while(true){

        val count:Int = 3;
        var answer = arrayOf<Int?>(); // 임의의 정답

        // 1. 난수 생성(1부터 9까지의 임의의 3자리 수 생성)
        var i:Int = 0;
        while(i < count) {
            var randomNums = (Randoms.pickNumberInRange(1, 9));
            if(answer.contains(randomNums)){
                continue;
            }else{
                answer += randomNums;
                i++;
            }
        }
//        println(answer.contentToString()); //

        // 2. 게임 시작 ///////////////////////
        System.out.println("숫자 야구 게임을 시작합니다.");


        while (true){

            // 3. 사용자 입력///////////////////////
            System.out.print("숫자를 입력해주세요 : ");
            var temp:String = Console.readLine();

            if(temp.length != count){
                throw IllegalArgumentException("입력 3자리 오류")
            }

            var input = arrayOf<Int?>();
            for(n in 0..count-1){
                input += temp[n].toString().toInt();
                for(a in 0..n-1){
                    if(input[a] == input[n]){
                        throw IllegalArgumentException("입력 중복 오류")
                    }
                }
            }

            var strike:Int = 0;
            var ball:Int = 0;
            var index = arrayListOf<Int>();

            //4. 스트라이크 검사
            for(n in 0..2){
                if(input[n] == answer[n]) {
                    strike++;
                    index.add(n);
                }
            }

            // 5. 게임 종료
            if(strike == 3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                var again:Int = Console.readLine().toInt();
                if(again == 1) {
                    break;
                }else if(again == 2){
                    return;
                }else{
                    throw IllegalArgumentException("입력 오류")
                }
            } else {
                for(n in 0..count-1){
                    if(index.contains(i))
                        continue;

                    for(k in 0..count-1){
                        if(index.contains(k)){
                            continue;
                        }

                        if(answer[n] == input[k]){
                            ball++;
                        }
                    }
                }
            }
            if(strike + ball == 0){
                System.out.println("낫싱");
            }else if(strike == 0){
                System.out.println("${ball}볼");
            }else if(ball == 0){
                System.out.println("${strike}스트라이크");
            }else{
                System.out.println("${ball}볼 ${strike}스트라이크");
            }

        }
    }
}
