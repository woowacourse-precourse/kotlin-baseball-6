package baseball.model.validation

typealias Predicate = (String) -> Boolean

internal enum class InputError(val message: String) {
    NotPositiveNumber("양의 정수만 입력 가능합니다."),
    DuplicateNumber("똑같은 숫자는 입력할 수 없습니다."),
    InvalidLength("3개의 숫자만 입력해주세요."),
    OutOfRangeNumber("1~9까지의 숫자만 입력 가능합니다.")
}

internal abstract class BaseValidation : Validation {

    protected abstract val predicate: Predicate
    protected abstract val error: InputError

    override fun check(value: String) {
        value.validateOrThrow()
    }

    private fun String.validateOrThrow() {
        require(predicate.invoke(this)) { error.message }
    }
}

internal class DuplicateNumberValidation : BaseValidation() {

    override val predicate: Predicate = { s -> !s.hasDuplicatedNumbers() }
    override val error: InputError = InputError.DuplicateNumber

    private fun String.hasDuplicatedNumbers(): Boolean {
        val numberSet = mutableSetOf<Char>()
        this.forEach { number ->
            if (numberSet.contains(number)) {
                return true
            }
            numberSet.add(number)
        }
        return false
    }
}

internal class InvalidLengthValidation : BaseValidation() {

    override val predicate: Predicate = { s -> s.length == 3 }
    override val error: InputError = InputError.InvalidLength
}

internal class PositiveNumberValidation : BaseValidation() {

    override val predicate: Predicate = { s -> s.isPositiveInt() }
    override val error: InputError = InputError.NotPositiveNumber

    private fun String.isPositiveInt(): Boolean =
        runCatching { this.toInt() > 0 }
            .getOrDefault(false)
}

internal class OutOfRangeNumberValidation : BaseValidation() {

    private val validNumbers = (1..9).toList()

    override val predicate: Predicate = { numberString -> numberString.isNumberOutOfRange() }
    override val error: InputError = InputError.OutOfRangeNumber

    private fun String.isNumberOutOfRange(): Boolean =
       this.all { char ->
           validNumbers.contains(char.toString().toInt())
       }
}