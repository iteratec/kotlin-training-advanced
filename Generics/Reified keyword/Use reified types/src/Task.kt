inline fun <reified T : Pokemon> filterByType(pokemons: List<Pokemon>): List<T> {
   return pokemons.filter { it is T }.map { it as T }
}

open class Pokemon(val name: String) {
    override fun toString(): String = name
}
class WaterPokemon(name: String): Pokemon(name)
class FirePokemon(name: String): Pokemon(name)