package baseball

fun convertStringToHashMap(num: String):HashMap<Int, Int>{
    var hashMap = HashMap<Int, Int>()
    for (i in num.indices) {
        val char = num[i]
        hashMap[i] = char.code
    }
    return hashMap
}