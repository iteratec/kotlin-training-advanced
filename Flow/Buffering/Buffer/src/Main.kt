import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val numbers = flow {
        for (i in 1..5) {
            delay(100)
            emit(i)
        }
    }

    val time = measureTimeMillis {
        numbers.buffer().collect {
            delay(300)
            println(it)
        }
    }

    println("time used: $time ms")
}