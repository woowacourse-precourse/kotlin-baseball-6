package baseball.constants

object GameConfig {
    const val BASEBALL_DIGITS = 3
    val BASEBALL_RANGE = CharRange('1', '9')
    const val BASEBALL_RANGE_FIRST = 1
    const val BASEBALL_RANGE_LAST = 9

//    val BaseballRange = CharRange(
//        BASEBALL_RANGE_FIRST.toChar(),
//        BASEBALL_RANGE_LAST.toChar(),
//    )

    const val MENU_DIGITS = 1
    val MENU_RANGE = CharRange('1', '2')
    const val MENU_RANGE_FIRST = 1
    const val MENU_RANGE_LAST = 2

//    val MenuRange = CharRange(
//        MENU_RANGE_FIRST.toChar(),
//        MENU_RANGE_LAST.toChar(),
//    )

    const val EMPTY_STRING = ""
    const val DELIMITER = ", " // "B, S"

}
