import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testSolution() {
        val first = Potion(attack = 5, defense = 3)
        val second = Potion(attack = 2, defense = 7)
        assertEquals(first + second, Potion(attack = 7, defense = 10))
        assertEquals(second + first, Potion(attack = 7, defense = 10))
        assertEquals(first * 0, Potion(attack = 0, defense = 0))
        assertEquals(first * 2, Potion(attack = 10, defense = 6))
        assertEquals(second * 3, Potion(attack = 6, defense = 21))
    }
}