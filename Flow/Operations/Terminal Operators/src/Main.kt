import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main(): Unit = runBlocking {
    val numbers = (1..10).asFlow()

    val sum = numbers.reduce { a, b -> a + b }
    println(sum)
}