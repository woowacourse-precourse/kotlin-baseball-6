package baseball.model.validation

private val validations by lazy {
    listOf<Validation>(
        NumberValidation(),
        OutOfRangeNumberValidation(),
        InvalidLengthValidation(),
        DuplicateNumberValidation()
    )
}

fun String.checkValidation() {
    validations.forEach { validation -> validation.check(this) }
}