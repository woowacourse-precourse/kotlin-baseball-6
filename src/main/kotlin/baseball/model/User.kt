package baseball.model

class User {
    //사용자 입력 저장
    fun guess( input : String? ): MutableList<Int> {
        val user = mutableListOf<Int>()
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException()
        }
        else if (input.matches(Regex("\\d{3}"))) {
            val charSet = HashSet<Char>()
            for (number in input) {
                if (charSet.contains(number)) {
                    throw IllegalArgumentException()
                }
                charSet.add(number)
                user.add(Character.getNumericValue(number))
            }
        }
        else {
            throw IllegalArgumentException()
        }
        return user
    }
}