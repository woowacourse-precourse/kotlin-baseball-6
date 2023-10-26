package baseball.domain

enum class Hint(value: String) {

    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private val _value = value

    val value: String
        get() = _value

}