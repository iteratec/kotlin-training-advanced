import io.mockk.*
import kotlinx.coroutines.*
import org.junit.Assert.assertTrue
import org.junit.Test

class Test {
    @Test fun testSolution() = runBlocking {
        val name = mockk<Deferred<String>>()
        val points = mockk<Deferred<Int>>()

        coEvery { name.await() } returns "name"
        coEvery { points.await() } returns 123


        val result = getStats(name, points)
        assertTrue(result.contains("name"))
        assertTrue(result.contains("123"))

        coVerifyAll {
            name.await()
            points.await()
        }
    }
}
