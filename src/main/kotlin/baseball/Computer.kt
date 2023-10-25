package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer {
    companion object {
        fun createRandomNumbers(): MutableList<Int> {
            val randomNumbers = mutableListOf<Int>()
            while (randomNumbers.size < 3) {
                val randomNumber = Randoms.pickNumberInRange(1, 9)
                if (!randomNumbers.contains(randomNumber)) {
                    randomNumbers.add(randomNumber)
                }
            }
            throwsUserGameNumberInputError(randomNumbers)
            return randomNumbers
        }

        private fun throwsUserGameNumberInputError(randNumbers: List<Int>) {
            // 랜덤 값이 3자리가 아닐 경우 체크
            require(randNumbers.size == 3)

            // 랜덤 값 내에 중복 숫자가 있는 체크
            val hashSet = hashSetOf<Int>()
            randNumbers.forEach { i ->
                require(!hashSet.contains(i))
                hashSet.add(i)
            }
        }
    }
}