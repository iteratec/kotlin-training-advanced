class PowerLevel(val value: Int) {

    operator fun inc(): PowerLevel = PowerLevel(value + 1)
    operator fun dec(): PowerLevel = PowerLevel(value - 1)
    operator fun unaryMinus(): PowerLevel = PowerLevel(-value)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PowerLevel

        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }
}