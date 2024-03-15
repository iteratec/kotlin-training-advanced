data class Potion(val attack: Int, val defense: Int) {

    operator fun plus(other: Potion): Potion = Potion(
        attack = attack + other.attack,
        defense = defense + other.defense
    )

    operator fun times(scale: Int): Potion = Potion(
        attack = scale * attack,
        defense = scale * defense
    )
}