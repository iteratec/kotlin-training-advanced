import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun lazyPokemon(block: () -> Pokemon): ReadOnlyProperty<Any?, Pokemon> = LazyPokemonProperty(block)

// Create a LazyPokemonProperty delegate, that will create a Pokemon instance using the provided
// factory function. The instance should be created only once when the property is accessed.
class LazyPokemonProperty(private val block: () -> Pokemon) : ReadOnlyProperty<Any?, Pokemon> {

    private lateinit var pokemon: Pokemon

    override fun getValue(thisRef: Any?, property: KProperty<*>): Pokemon {
        if (!this::pokemon.isInitialized) {
            pokemon = block()
        }

        return pokemon
    }
}



fun main() {
    val pokemon: Pokemon by lazyPokemon {
        println("Creating a Pikachu")
        Pokemon(name = "Pikachu")
    }

    println(pokemon.name)
    println(pokemon.name)
}

class Pokemon(val name: String)