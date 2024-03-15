import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun testSolution() {
        var incPower = PowerLevel(50)
        assertEquals(++incPower, PowerLevel(51))
        assertEquals(incPower, PowerLevel(51))

        var decPower = PowerLevel(50)
        assertEquals(--decPower, PowerLevel(49))
        assertEquals(decPower, PowerLevel(49))

        assertEquals(-PowerLevel(50), PowerLevel(-50))
    }
}