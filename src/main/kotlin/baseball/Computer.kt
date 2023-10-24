package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    companion object {
        // 서로 다른 3자리의 난수 리스트를 생성하여 반환
        fun generateRandomNumber(): MutableList<Int> {
            val computer = mutableListOf<Int>()
            while (computer.size < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber)
                }
            }
            return computer
        }

        // 컴퓨터의 숫자와 사용자의 숫자를 비교하여 결과 출력 및 승리 유무 반환
        fun matchTweNumbers(computer: List<Int>, user: List<Int>): Boolean {
            val strikeCount: Int = howManyStrikes(computer, user)
            val ballCount: Int = howManyBalls(computer, user)

            // 조건에 따른 힌트를 사용자에게 출력

            return (strikeCount == 3)
        }

        // 스트라이크의 개수를 판별
        private fun howManyStrikes(computer: List<Int>, user: List<Int>): Int {
            var cnt: Int = 0
            // 숫자와 자리 모두 일치
            for ((idx, c) in computer.withIndex()) {
                if (c == user[idx]) {
                    cnt++
                }
            }
            return cnt
        }

        // 볼의 개수를 판별
        private fun howManyBalls(computer: List<Int>, user: List<Int>): Int {
            var cnt: Int = 0
            // 자리는 불일치, 숫자만 일치
            for ((idx, c) in computer.withIndex()) {
                if (user.contains(c) && c != user[idx]) {
                    cnt++
                }
            }
            return cnt
        }
    }
}