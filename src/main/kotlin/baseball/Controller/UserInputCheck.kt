package baseball.Controller

import baseball.View.UserInput

class UserInputCheck
{

    fun userInputValidation():MutableList<Int>
    {
        var userinput: String=""
        userinput= UserInput().inputUserNumber()
        val userNumbers = mutableListOf<Int>()
        userinput?.forEach {
            it.toString().toIntOrNull()?.let {
                    num ->
                userNumbers.add(num)
            }
        }

        if(!only3Number(userNumbers))
            throw IllegalArgumentException("1에서9사이의 숫자 3개를입력해주세요")
        else if (duplicateNumbers(userNumbers))
            throw IllegalArgumentException("중복되지 않는 수를 입력해주세요")


        return userNumbers
    }


    private fun only3Number(userNumbers: MutableList<Int>): Boolean {
        return userNumbers.size == 3
    }
    private fun duplicateNumbers(userNumbers: MutableList<Int>): Boolean {
        val set = HashSet<Int>()
        for (num in userNumbers) {
            if (!set.add(num)) {
                return true
            }
        }
        return false
    }
}