import kotlin.test.Test
import kotlin.test.assertTrue

class Test {
    @Test
    fun testSolution() {
        val pokemons: List<Pokemon> = listOf(
            Pikachu(hp = 50),
            Meow(hp = 100),
            Pikachu(hp = 20),
        )

        val pikachus: List<Pikachu> = listOf(
            Pikachu(hp = 10),
            Pikachu(hp = 20),
        )

        assertTrue(getHealthiestPokemon(pokemons)?.hp == 100)
        assertTrue(getHealthiestPokemon(pikachus)?.hp == 20)
        assertTrue(getHealthiestPokemon(listOf()) == null)
    }
}