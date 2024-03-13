class Pokeball<T : Pokemon> {

    private var pokemon: T? = null

    fun catch(pokemon: T) {
        if (pokemon.hp < 50) {
            this.pokemon = pokemon
            println("${pokemon.name} caught successfully!")
        } else {
            println("${pokemon.name} escaped!")
        }
    }

    fun getPokemon(): T? = this.pokemon
}

open class Pokemon(val name: String, val hp: Int) {
    override fun toString(): String = name
}
class Pikachu(hp: Int) : Pokemon("Pikachu", hp = hp) {
    var currentVoltage: Int = 12
}

fun main() {
    val healthyPikachu = Pikachu(hp = 80)
    val weakenedPikachu = Pikachu(hp = 20)

    // Pikaball is a special pokeball that catches only Pikachu
    val pikaball = Pokeball<Pikachu>()
    pikaball.catch(healthyPikachu)
    pikaball.catch(weakenedPikachu)

    println("Pokeball contains currently ${pikaball.getPokemon()}.")
}
