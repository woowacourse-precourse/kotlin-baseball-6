package baseball

fun convertStringToMutableList(num: String):MutableList<Int>{
    return num.map { it.toString().toInt() }.toMutableList()
}