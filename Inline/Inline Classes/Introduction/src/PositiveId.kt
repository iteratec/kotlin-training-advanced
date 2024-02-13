@JvmInline
value class PositiveId(private val value: Long) {

    init {
        require(value >= 0) { "Only positive Longs are allowed." }
    }

    fun print() = print("My ID is $value")
}
