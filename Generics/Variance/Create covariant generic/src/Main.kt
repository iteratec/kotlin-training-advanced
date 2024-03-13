class Pokeball<out T>(private val pokemon: T) {
    fun getCaughtPokemon(): T = pokemon
}

open class Pokemon(val sound: String)
class Pikachu : Pokemon("Pika pika")

fun main() {
    val pokeball: Pokeball<Pokemon> = Pokeball<Pikachu>(Pikachu())
    val cachedPokemon: Pokemon = pokeball.getCaughtPokemon()
    println("Pokeball produces a quiet sound: ${cachedPokemon.sound}")
}
