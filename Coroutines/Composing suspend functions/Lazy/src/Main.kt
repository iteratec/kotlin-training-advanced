import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val duration = measureTimeMillis {
        val first = async(start = CoroutineStart.LAZY) { calculateFirstValue() }
        val second = async(start = CoroutineStart.LAZY) { calculateSecondValue() }
        second.start()
        println("Result: ${first.await() + second.await()}")
    }
    println("Duration: $duration")
}

suspend fun calculateFirstValue(): Int {
    println("execute first")
    delay(1000L)
    return 46
}

suspend fun calculateSecondValue(): Int {
    println("execute second")
    delay(1000L)
    return 13
}

