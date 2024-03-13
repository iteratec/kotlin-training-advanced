import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class Test {
    @Test
    fun testSolution() {
        val pokemons = listOf(
            FirePokemon(name = "Charmander"),
            FirePokemon(name = "Charizard"),
            WaterPokemon(name = "Squirtle")
        )

        val waterPokemons = filterByType<WaterPokemon>(pokemons)
        assertTrue(waterPokemons.map { it.name }.containsAll(listOf("Squirtle")))

        val firePokemons = filterByType<FirePokemon>(pokemons)
        assertTrue(firePokemons.map { it.name }.containsAll(listOf("Charmander", "Charizard")))
    }
}