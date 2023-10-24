package baseball.model

sealed interface MatchResult {

    data class Success(val comment: String) : MatchResult

    data class Fail(val comment: String) : MatchResult
}