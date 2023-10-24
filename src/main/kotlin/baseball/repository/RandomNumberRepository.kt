package baseball.repository

import baseball.domain.RandomNumber

class RandomNumberRepository {
    private lateinit var randomNumber: RandomNumber

    fun saveRandomNumber(number: Int) {
        randomNumber = RandomNumber(number)
    }

    fun loadRandomNumber(): RandomNumber {
        return randomNumber
    }
}