import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class Test {
    @Test
    fun testSolution() {
        assertTrue(isInfoComplete(PokemonInfo(name = "Pikachu", description = "Cute mouse")))
        assertTrue(isInfoComplete(PokemonInfo(
            name = StringBuilder("Pikachu"),
            description = StringBuilder("Cute mouse")))
        )
        assertFalse(isInfoComplete(PokemonInfo(name = "Pikachu", description = null)))
        assertFalse(isInfoComplete(PokemonInfo(name = null, description = "Cute mouse")))
        assertFalse(isInfoComplete(PokemonInfo(name = null, description = null)))
    }
}