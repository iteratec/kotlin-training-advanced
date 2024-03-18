import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertTrue


class Test {
    @Test
    fun testSolution() {
        val time = measureTimeMillis { main() }

        assertTrue(time < 2000)
    }
}