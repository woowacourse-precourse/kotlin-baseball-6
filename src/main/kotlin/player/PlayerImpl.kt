package player

class PlayerImpl : Player {
    private var _baseballNumber: String = ""
    override val baseballNumber: String
        get() = _baseballNumber

    override fun setBaseballNumber(inputBaseballNumber: String) {
        TODO("Not yet implemented")
    }
}