// Make the function generic, so it can work with a list of Pokemon or any of its subtypes
fun <T : Pokemon> getHealthiestPokemon(list: List<T>): T? {
    return list.maxByOrNull { it.hp }
}

open class Pokemon(val name: String, val hp: Int)
class Pikachu(hp: Int): Pokemon(name = "Pikachu", hp = hp)
class Meow(hp: Int): Pokemon(name = "Meow", hp = hp)