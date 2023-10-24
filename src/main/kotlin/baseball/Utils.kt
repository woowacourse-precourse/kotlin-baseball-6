class Utils {
    companion object {
        fun stringToIntList(str: String) : MutableList<Int> {
            val ret : MutableList<Int> = mutableListOf()

            while (ret.size < str.length) {
                ret.add(Character.getNumericValue(str[ret.size]))
            }
            return ret
        }
    }
}