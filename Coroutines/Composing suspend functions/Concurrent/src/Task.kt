import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val duration = measureTimeMillis {
        val first = async { calculateFirstValue() }
        val second = async { calculateSecondValue() }
        println("Result: ${first.await() + second.await()}")
    }
    println("Duration: $duration")
}

suspend fun calculateFirstValue(): Int {
    delay(1000L)
    return 46
}

suspend fun calculateSecondValue(): Int {
    delay(1000L)
    return 13
}

