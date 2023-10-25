package baseball

fun String.distinctString() = this
    .toList()
    .distinct()
    .joinToString(separator = "")