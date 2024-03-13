# Use reified types
In this exercise you will implement a simple `filterByType` function, that takes a `List<Pokemon>` as a parameter
and creates a new list that contains only the pokemons assignable to the pokemon
type specified as the type parameter.

```kotlin
open class Pokemon(val name: String) {
  override fun toString(): String = name
}
class WaterPokemon(name: String): Pokemon(name)
class FirePokemon(name: String): Pokemon(name)

fun main() {
    val pokemons = listOf(
        FirePokemon(name = "Charmander"),
        FirePokemon(name = "Charizard"),
        WaterPokemon(name = "Squirtle")
    )
    
    // Should contain Charmander and Charizard
    val firePokemons: List<Pokemon> = filterByType<FirePokemon>(pokemons)
}
```

Use `reified` and `inline` keywords to enable preservation of the type parameter.