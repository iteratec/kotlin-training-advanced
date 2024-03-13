class Pokeball<in T> {
    fun catch(pokemon: T) {
        println("Caught a pokemon $pokemon")
    }
}

open class Pokemon(val name: String) {
    override fun toString(): String = name
}
class Pikachu : Pokemon("Pikachu")

fun main() {
    val pokeball: Pokeball<Pikachu> = Pokeball<Pokemon>()
    pokeball.catch(Pikachu())
}
