package baseball.constants

object GameConfig {
    const val BASEBALL_DIGITS = 3
    val BASEBALL_RANGE = CharRange('1', '9')
    const val BASEBALL_RANGE_FIRST = 1
    const val BASEBALL_RANGE_LAST = 9


    const val MENU_DIGITS = 1
    val MENU_RANGE = CharRange('1', '2')
    const val MENU_RANGE_FIRST = 1
    const val MENU_RANGE_LAST = 2

    const val EMPTY_STRING = ""
    const val DELIMITER = ", " // "B, S"
}
/*
    val BaseballRange = CharRange(
        (BASEBALL_RANGE_FIRST + '0'.code).toChar(),
        (BASEBALL_RANGE_LAST + '0'.code).toChar(),
    )
    val MenuRange = CharRange(
        (MENU_RANGE_FIRST + '0'.code).toChar(),
        (MENU_RANGE_LAST + '0'.code).toChar(),
    )
*/