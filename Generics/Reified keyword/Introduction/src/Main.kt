open class Pokemon(val name: String) {
    override fun toString(): String = name
}
class WaterPokemon(name: String): Pokemon(name)
class FirePokemon(name: String): Pokemon(name)

fun <T: Pokemon> containsPokemonType(list: List<Pokemon>): Boolean {
    // Won't compile, because T will be erased at runtime
    return list.any { it is T }
}

fun main() {
    val pokemons = listOf(
        WaterPokemon(name = "Squirtle"),
        WaterPokemon(name = "Staryu"),
        FirePokemon(name = "Charmander")
    )

    val hasWaterPokemon = containsPokemonType<WaterPokemon>(pokemons)
    println(hasWaterPokemon)
}