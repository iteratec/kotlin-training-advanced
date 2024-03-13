open class Pokemon(val sound: String)
class Pikachu : Pokemon("Pika pika") {
    fun thunderShock() {
        println("Pikachu used thunder shock!")
    }
}

class Pokeball<T : Pokemon>(private val pokemon: T?) {
    fun examinePokeballSounds() {
        if (pokemon != null) {
            println("Pokeball produces a quiet ${pokemon.sound}")
        } else {
            println("Pokeball is silent as a grave.")
        }
    }
}