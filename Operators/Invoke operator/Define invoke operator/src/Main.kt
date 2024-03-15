class Pokemon(
    val name: String,
    val position: Int = 0,
    val size: Int = 1
) {
    override fun toString(): String {
        return "$name is at position $position and has size $size"
    }
}

class Transform(
    val positionChange: Int = 0,
    val scaleChange: Int = 1
) {
    operator fun invoke(pokemon: Pokemon): Pokemon = Pokemon(
        name = pokemon.name,
        position = pokemon.position + positionChange,
        size = pokemon.size * scaleChange
    )
}

fun main() {
    val moveForwardAndScale = Transform(positionChange = 1, scaleChange = 2)

    val pikachu = Pokemon(name = "Pikachu", position = 3, size = 1)
    println(moveForwardAndScale(pikachu))

    val charmander = Pokemon(name = "Charmander", position = 1, size = 2)
    println(moveForwardAndScale(charmander))
}