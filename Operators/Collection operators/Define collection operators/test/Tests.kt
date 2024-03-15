import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Test {
    @Test
    fun testSolution() {
        val team = Team(
            Pokemon(name = "Pikachu"),
            Pokemon(name = "Bulbasaur"),
            Pokemon(name = "Squirtle")
        )

        assertEquals(team[0], Pokemon(name = "Pikachu"))
        assertEquals(team[1], Pokemon(name = "Bulbasaur"))
        assertEquals(team[2], Pokemon(name = "Squirtle"))
        assertThrows<IndexOutOfBoundsException> { team[4] }

        team[1] = Pokemon(name = "Charmander")
        assertEquals(team[0], Pokemon(name = "Pikachu"))
        assertEquals(team[1], Pokemon(name = "Charmander"))
        assertEquals(team[2], Pokemon(name = "Squirtle"))

        assertTrue(Pokemon(name = "Pikachu") in team)
        assertTrue(Pokemon(name = "Charmander") in team)
        assertTrue(Pokemon(name = "Squirtle") in team)
    }
}