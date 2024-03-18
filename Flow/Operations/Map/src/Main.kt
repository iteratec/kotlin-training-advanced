import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val numbers = (1..10).asFlow()

    numbers.map { "number $it" }
            .collect { println(it) }
}
